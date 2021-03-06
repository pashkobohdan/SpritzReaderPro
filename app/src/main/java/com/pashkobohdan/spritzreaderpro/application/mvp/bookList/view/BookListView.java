package com.pashkobohdan.spritzreaderpro.application.mvp.bookList.view;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.pashkobohdan.spritzreaderpro.application.model.dto.book.BookDTO;
import com.pashkobohdan.spritzreaderpro.application.mvp.bookList.BookListPresenter;
import com.pashkobohdan.spritzreaderpro.application.mvp.common.AbstractScreenView;

import java.util.List;

/**
 * Created by bohdan on 07.08.17.
 */
@StateStrategyType(SkipStrategy.class)
public interface BookListView extends AbstractScreenView<BookListPresenter> {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showBookList(List<BookDTO> bookDTOList);

    void addBook(int newBookPosition);

    void deleteBook(int deletedBookPosition);

    void showDataExecutionError();

    void showRefreshingMask();

    void hideRefreshingMask();
}
