package com.pobitecoding.project.service.loan;

import java.util.List;
import com.pobitecoding.project.vo.BookVO;
import com.pobitecoding.project.vo.LoanVO;

public interface LoanService {
    
    public boolean create(LoanVO loanVO);

    public boolean delete(int id);
    
    public boolean deleteByBookId(int id);
    
    public boolean update(LoanVO loanVO);

    public LoanVO read(int id);
    
    public LoanVO readMem(int id);
    
    public LoanVO readBook(int id);

    public List<LoanVO> readAll();
    
    public List<LoanVO> readBorrow();
    
    public List<LoanVO> readLoan();
}
