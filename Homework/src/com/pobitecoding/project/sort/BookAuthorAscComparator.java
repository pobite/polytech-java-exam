package com.pobitecoding.project.sort;

import java.util.Comparator;
import com.pobitecoding.project.vo.BookVO;

public class BookAuthorAscComparator implements Comparator<BookVO>{

    @Override
    public int compare(BookVO o1, BookVO o2) {
        return o1.getAuthor().compareTo(o2.getAuthor());
    }
}
