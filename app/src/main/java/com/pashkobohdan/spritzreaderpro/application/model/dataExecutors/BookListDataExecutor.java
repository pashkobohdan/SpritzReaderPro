package com.pashkobohdan.spritzreaderpro.application.model.dataExecutors;

import com.pashkobohdan.spritzreaderpro.application.model.dataExecutors.common.CommonDataExecutor;
import com.pashkobohdan.spritzreaderpro.application.model.dto.book.BookDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
  
public class BookListDataExecutor extends CommonDataExecutor<BookDTO> {

    @Inject
    public BookListDataExecutor() {
    }

    @Override
    public List<BookDTO> getData() throws SQLException{
//        return databaseManager.getBookDAO().getAllBookDTOList();
        List<BookDTO> list  = new ArrayList<>();
        list.add(new BookDTO("Book 1", "author", "text, bla bla bla", null, 0, new Date(), new Date()));
        list.add(new BookDTO("Book 2", "Bogdan Pashko", "text, bla bla bla", null, 0, new Date(), new Date()));
        list.add(new BookDTO("Gone book", "Nobody ...", "text, bla bla bla", null, 0, new Date(), new Date()));

        return list;
    }
}
