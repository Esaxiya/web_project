package com.xin.chapter19.controller;

import com.sun.org.glassfish.gmbal.ParameterNames;
import com.xin.chapter19.domain.Book;
import com.xin.chapter19.domain.Category;
import com.xin.chapter19.service.BookService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Book实体的控制层
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    private static final Log logger = LogFactory.getLog(BookController.class);

    /**
     * 输入书籍信息
     */
    @RequestMapping(value = "/book_input")
    public String inputBook(Model model){
        List<Category> categories = bookService.getAllCategories();
        model.addAttribute("categories",categories);
        model.addAttribute("book",new Book());
        return "BookAndForm";
    }

    /**
     * 编辑书籍信息
     */
    @RequestMapping(value = "/book_edit/{id}")
    public String editBook(Model model, @PathVariable long id){
        List<Category> categories = bookService.getAllCategories();
        model.addAttribute("categories",categories);
        Book book = bookService.get(id);
        model.addAttribute("book",book);
        return "BookEditForm";

    }

    /**
     * 保存书籍信息
     */
    @RequestMapping(value = "/book_save")
    public String saveBook(@ModelAttribute Book book){
        Category category = bookService.getCategory(book.getCategory().getId());
        book.setCategory(category);
        bookService.save(book);
        return "redirect:/book_list";
    }

    /**
     * 更新书籍信息
     */
    @RequestMapping(value = "/book_update")
    public String updateBook(@ModelAttribute Book book){
        Category category = bookService.getCategory(book.getCategory().getId());
        book.setCategory(category);
        bookService.update(book);
        return "redirect:/book_list";
    }

    /**
     * 返回书籍列表展示
     */
    @RequestMapping("/book_list")
    public String listBooks(Model model){
        logger.info("正在请求book_list");
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("book",books);
        return "BookList";
    }

}
