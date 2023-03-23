package com.pobitecoding.project.dao.book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.pobitecoding.project.vo.BookVO;

public class BookDAOImpl implements BookDAO {
    
    private static int bookCount = 1;
    
    private Map<Integer, BookVO> dataSource;
    
    public BookDAOImpl() {
        dataSource = new HashMap<>();
    }

    @Override
    public int create(BookVO bookVO) {
        bookVO.setId(bookCount);
        dataSource.put(bookCount++, bookVO);
        return 1;
    }

    @Override
    public int delete(int id) {
        dataSource.remove(id);
        return 1;
        
    }

    @Override
    public BookVO read(int id) {
        return dataSource.get(id);
    }

    @Override
    public List<BookVO> readAll() {
        return dataSource.entrySet()
                         .stream()
                         .map(entry -> entry.getValue())
                         .collect(Collectors.toList());
    }

    @Override
    public List<BookVO> readBorrow() {
        return dataSource.entrySet()
                         .stream()
                         .filter(entry -> entry.getValue().getBookBorrow().isPossibleBorrow() == true)
                         .map(entry -> entry.getValue())
                         .collect(Collectors.toList());
    }


}