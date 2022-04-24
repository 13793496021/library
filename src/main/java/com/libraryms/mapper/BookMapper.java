package com.libraryms.mapper;

import com.libraryms.pojo.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {

    List<Book> getByBooks();

    List<Book> selectBooks(Book book);

    int insertBook(Book book);

    Book getByBookId(Book book);

    Book getByBookIdOrName(Book book);

    int updateBook(Book book);

    int deleteBook(Book book);

    List<Book> getListBook(Book book);
}
