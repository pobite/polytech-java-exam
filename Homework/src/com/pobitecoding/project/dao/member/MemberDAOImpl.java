package com.pobitecoding.project.dao.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.pobitecoding.project.controller.main.MainController;
import com.pobitecoding.project.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO {
    
    private static int memberCount = 1;
    
    private Map<Integer, MemberVO> dataSource;
    
    public MemberDAOImpl() {
        dataSource = new HashMap<>();
    }

    @Override
    public int create(MemberVO memberVO) {
        memberVO.setId(memberCount);
        dataSource.put(memberCount++, memberVO);
        return 1;
    }

    @Override
    public int delete(int id) {
        MainController.prviousMember = dataSource.get(id);
        dataSource.remove(id);
        return 1;
    }

    @Override
    public MemberVO read(int id) {
        return dataSource.get(id);
    }

    @Override
    public List<MemberVO> readAll() {
        return dataSource.entrySet()
                         .stream()
                         .map(entry -> entry.getValue())
                         .collect(Collectors.toList());
    }
}