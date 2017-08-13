package com.pashkobohdan.spritzreaderpro.application.model.dto.book;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.pashkobohdan.spritzreaderpro.application.model.dto.common.CommonDTO;

import java.io.File;

@DatabaseTable(tableName = "bookTitleImages")
public class BookTitleImageDTO extends CommonDTO {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(canBeNull = false)
    private boolean isImage;
    @DatabaseField()
    private String color;
    @DatabaseField()
    private File image;

    public BookTitleImageDTO() {
    }

    public BookTitleImageDTO(String color) {
        this.isImage = false;
        this.color = color;
    }

    public BookTitleImageDTO(File image) {
        this.isImage = true;
        this.image = image;
    }

    public boolean isImage() {
        return isImage;
    }

    public String getColor() {
        return color;
    }

    public File getImage() {
        return image;
    }
}
