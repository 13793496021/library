package com.libraryms.serviceimpl;

import com.libraryms.mapper.BookMapper;
import com.libraryms.pojo.Book;
import com.libraryms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> getByBooks() {
        return bookMapper.getByBooks();
    }

    @Override
    public List<Book> selectBooks(Book book) {
        return bookMapper.selectBooks(book);
    }

    @Override
    public int insertBook(Book book) {
        return bookMapper.insertBook(book);
    }

    @Override
    public Book getByBookId(Book book) {
        return bookMapper.getByBookId(book);
    }

    @Override
    public Book getByBookIdOrName(Book book) {
        return bookMapper.getByBookIdOrName(book);
    }

    @Override
    public int updateBook(Book book) {
        return bookMapper.updateBook(book);
    }

    @Override
    public int deleteBook(Book book) {
        return bookMapper.deleteBook(book);
    }

    @Override
    public List<Book> getListBook(Book book) {
        return bookMapper.getListBook(book);
    }
}
