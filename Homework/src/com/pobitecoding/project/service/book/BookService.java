package com.pobitecoding.project.service.book;

import java.util.List;
import com.pobitecoding.project.vo.BookVO;
import com.pobitecoding.project.vo.LoanVO;
import com.pobitecoding.project.vo.MemberVO;

public interface BookService {
    
    public boolean create(BookVO bookVO);

    public boolean delete(int id);
    
    public boolean update(BookVO bookVO);

    public BookVO read(int id);
    
    public List<BookVO> readAll();
    
    public List<BookVO> readBorrow();
    
    public List<BookVO> readLoan();
    
    
    
//    public LoanVO readLoan(int id);
//    
//    public List<LoanVO> readBorrow();
//      
//    public List<LoanVO> readLoan();
//    

}
