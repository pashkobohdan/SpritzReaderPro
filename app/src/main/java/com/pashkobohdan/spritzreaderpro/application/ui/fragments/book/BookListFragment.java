package com.pashkobohdan.spritzreaderpro.application.ui.fragments.book;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.pashkobohdan.spritzreaderpro.R;
import com.pashkobohdan.spritzreaderpro.application.SpritzProApplication;
import com.pashkobohdan.spritzreaderpro.application.mvp.bookList.BookListPresenter;
import com.pashkobohdan.spritzreaderpro.application.mvp.bookList.view.BookListView;
import com.pashkobohdan.spritzreaderpro.application.ui.fragments.common.AbstractScreenFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookListFragment extends AbstractScreenFragment<BookListPresenter> implements BookListView {

    @BindView(R.id.book_list_recycler_view)
    RecyclerView bookList;

    @InjectPresenter
    BookListPresenter presenter;

    @ProvidePresenter
    public BookListPresenter getSamplePresenter() {
        BookListPresenter presenter = presenterProvider.get();
        //TODO set data
        return presenter;
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
    }

    @Override
    public void onPresenterAttached(BookListPresenter presenter) {
        this.presenter = presenter;
    }
}
