package com.xin.chapter19.service;

import com.xin.chapter19.domain.Book;
import com.xin.chapter19.domain.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{


    /**
     * 类别列表集合
     * this implementation is not thread-safe
     */
    private List<Category> categories;

    /**
     * 书籍列表集合
     */
    private List<Book> books;

    public BookServiceImpl(){
        categories =new ArrayList<Category>();
        Category category1 = new Category(1,"java");
        Category category2 = new Category(2,"python");
        Category category3 = new Category(3,"Spring");
        categories.add(category1);
        categories.add(category2);
        categories.add(category3);

        books = new ArrayList<Book>();
        books.add(new Book(1L,"13134328675643","Java 学习笔记",category1,"xin fei"));
        books.add(new Book(2L,"27678678632423","python 学习笔记",category2,"xin yue"));
        books.add(new Book(3L,"32423456786543","Spring 学习笔记",category3,"xin xin"));


    }


    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public Category getCategory(int id) {
        for(Category category:categories){
            if(id == category.getId()){
                return category;
            }
        }
        return null;
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public Book save(Book book) {
        book.setId(getNextId());
        books.add(book);
        return book;
    }

    @Override
    public Book update(Book book) {
        int BookCount = books.size();
        for(int i = 0; i<BookCount; i++){
            Book saveBook = books.get(i);
            if(saveBook.getId() == book.getId()){
                books.set(i,book);
                return book;
            }
        }
        return null;
    }

    @Override
    public Book get(long id) {
        for(Book book: books){
            if(id == book.getId()){
                return book;
            }
        }
        return null;
    }

    @Override
    public long getNextId() {
        // need to be locked
        long id = 0L;
        for(Book book:books){
            long bookId = book.getId();
            if(bookId>id){
                id =bookId;
            }
        }
        return id+1;
    }
}
