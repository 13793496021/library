package com.libraryms.pojo;


public class Book {

    int book_id;
    String book_name;
    String book_write;
    String book_type;
    int book_number;
    String book_identifier;
    String book_introduction;
    String write_introduction;

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_number(int book_number) {
        this.book_number = book_number;
    }

    public int getBook_number() {
        return book_number;
    }

    public void setBook_type(String book_type) {
        this.book_type = book_type;
    }

    public String getBook_type() {
        return book_type;
    }

    public void setBook_write(String book_write) {
        this.book_write = book_write;
    }

    public String getBook_write() {
        return book_write;
    }

    public void setBook_identifier(String book_identifier) {
        this.book_identifier = book_identifier;
    }

    public String getBook_identifier() {
        return book_identifier;
    }

    public void setBook_introduction(String book_introduction) {
        this.book_introduction = book_introduction;
    }

    public String getBook_introduction() {
        return book_introduction;
    }

    public void setWrite_introduction(String write_introduction) {
        this.write_introduction = write_introduction;
    }

    public String getWrite_introduction() {
        return write_introduction;
    }
}
