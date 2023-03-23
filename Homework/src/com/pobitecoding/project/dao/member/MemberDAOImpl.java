package com.pobitecoding.project.dao.member;

import java.util.ArrayList;
import java.util.List;
import com.pobitecoding.project.vo.AbstractVO;
import com.pobitecoding.project.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO {
    
    private List<MemberVO> memberList;
    
    public MemberDAOImpl() {
        memberList = new ArrayList<>();
    }

    @Override
    public int create(MemberVO MemberVO) {
        memberList.add(MemberVO);
        return 1;
    }

    @Override
    public int delete(int id) {
        for (MemberVO member : memberList) {
            if (member.getId() == id) {
                memberList.remove(member);
                return 1;
            }
        }
        return 0;
    }

    @Override
    public MemberVO read(int id) {
        for (MemberVO member : memberList) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    @Override
    public List<MemberVO> readAll() {
        return memberList;
    }
}