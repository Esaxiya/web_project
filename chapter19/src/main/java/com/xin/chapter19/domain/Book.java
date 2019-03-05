package com.xin.chapter19.domain;

import java.io.Serializable;

/**
 * Book实体类、
 *
 */
public class Book implements Serializable {

    /**
     * serialVersionUID适用于Java的序列化机制。
     * Java的序列化机制是通过判断类的serialVersionUID来验证版本一致性的
     */
    private static  final long serialVersionUID = 1312112983719371829L;

    private long id;

    /**
     * 国际标准书号ISBN
     */
    private String isbn;

    /**
     * 书籍的名称
     */
    private String title;

    /**
     * 书籍的类别
     */
    private Category category;

    /**
     * 书籍的作者
     */
    private String author;

    public Book() {
    }

    public Book(long id, String isbn, String title, Category category, String author) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.category = category;
        this.author = author;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", category=" + category +
                ", author='" + author + '\'' +
                '}';
    }
}
