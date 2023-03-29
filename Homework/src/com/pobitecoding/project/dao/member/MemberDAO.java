package com.pobitecoding.project.dao.member;

import java.util.List;
import com.pobitecoding.project.vo.MemberVO;

public interface MemberDAO {
    
    public int create(MemberVO memberVO);
    
    public int delete(int id);    

    public MemberVO read(int id);
    
    public List<MemberVO> readAll();
}