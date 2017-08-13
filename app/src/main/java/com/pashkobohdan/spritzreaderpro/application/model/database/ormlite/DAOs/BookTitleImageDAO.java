package com.pashkobohdan.spritzreaderpro.application.model.database.ormlite.DAOs;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.pashkobohdan.spritzreaderpro.application.model.dto.book.BookTitleImageDTO;

import java.sql.SQLException;
import java.util.List;

public class BookTitleImageDAO extends BaseDaoImpl<BookTitleImageDTO, Integer> {

    public BookTitleImageDAO(ConnectionSource connectionSource, Class<BookTitleImageDTO> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public List<BookTitleImageDTO> getAllBookTitleImageDAOList() throws SQLException {
        return this.queryForAll();
    }
}
