package com.pobitecoding.project.dao.book;

import java.util.List;
import com.pobitecoding.project.vo.BookVO;
import com.pobitecoding.project.vo.LoanVO;

public interface BookDAO {
    
    public int create(BookVO bookVO);

    public int delete(int id);

    public BookVO read(int id);

    public List<BookVO> readAll();
    
    public List<BookVO> readBorrow();
    
    public List<BookVO> readLoan();
    
//    public LoanVO readLoan(int id);
//    
//    public List<LoanVO> readBorrow();
//    
//    public List<LoanVO> readLoan();
}