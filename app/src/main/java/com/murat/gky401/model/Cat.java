package com.murat.gky401.model;

public class Cat {
    private String id, image, owner;
    private int likes;

    public Cat(String id, String image, String owner, int likes) {
        this.id = id;
        this.image = image;
        this.owner = owner;
        this.likes = likes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
