package com.pobitecoding.project.service.member;

import java.util.List;
import com.pobitecoding.project.vo.MemberVO;

public interface MemberService {

    public boolean create(MemberVO MemberVO);

    public boolean delete(int id);

    public MemberVO read(int id);
    
    public List<MemberVO> readAll();
    
    public boolean updateMember(MemberVO memberVO);
    
}
