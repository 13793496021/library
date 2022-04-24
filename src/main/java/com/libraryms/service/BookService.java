package com.libraryms.service;

import com.libraryms.pojo.Book;

import java.util.List;

public interface BookService {

    List<Book> getByBooks();

    List<Book> selectBooks(Book book);

    int insertBook(Book book);

    Book getByBookId(Book book);

    Book getByBookIdOrName(Book book);

    int updateBook(Book book);

    int deleteBook(Book book);

    List<Book> getListBook(Book book);
}
