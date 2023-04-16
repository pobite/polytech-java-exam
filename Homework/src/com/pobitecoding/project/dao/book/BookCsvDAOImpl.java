package com.pobitecoding.project.dao.book;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import com.pobitecoding.project.vo.BookVO;

public class BookCsvDAOImpl implements BookDAO {
    
    private static int bookCount = 1;
    private String fileName = "book.csv"; // 파일명
    private Map<Integer, BookVO> dataSource; // BookVO 데이터를 담는 Map
    
    public BookCsvDAOImpl() {
        dataSource = new HashMap<>();

        try (CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(fileName), "EUC-KR"))) {

            // 첫 번째 줄은 컬럼명이므로 건너뛰기
            reader.skip(1);

            // 데이터 읽어들이기
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                int id = Integer.parseInt(nextLine[0]);
                String title = nextLine[1];
                String author = nextLine[2];
                String publisher = nextLine[3];
                String publicationDate = nextLine[4];
                boolean isPossibleBorrow = Boolean.parseBoolean(nextLine[5]);

                BookVO bookVO = new BookVO(id, title, author, publisher, publicationDate, isPossibleBorrow);
                dataSource.put(id, bookVO);

                bookCount = Math.max(bookCount, id + 1); // bookCount 업데이트
            }

        } catch (FileNotFoundException e) {
//            System.out.println("BookCsvDAOImpl: " + fileName + " 파일이 존재하지 않습니다.");
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
    
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
            
            // Map에 삽입
            bookVO.setId(bookCount);
            dataSource.put(bookCount++, bookVO);
            
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @Override
    public int delete(int id) {
        List<BookVO> bookList = readAll();
        List<BookVO> newBookList = new ArrayList<>();
        boolean isDeleted = false;
        for (BookVO bookVO : bookList) {
            if (bookVO.getId() != id) {
                newBookList.add(bookVO);
            } else {
                isDeleted = true;
                dataSource.remove(bookVO.getId());
            }
        }
        if (!isDeleted) {
            return 0; // 해당 id에 해당하는 도서 데이터가 없는 경우
        }
        try {
            // 파일을 쓰기 모드로 열기
            CSVWriter writer = new CSVWriter(new OutputStreamWriter(new FileOutputStream(fileName), "EUC-KR"));

            // 첫 번째 줄에 컬럼명 쓰기
            writer.writeNext(new String[]{"id", "title", "author", "publisher", "publicationDate", "isPossibleBorrow"});

            // 나머지 데이터 쓰기
            for (BookVO bookVO : newBookList) {
                writer.writeNext(new String[]{String.valueOf(bookVO.getId()), bookVO.getTitle(), bookVO.getAuthor(), bookVO.getPublisher(), bookVO.getPublicationDate(), String.valueOf(bookVO.isPossibleBorrow())});
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
        return dataSource.get(id);
    }

    @Override
    public List<BookVO> readAll() {
        return new ArrayList<>(dataSource.values());
    }    
        
    @Override
    public List<BookVO> readBorrow() {
        return dataSource.values().stream()
                         .filter(BookVO::isPossibleBorrow)
                         .collect(Collectors.toList());
    }

    @Override
    public List<BookVO> readLoan() {
        return dataSource.values().stream()
                         .filter(book -> !book.isPossibleBorrow())
                         .collect(Collectors.toList());
    }
}