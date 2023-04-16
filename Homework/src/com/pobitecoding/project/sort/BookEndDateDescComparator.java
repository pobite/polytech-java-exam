package com.pobitecoding.project.sort;

import java.util.Comparator;
import com.pobitecoding.project.vo.BookVO;
import com.pobitecoding.project.vo.LoanVO;

public class BookEndDateDescComparator implements Comparator<LoanVO>{

    @Override
    public int compare(LoanVO o1, LoanVO o2) {
        return o1.getEndDate().compareTo(o2.getEndDate()) * - 1;
    }
}