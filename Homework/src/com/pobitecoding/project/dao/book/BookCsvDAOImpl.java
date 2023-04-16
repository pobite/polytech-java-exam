package com.pobitecoding.project.dao.book;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import com.opencsv.CSVWriter;
import com.pobitecoding.project.vo.BookVO;

public class BookCsvDAOImpl implements BookDAO {
    
    private static int bookCount = 1;
    private String fileName = "book.csv"; // 파일명
    
    @Override
    public int create(BookVO bookVO) {
        try {
            // 파일을 쓰기 모드로 열기
            
            bookVO.setId(bookCount++);
            CSVWriter writer = new CSVWriter(new OutputStreamWriter(new FileOutputStream(fileName, true), "EUC-KR"));

            // 첫 번째 줄에 컬럼명 추가
            if (new File(fileName).length() == 0) {
                writer.writeNext(new String[]{"id", "title", "author", "publisher", "publicationDate", "isPossibleBorrow"});
            }
            
            // 새로운 레코드 추가
            writer.writeNext(new String[]{String.valueOf(bookVO.getId()), bookVO.getTitle(), bookVO.getAuthor(),
                    bookVO.getPublisher(), bookVO.getPublicationDate(), String.valueOf(bookVO.isPossibleBorrow())});
            writer.close();
            
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @Override
    public int delete(int id) {
        try {
            List<BookVO> bookList = readAll();
            // 파일을 쓰기 모드로 열기
            CSVWriter writer = new CSVWriter(new FileWriter(fileName));
            for (BookVO bookVO : bookList) {
                if (bookVO.getId() != id) {
                    // 기존 레코드 유지
                    writer.writeNext(new String[]{String.valueOf(bookVO.getId()), bookVO.getTitle(), bookVO.getAuthor(), bookVO.getPublisher(), String.valueOf(bookVO.isPossibleBorrow())});
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @Override
    public BookVO read(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<BookVO> readAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<BookVO> readBorrow() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<BookVO> readLoan() {
        // TODO Auto-generated method stub
        return null;
    }

}
