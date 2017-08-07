package com.pashkobohdan.spritzreaderpro.application.presentation.bookList;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.pashkobohdan.spritzreaderpro.application.presentation.bookList.view.BookListView;

import javax.inject.Inject;

@InjectViewState
public class BookListPresenter extends MvpPresenter<BookListView> {

    @Inject
    public BookListPresenter() {
    }

    @Override
    protected void onFirstViewAttach() {
        //TODO show list here
    }
}
