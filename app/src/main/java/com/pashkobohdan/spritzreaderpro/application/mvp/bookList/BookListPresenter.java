package com.pashkobohdan.spritzreaderpro.application.mvp.bookList;

import com.arellomobile.mvp.InjectViewState;
import com.pashkobohdan.spritzreaderpro.application.mvp.bookList.view.BookListView;
import com.pashkobohdan.spritzreaderpro.application.mvp.common.AbstractPresenter;

import javax.inject.Inject;

@InjectViewState
public class BookListPresenter extends AbstractPresenter<BookListView> {

    @Inject
    public BookListPresenter() {
    }

    @Override
    protected void onFirstViewAttach() {
        //TODO show list here
    }
}
