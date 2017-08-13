package com.pashkobohdan.spritzreaderpro.application.model.database.ormlite.DAOs;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.pashkobohdan.spritzreaderpro.application.model.dto.book.BookDTO;

import java.sql.SQLException;
import java.util.List;

public class BookDAO extends BaseDaoImpl<BookDTO, Integer> {

    public BookDAO(ConnectionSource connectionSource, Class<BookDTO> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public List<BookDTO> getAllBookDTOList() throws SQLException {
        return this.queryForAll();
    }
}
