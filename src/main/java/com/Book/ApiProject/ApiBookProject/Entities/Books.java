package com.Book.ApiProject.ApiBookProject.Entities;

import org.springframework.stereotype.Component;

@Component
public class Books {
    private int id;       // changed to camelCase
    private String title; // changed to camelCase
    private String author;

    // Constructor with parameters
    public Books(int id, String title, String author) {
        this.id = id;       // updated to match field name
        this.title = title; // updated to match field name
        this.author = author;
    }

    // No-args constructor
    public Books() {
    }

    // Getters and setters
    public int getId() {
        return id;       // updated to match field name
    }

    public void setId(int id) {
        this.id = id;    // updated to match field name
    }

    public String getTitle() {
        return title;    // updated to match field name
    }

    public void setTitle(String title) {
        this.title = title; // updated to match field name
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Override toString method
    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +     // updated to match field name
                ", title='" + title + '\'' + // updated to match field name
                ", author='" + author + '\'' +
                '}';
    }
}
