package com.test;

import com.dao.BookDao;
import com.dao.impl.BookDaoImpl;
import com.pojo.Book;
import org.junit.Test;

import javax.sound.midi.SoundbankResource;
import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookDaoTest {
    private BookDao bookDao = new BookDaoImpl();
    @Test
    public void addBook() {
        bookDao.addBook(new Book(null, "明朝那些事儿", "william", new BigDecimal(48.5), 500, 600, "static/img/default.jpg"));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(7);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21, "明朝那些事儿", "当代明月", new BigDecimal(48.5), 500, 600, "static/img/default.jpg"));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(10));
    }

    @Test
    public void queryBooks() {
        for(Book book : bookDao.queryBooks()) {
            System.out.println(book);
        }
    }
}