package com.pobitecoding.project.dao.loan;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.pobitecoding.project.vo.BookVO;
import com.pobitecoding.project.vo.LoanVO;

public class LoanDAOImpl implements LoanDAO {
    
    private static int loanCount = 1;
    
    private Map<Integer, LoanVO> dataSource;
    
    public LoanDAOImpl() {
        dataSource = new HashMap<>();
    }
    
    @Override
    public int create(LoanVO loanVO) {
        loanVO.setId(loanCount);
        dataSource.put(loanCount++, loanVO);
        return 1;
    }

    @Override
    public int delete(int id) {
        dataSource.remove(id);
        return 1;
    }

    @Override
    public int deleteByBookId(int id) {
        for (Map.Entry<Integer, LoanVO> entry : dataSource.entrySet()) {
            if (entry.getValue().getBookId() == id) {
                dataSource.remove(entry.getKey());
            }
        }
        return 1;
    }
    
    @Override
    public LoanVO read(int id) {
        return dataSource.get(id);
    }

    @Override
    public LoanVO readMem(int id) {
        for (LoanVO vo : dataSource.values()) {
            if (vo.getMemberId() == id) {
                return vo;
            }
        }
        return null;
    }

    @Override
    public LoanVO readBook(int id) {
        for (LoanVO vo : dataSource.values()) {
            if (vo.getBookId() == id) {
                return vo;
            }
        }
        return null;
    }

    @Override
    public List<LoanVO> readAll() {
        return dataSource.entrySet()
                .stream()
                .map(entry -> entry.getValue())
                .collect(Collectors.toList());
    }

    @Override
    public List<LoanVO> readBorrow() {
        return dataSource.entrySet()
                .stream()
                .filter(entry -> entry.getValue().isPossibleBorrow() == true)
                .map(entry -> entry.getValue())
                .collect(Collectors.toList());
    }

    @Override
    public List<LoanVO> readLoan() {
        return dataSource.entrySet()
                .stream()
                .filter(entry -> entry.getValue().isPossibleBorrow() == false)
                .map(entry -> entry.getValue())
                .collect(Collectors.toList());
    }

    @Override
    public int update(LoanVO loanVO) {
        // do nothing
        return 0;
    }
}