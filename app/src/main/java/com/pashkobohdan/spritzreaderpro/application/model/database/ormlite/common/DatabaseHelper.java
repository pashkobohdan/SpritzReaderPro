package com.pashkobohdan.spritzreaderpro.application.model.database.ormlite.common;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.pashkobohdan.spritzreaderpro.application.model.database.ormlite.DAOs.BookDAO;
import com.pashkobohdan.spritzreaderpro.application.model.database.ormlite.DAOs.BookTitleImageDAO;
import com.pashkobohdan.spritzreaderpro.application.model.dto.book.BookDTO;
import com.pashkobohdan.spritzreaderpro.application.model.dto.book.BookTitleImageDTO;

import java.sql.SQLException;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String TAG = DatabaseHelper.class.getSimpleName();

    //имя файла базы данных который будет храниться в /data/data/APPNAME/DATABASE_NAME.db
    private static final String DATABASE_NAME ="spritzProReader.db";

    //с каждым увеличением версии, при нахождении в устройстве БД с предыдущей версией будет выполнен метод onUpgrade();
    private static final int DATABASE_VERSION = 1;

    //ссылки на DAO соответсвующие сущностям, хранимым в БД
    private BookDAO bookDAO = null;
    private BookTitleImageDAO bookTitleImageDAO = null;

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Выполняется, когда файл с БД не найден на устройстве
    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource){
        try
        {
            TableUtils.createTable(connectionSource, BookDTO.class);
            TableUtils.createTable(connectionSource, BookTitleImageDTO.class);
        }
        catch (SQLException e){
            Log.e(TAG, "error creating DB " + DATABASE_NAME);
            throw new RuntimeException(e);
        }
    }

    //Выполняется, когда БД имеет версию отличную от текущей
    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVer,
                          int newVer){
        try{
            //Так делают ленивые, гораздо предпочтительнее не удаляя БД аккуратно вносить изменения
            TableUtils.dropTable(connectionSource, BookDTO.class, true);
            TableUtils.dropTable(connectionSource, BookTitleImageDTO.class, true);
            onCreate(db, connectionSource);
        }
        catch (SQLException e){
            Log.e(TAG,"error upgrading db "+DATABASE_NAME+"from ver "+oldVer);
            throw new RuntimeException(e);
        }
    }

    //синглтон для GoalDAO
    public BookDAO getGoalDAO() throws SQLException{
        if(bookDAO == null){
            bookDAO = new BookDAO(getConnectionSource(), BookDTO.class);
        }
        return bookDAO;
    }
    //синглтон для RoleDAO
    public BookTitleImageDAO getRoleDAO() throws SQLException{
        if(bookTitleImageDAO == null){
            bookTitleImageDAO = new BookTitleImageDAO(getConnectionSource(), BookTitleImageDTO.class);
        }
        return bookTitleImageDAO;
    }

    //выполняется при закрытии приложения
    @Override
    public void close(){
        super.close();
        bookDAO = null;
        bookTitleImageDAO = null;
    }
}
