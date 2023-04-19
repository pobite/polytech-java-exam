package com.pobitecoding.project.service.loan;

import java.util.List;
import com.pobitecoding.project.dao.loan.LoanDAO;
import com.pobitecoding.project.dao.loan.LoanDAOImpl;
import com.pobitecoding.project.vo.LoanVO;

public class LoanServiceImpl implements LoanService {
    
    private LoanDAO loanDAO;
    
    public LoanServiceImpl(LoanDAO loanDAO) {
        this.loanDAO = loanDAO;
    }
    
    @Override
    public boolean create(LoanVO loanVO) {
        return loanDAO.create(loanVO) > 0;
    }

    @Override
    public boolean delete(int id) {
        return loanDAO.delete(id) > 0;
    }
    
    @Override
    public boolean deleteByBookId(int id) {
        return loanDAO.deleteByBookId(id) > 0;
    }

    @Override
    public LoanVO read(int id) {
        return loanDAO.read(id);
    }

    @Override
    public LoanVO readMem(int id) {
        return loanDAO.readMem(id);
    }

    @Override
    public LoanVO readBook(int id) {
        return loanDAO.readBook(id);
    }

    @Override
    public List<LoanVO> readAll() {
        return loanDAO.readAll();
    }

    @Override
    public List<LoanVO> readBorrow() {
        return loanDAO.readBorrow();
    }

    @Override
    public List<LoanVO> readLoan() {
        return loanDAO.readLoan();
    }


}