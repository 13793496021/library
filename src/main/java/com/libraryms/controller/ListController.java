package com.libraryms.controller;

import com.libraryms.pojo.Book;
import com.libraryms.result.Response;
import com.libraryms.serviceimpl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ListController {

    @Autowired
    private BookServiceImpl bookService;
    //上传表数据
    @CrossOrigin
    @PostMapping(value = "api/booksMaintain/table")
    @ResponseBody
    public Response getBookTable() {
        try {
            List<Book> books= bookService.getByBooks();
            //System.out.println(bookService.getByBooks());
            return Response.yes(books);
        } catch (Exception e) {
            return Response.no("异常操作",e);
        }

    }
    //搜索
    @CrossOrigin
    @PostMapping(value = "api/selectBooks/select")
    @ResponseBody
    public Response selectBooks(@RequestBody Book requestBook) {
        try {
            List<Book> selectBooks = bookService.selectBooks(requestBook);
            //System.out.println(selectBooks);
            if(selectBooks.size() == 0) {
                return Response.no("未查询到该关键词的相关内容");
            } else {
                return Response.yes(selectBooks);
            }
        } catch (Exception e) {
            return Response.no("异常操作",e);
        }
    }
    //添加
    @CrossOrigin
    @PostMapping(value = "api/booksMaintain/insertBook")
    @ResponseBody
    public Response insertBooks(@RequestBody Book requestBook) {
        try {
            Book insertBook = bookService.getByBookIdOrName(requestBook);
            if(insertBook == null) {
                bookService.insertBook(requestBook);
                return Response.yes("添加成功");
            } else {
                return Response.no("书籍已存在");
            }
        } catch (Exception e) {
            return Response.no("异常操作",e);
        }
    }
    //获取选行内容
    @CrossOrigin
    @PostMapping(value = "api/booksMaintain/edit")
    @ResponseBody
    public Response getEditFrom(@RequestBody Book requestBook) {
        try {
            Book updateBooks = bookService.getByBookId(requestBook);
            if(updateBooks == null) {
                return Response.no("获取选行数据失败");
            } else {
                //System.out.println(updateBooks);
                return Response.yes("成功获取选行数据",updateBooks);
            }
        } catch (Exception e) {
            return Response.no("异常操作",e);
        }
    }
    //修改
    @CrossOrigin
    @PostMapping(value = "api/booksMaintain/updateBook")
    @ResponseBody
    public Response updateBooks(@RequestBody Book requestBook) {
        try {
            Book updateBook = bookService.getByBookId(requestBook);
            if(updateBook == null) {
                return Response.no("书籍不存在");
            } else {
                bookService.updateBook(requestBook);
                return Response.yes("修改成功");
            }
        } catch (Exception e) {
            return Response.no("异常操作",e);
        }

    }
    //删除
    @CrossOrigin
    @PostMapping(value = "api/booksMaintain/deleteBook")
    @ResponseBody
    public Response deleteBooks(@RequestBody Book requestBook) {
        try {
            Book deleteBook = bookService.getByBookId(requestBook);
            if(deleteBook == null) {
                return Response.no("书籍不存在");
            } else {
                bookService.deleteBook(requestBook);
                return Response.yes("删除成功");
            }
        } catch (Exception e) {
            return Response.no("异常操作",e);
        }

    }
    //浏览
    @CrossOrigin
    @PostMapping(value = "api/booksMaintain/browse")
    @ResponseBody
    public Response lookOverBooks(@RequestBody Book requestBook, HttpSession session) {
        try {
            List<Book> lookOverBook = bookService.getListBook(requestBook);
            if(lookOverBook.size() == 0) {
                return Response.no("查看失败");
            } else {
                session.setAttribute("session_book",lookOverBook);
                return Response.yes();
            }
        } catch (Exception e) {
            return Response.no("异常操作",e);
        }
    }
    //查看详情
    @CrossOrigin
    @PostMapping(value = "api/details")
    @ResponseBody
    public Response getDetails(HttpSession session) {
        if(session.getAttribute("session_book") != null) {
            try {
                List<Book> detailBook = (List<Book>) session.getAttribute("session_book");
                if(detailBook.size() == 0) {
                    return Response.no("跳转失败");
                } else {
                    session.removeAttribute("session_book");
                    return Response.yes("跳转成功",detailBook);
                }
            } catch (Exception e) {
                return Response.no("异常操作",e);
            }
        } else {
            return Response.no("跳转失败");
        }
    }
    //用户浏览
    @CrossOrigin
    @PostMapping(value = "api/selectBooks/browse")
    @ResponseBody
    public Response userLookOverBooks(@RequestBody Book requestBook, HttpSession session) {
        try {
            List<Book> lookOverUserBook = bookService.getListBook(requestBook);
            if(lookOverUserBook.size() == 0) {
                return Response.no("查看失败");
            } else {
                session.setAttribute("session_userBook",lookOverUserBook);
                return Response.yes();
            }
        } catch (Exception e) {
            return Response.no("异常操作",e);
        }

    }
    //用户查看详情
    @CrossOrigin
    @PostMapping(value = "api/userDetails")
    @ResponseBody
    public Response getUserDetails(HttpSession session) {
        if(session.getAttribute("session_userBook") != null) {
            try {
                List<Book> detailUserBook = (List<Book>) session.getAttribute("session_userBook");
                if(detailUserBook.size() == 0) {
                    return Response.no("跳转失败");
                } else {
                    session.removeAttribute("session_userBook");
                    return Response.yes("跳转成功",detailUserBook);
                }
            } catch (Exception e) {
                return Response.no("异常操作",e);
            }
        } else {
            return Response.no("跳转失败");
        }

    }

}











