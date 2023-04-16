package com.pobitecoding.project.loan;

import java.util.List;
import com.pobitecoding.project.vo.BookVO;
import com.pobitecoding.project.vo.LoanVO;

public interface LoanDAO {
    
    public int create(LoanVO loanVO);

    public int delete(int id);
    
    public int deleteByBookId(int id);

    public LoanVO read(int id);
    
    public LoanVO readMem(int id);
    
    public LoanVO readBook(int id);

    public List<LoanVO> readAll();
    
    public List<LoanVO> readBorrow();
    
    public List<LoanVO> readLoan();
    
}
