package com.pobitecoding.project.service.book;

import java.util.List;
import com.pobitecoding.project.vo.BookVO;
import com.pobitecoding.project.vo.MemberVO;

public interface BookService {
    
    public boolean create(BookVO bookVO);

    public boolean delete(int id);

    public BookVO read(int id);
    
    public List<BookVO> readAll();
    
    public List<BookVO> readBorrow();
    테스트트!!
}
