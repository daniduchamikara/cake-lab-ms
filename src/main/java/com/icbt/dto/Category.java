package com.icbt.dto;

public class Category {

    int id;
    String categoryCode;
    String description;

    public Category(int id, String categoryCode, String description) {
        this.id = id;
        this.categoryCode = categoryCode;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
