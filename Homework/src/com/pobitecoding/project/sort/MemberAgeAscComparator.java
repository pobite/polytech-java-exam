package com.pobitecoding.project.sort;

import java.util.Comparator;
import com.pobitecoding.project.vo.MemberVO;

public class MemberAgeAscComparator implements Comparator<MemberVO>{

    @Override
    public int compare(MemberVO o1, MemberVO o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}