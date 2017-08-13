package com.pashkobohdan.spritzreaderpro.application.model.dto.book;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.pashkobohdan.spritzreaderpro.application.model.dto.common.CommonDTO;

import java.util.Date;

@DatabaseTable(tableName = "books")
public class BookDTO extends CommonDTO {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(canBeNull = false)
    private String name;
    @DatabaseField(canBeNull = false)
    private String author;
    @DatabaseField(canBeNull = false)
    private String text;
    @DatabaseField(canBeNull = false)
    private Integer length;
    @DatabaseField(foreign = true)
    private BookTitleImageDTO titleImageDTO;
    @DatabaseField(canBeNull = false)
    private Date createDate;
    @DatabaseField()
    private Date lastOpenDate;

    public BookDTO() {
    }

    public BookDTO(String name, String author, String text, BookTitleImageDTO titleImageDTO, Integer progress, Date createDate, Date lastOpenDate) {
        this.name = name;
        this.author = author;
        this.text = text;
        this.titleImageDTO = titleImageDTO;
        this.createDate = createDate;
        this.lastOpenDate = lastOpenDate;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public Integer getLength() {
        return length;
    }

    public BookTitleImageDTO getTitleImageDTO() {
        return titleImageDTO;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getLastOpenDate() {
        return lastOpenDate;
    }
}
