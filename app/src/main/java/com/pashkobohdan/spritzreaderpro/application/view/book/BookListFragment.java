package com.pashkobohdan.spritzreaderpro.application.view.book;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.pashkobohdan.spritzreaderpro.R;
import com.pashkobohdan.spritzreaderpro.application.presentation.bookList.BookListPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookListFragment extends MvpFragment {

    @BindView(R.id.book_list_recycler_view)
    RecyclerView bookList;

    @InjectPresenter
    BookListFragment presenter;

    @ProvidePresenter
    public BookListPresenter getSamplePresenter() {
        return new BookListPresenter();//TODO realize presentProvider !
    }

    public static final BookListFragment getNewInstance() {
        //TODO realize save() method
        return new BookListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //TODO inject(this) method
        super.onCreate(savedInstanceState);
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

        //TODO
    }
}
