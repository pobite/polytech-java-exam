package com.pobitecoding.project.dao;

import java.util.ArrayList;
import java.util.List;
import com.pobitecoding.project.vo.BookVO;

public class BookDAOImpl implements BookDAO {
    
    private List<BookVO> dataSource;
    
    public BookDAOImpl() {
        dataSource = new ArrayList<>();
    }

    @Override
    public int create(BookVO bookMgntVO) {
        dataSource.add(bookMgntVO);
        return 1;
    }

//    @Override
//    public int update(int id) {
////        BookMgntVO vo = dataSource.get(0);
//        return 0;
//    }

    @Override
    public int delete(int id) {
        for (BookVO member : dataSource) {
            if (member.getId() == id) {
                dataSource.remove(member);
                return 1;
            }
        }
        return 0;
    }

    @Override
    public List<BookVO> readAll() {
        return dataSource;
    }
}