package com.pobitecoding.project.service;

import java.util.List;
import com.pobitecoding.project.dao.BookDAOImpl;
import com.pobitecoding.project.vo.BookVO;

public class BookServiceImpl implements BookService {
    
    private BookDAOImpl bookDAO;
    
    public BookServiceImpl() {
        bookDAO = new BookDAOImpl();
    }
    
    @Override
    public boolean create(BookVO bookVO) {
        return bookDAO.create(bookVO) > 0;
    }

//    @Override
//    public boolean update(int id, BookVO bookVO) {
//        return bookDAO.update(id, bookVO) > 0;
//    }

    @Override
    public boolean delete(int id) {
        return bookDAO.delete(id) > 0;
    }

    @Override
    public List<BookVO> readAll() {
        return bookDAO.readAll();
    }
}