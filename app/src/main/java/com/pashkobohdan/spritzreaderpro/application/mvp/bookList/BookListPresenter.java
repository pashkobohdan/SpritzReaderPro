package com.pashkobohdan.spritzreaderpro.application.mvp.bookList;

import android.content.Context;

import com.arellomobile.mvp.InjectViewState;
import com.pashkobohdan.spritzreaderpro.application.model.dataExecutors.BookListDataExecutor;
import com.pashkobohdan.spritzreaderpro.application.model.dto.book.BookDTO;
import com.pashkobohdan.spritzreaderpro.application.mvp.bookList.view.BookListView;
import com.pashkobohdan.spritzreaderpro.application.mvp.common.AbstractPresenter;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

import javax.inject.Inject;

@InjectViewState
public class BookListPresenter extends AbstractPresenter<BookListView> {

    @Inject
    BookListDataExecutor bookListDataExecutor;

    @Inject
    Context context;

    @Inject
    public BookListPresenter() {
    }

    @Override
    protected void onFirstViewAttach() {
        getViewState().showRefreshingMask();
        bookListDataExecutor.execute(new Subscriber<List<BookDTO>>() {//TODO add DefaultSubscriber !
            @Override
            public void onSubscribe(Subscription s) {

            }

            @Override
            public void onNext(List<BookDTO> bookDTOs) {
                getViewState().hideRefreshingMask();
                getViewState().showBookList(bookDTOs);
            }

            @Override
            public void onError(Throwable t) {
                getViewState().hideRefreshingMask();
                getViewState().showDataExecutionError();
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
