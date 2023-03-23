package com.pobitecoding.project.service;

import java.util.List;
import com.pobitecoding.project.vo.BookVO;

public interface BookService {

    public boolean create(BookVO bookVO);

//    public boolean update(int id, BookVO bookVO);

    public boolean delete(int id);

    public List<BookVO> readAll();
    
}
