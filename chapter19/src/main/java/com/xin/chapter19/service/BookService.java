package com.xin.chapter19.service;

import com.xin.chapter19.domain.Book;
import com.xin.chapter19.domain.Category;

import java.util.List;

/**
 * Book实体的业务层
 */

public interface BookService {
    /**
     * 获取全部类别的list集合
     */
    List<Category> getAllCategories();

    /**
     * 根据指定id查询书籍的类别
     */
    Category getCategory(int id);

    /**
     * 获取全部书籍的list集合
     */
    List<Book> getAllBooks();

    /**
     * 保存书籍
     */
    Book save(Book book);

    /**
     * 更新指定的书籍
     */
    Book update(Book book);

    /**
     * 根据id查询获取指定的书籍
     */
    Book get(long id);

    /**
     * 获取下一个id编号
     */
    long getNextId();

}
