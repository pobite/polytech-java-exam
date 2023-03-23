package com.pobitecoding.project.dao.book;

import java.util.ArrayList;
import java.util.List;
import com.pobitecoding.project.vo.BookVO;
import com.pobitecoding.project.vo.MemberVO;

public class BookDAOImpl implements BookDAO {
    
    private List<BookVO> bookList;
    
    public BookDAOImpl() {
        bookList = new ArrayList<>();
    }

    @Override
    public int create(BookVO bookVO) {
        bookList.add(bookVO);
        return 1;
    }

    @Override
    public int delete(int id) {
        for (BookVO book : bookList) {
            if (book.getId() == id) {
                bookList.remove(book);
                return 1;
            }
        }
        return 0;
    }

    @Override
    public BookVO read(int id) {
        for (BookVO book : bookList) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    @Override
    public List<BookVO> readAll() {
        return bookList;
    }
}