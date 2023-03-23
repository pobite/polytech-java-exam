package com.pobitecoding.project.dao;

import java.util.List;
import com.pobitecoding.project.vo.BookVO;

public interface BookDAO {
    
    public int create(BookVO bookMgntVO);
    
//    public int update(int id);

    public int delete(int id);    

    public List<BookVO> readAll();

}
