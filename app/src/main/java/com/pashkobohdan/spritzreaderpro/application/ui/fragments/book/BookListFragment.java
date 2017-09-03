package com.pashkobohdan.spritzreaderpro.application.ui.fragments.book;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.github.clans.fab.FloatingActionMenu;
import com.pashkobohdan.spritzreaderpro.R;
import com.pashkobohdan.spritzreaderpro.application.SpritzProApplication;
import com.pashkobohdan.spritzreaderpro.application.model.dto.book.BookDTO;
import com.pashkobohdan.spritzreaderpro.application.mvp.bookList.BookListPresenter;
import com.pashkobohdan.spritzreaderpro.application.mvp.bookList.view.BookListView;
import com.pashkobohdan.spritzreaderpro.application.ui.adapter.AbstractListItemHolder;
import com.pashkobohdan.spritzreaderpro.application.ui.dialog.BookEditDialog;
import com.pashkobohdan.spritzreaderpro.application.ui.fragments.book.widget.BookListItemWidget;
import com.pashkobohdan.spritzreaderpro.application.ui.fragments.common.AbstractListFragment;
import com.pashkobohdan.spritzreaderpro.application.utils.ui.DialogUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BookListFragment extends AbstractListFragment<BookListPresenter, BookDTO> implements BookListView {

    private static final int mScrollOffset = 4;

    @InjectPresenter
    BookListPresenter presenter;
    @Inject
    Provider<BookListItemWidget> bookListItemWidgetProvider;

    @BindView(R.id.book_list_recycler_view)
    RecyclerView bookListRecyclerView;
    @BindView(R.id.fragment_book_list_waitem_mask)
    ProgressBar waiterProgressBar;
    @BindView(R.id.add_book_fab_menu)
    FloatingActionMenu addBookActionMenu;

    @OnClick(R.id.add_book_from_file_fab)
    void addBookFromFileButtonClicked() {
        addBookActionMenu.close(true);
        //TODO open select file chooser
    }

    @OnClick(R.id.add_book_create_fab)
    void createBookButtonClicked() {
        addBookActionMenu.close(true);
        showCreateNewBookDialog();
    }

    @OnClick(R.id.add_book_download_fab)
    void downloadBookButtonClicked() {
        addBookActionMenu.close(true);
        //TODO open download book dialog/fragment
    }

    private ListAdapter adapter;

    @ProvidePresenter
    public BookListPresenter getSamplePresenter() {
        return presenterProvider.get();
    }

    public static BookListFragment getNewInstance() {
        return new BookListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        SpritzProApplication.INSTANCE.getApplicationComponent().inject(this);
        super.onCreate(savedInstanceState);
//        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setHeaderTitle("Book list fragment");

        adapter = new ListAdapter(new ArrayList<>());

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        bookListRecyclerView.setLayoutManager(mLayoutManager);
        bookListRecyclerView.setAdapter(adapter);

        bookListRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (Math.abs(dy) > mScrollOffset) {
                    if (dy > 0) {
                        addBookActionMenu.hideMenu(true);
                    } else {
                        addBookActionMenu.showMenu(true);
                    }
                }
            }
        });
    }

    @Override
    public void onPresenterAttached(BookListPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showBookList(List<BookDTO> bookDTOList) {
        adapter.setArrayData(bookDTOList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void addBook(int newBookPosition) {
        adapter.notifyItemChanged(newBookPosition);
    }

    @Override
    public void deleteBook(int deletedBookPosition) {
        adapter.notifyItemChanged(deletedBookPosition);
        adapter.notifyItemChanged(deletedBookPosition + 1);//TODO think about this
    }

    private void showCreateNewBookDialog() {
        BookEditDialog dialog = new BookEditDialog(getContext(), null, bookDTO -> {
            //TODO send to presenter
            Toast.makeText(getContext(), "new book created !", Toast.LENGTH_SHORT).show();
        }, () -> {
            Toast.makeText(getContext(), "dialog cancelled !", Toast.LENGTH_SHORT).show();
            //TODO nothing ?
        });
        dialog.show();
    }

    @Override
    public void showDataExecutionError() {
        DialogUtils.showAlert("Error", "Data execution error, try later", getContext(), null);//TODO move to string.xml
    }

    @Override
    public void showRefreshingMask() {
        waiterProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRefreshingMask() {
        waiterProgressBar.setVisibility(View.GONE);
    }

    @Override
    public AbstractListItemHolder<BookDTO> getItemHolder(ViewGroup parent) {
        return bookListItemWidgetProvider.get().getHolder(parent, (data) -> {
            //TODO add presenter method !
            Toast.makeText(getContext(), "clicked: " + data.getName(), Toast.LENGTH_SHORT).show();
        });
    }
}
