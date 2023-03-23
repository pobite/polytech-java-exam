package com.pobitecoding.project.service.member;

import java.util.List;
import com.pobitecoding.project.dao.MemberDAOImpl;
import com.pobitecoding.project.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
    
    private MemberDAOImpl memberDAO;
    
    public MemberServiceImpl() {
        bookDAO = new MemberDAOImpl();
    }
    
    @Override
    public boolean create(MemberVO memberVO) {
        return bookDAO.create(memberVO) > 0;
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
    public List<MemberVO> readAll() {
        return bookDAO.readAll();
    }
}