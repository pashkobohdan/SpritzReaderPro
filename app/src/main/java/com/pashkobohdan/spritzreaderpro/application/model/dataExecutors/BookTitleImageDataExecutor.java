package com.pashkobohdan.spritzreaderpro.application.model.dataExecutors;

import com.pashkobohdan.spritzreaderpro.application.model.dataExecutors.common.CommonDataExecutor;
import com.pashkobohdan.spritzreaderpro.application.model.dto.book.BookTitleImageDTO;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

public class BookTitleImageDataExecutor extends CommonDataExecutor<BookTitleImageDTO> {


    @Inject
    public BookTitleImageDataExecutor() {
    }

    @Override
    public List<BookTitleImageDTO> getData() throws SQLException{
        return databaseManager.getBookTitleImageDAO().getAllBookTitleImageDAOList();
    }
}
