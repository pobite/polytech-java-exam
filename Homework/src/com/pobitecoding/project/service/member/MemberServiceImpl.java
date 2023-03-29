package com.pobitecoding.project.service.member;

import java.util.List;
import com.pobitecoding.project.dao.member.MemberDAO;
import com.pobitecoding.project.dao.member.MemberDAOImpl;
import com.pobitecoding.project.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
    
    private MemberDAO memberDAO;
    
    public MemberServiceImpl() {
        memberDAO = new MemberDAOImpl();
    }
    
    @Override
    public boolean create(MemberVO memberVO) {
        return memberDAO.create(memberVO) > 0;
    }

    @Override
    public boolean delete(int id) {
        return memberDAO.delete(id) > 0;
    }

    @Override
    public MemberVO read(int id) {
        return memberDAO.read(id);
    }
    
    @Override
    public List<MemberVO> readAll() {
        return memberDAO.readAll();
    }
}