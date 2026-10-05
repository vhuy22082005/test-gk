package com.example.test_gk;

public class Item {
    private final int id;
    private final String title;
    private final String description;
    private final String price;
    private final String category;
    private final int imageResId;
    private final int itemHeightDp;

    public Item(int id, String title, String description, String price, String category, int imageResId, int itemHeightDp) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.category = category;
        this.imageResId = imageResId;
        this.itemHeightDp = itemHeightDp;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public int getImageResId() {
        return imageResId;
    }

    public int getItemHeightDp() {
        return itemHeightDp;
    }
}