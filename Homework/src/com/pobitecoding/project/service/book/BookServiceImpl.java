package com.pobitecoding.project.service.book;

import java.util.List;
import com.pobitecoding.project.dao.book.BookDAO;
import com.pobitecoding.project.dao.book.BookDAOImpl;
import com.pobitecoding.project.vo.BookVO;
import com.pobitecoding.project.vo.LoanVO;

public class BookServiceImpl implements BookService{
    
    private BookDAO bookDAO;
    
    public BookServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }
    
    @Override
    public boolean create(BookVO bookVO) {
        return bookDAO.create(bookVO) > 0;
    }

    @Override
    public boolean delete(int id) {
        return bookDAO.delete(id) > 0;
    }

    @Override
    public BookVO read(int id) {
        return bookDAO.read(id);
    }

    @Override
    public List<BookVO> readAll() {
        return bookDAO.readAll();
    }
    
    @Override
    public List<BookVO> readBorrow() {
        return bookDAO.readBorrow();
    }

    @Override
    public List<BookVO> readLoan() {
        return bookDAO.readLoan();
    }
//    @Override
//    public List<LoanVO> readBorrow() {
//        return bookDAO.readBorrow();
//    }
//    
//    @Override
//    public List<LoanVO> readLoan() {
//        return bookDAO.readLoan();
//    }
//
//    @Override
//    public LoanVO readLoan(int id) {
//        return bookDAO.readLoan(id);
//    }
//    

}
