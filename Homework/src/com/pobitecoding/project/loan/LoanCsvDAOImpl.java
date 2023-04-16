package com.pobitecoding.project.loan;

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
import com.pobitecoding.project.vo.LoanVO;

public class LoanCsvDAOImpl implements LoanDAO {

    private static int loanCount = 1;
    private String fileName = "loan.csv"; // 파일명
    private Map<Integer, LoanVO> dataSource; // LoonVO 데이터를 담는 Map
    
    public LoanCsvDAOImpl() {
        dataSource = new HashMap<>();

        try (CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(fileName), "EUC-KR"))) {

            // 첫 번째 줄은 컬럼명이므로 건너뛰기
            reader.skip(1);

            // 데이터 읽어들이기
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                int id = Integer.parseInt(nextLine[0]);
                int memberId = Integer.parseInt(nextLine[1]);
                int bookId = Integer.parseInt(nextLine[2]);
                boolean isPossibleBorrow = Boolean.parseBoolean(nextLine[3]);
                boolean isPossibleExtend = Boolean.parseBoolean(nextLine[4]);
                String startDate = nextLine[5];
                String endDate = nextLine[6];
                
                // VO 생성하여 Map에 삽입
                LoanVO loanVO = new LoanVO(id, memberId, bookId, isPossibleBorrow, isPossibleExtend, startDate, endDate);
                dataSource.put(id, loanVO);

                loanCount = Math.max(loanCount, memberId + 1); // loanCount 업데이트
            }

        } catch (FileNotFoundException e) {
//            System.out.println("LoanCsvDAOImpl: " + fileName + " 파일이 존재하지 않습니다.");
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
    
    
    @Override
    public int create(LoanVO loanVO) {
        try {
            // 파일을 쓰기 모드로 열기
            loanVO.setId(loanCount++);
            CSVWriter writer = new CSVWriter(new OutputStreamWriter(new FileOutputStream(fileName, true), "EUC-KR"));

            // 첫 번째 줄에 컬럼명 추가
            if (new File(fileName).length() == 0) {
                writer.writeNext(new String[]{"id", "memberId", "bookId", "isPossibleBorrow", "isPossibleExtend", "startDate", "endDate"});
            }

            // 새로운 레코드 추가
            writer.writeNext(new String[]{String.valueOf(loanVO.getId()), String.valueOf(loanVO.getMemberId()), String.valueOf(loanVO.getBookId()),
                    String.valueOf(loanVO.isPossibleBorrow()), String.valueOf(loanVO.isPossibleExtend()), loanVO.getStartDate(), loanVO.getEndDate()});
            writer.close();

            // Map에 삽입
            loanVO.setId(loanCount);
            dataSource.put(loanCount++, loanVO);

        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @Override
    public int delete(int id) {
        List<LoanVO> loanList = readAll();
        List<LoanVO> newLoanList = new ArrayList<>();
        boolean isDeleted = false;
        for (LoanVO loanVO : loanList) {
            if (loanVO.getId() != id) {
                newLoanList.add(loanVO);
            } else {
                isDeleted = true;
                dataSource.remove(loanVO.getId());
            }
        }
        if (!isDeleted) {
            return 0; // 해당 id에 해당하는 대출 데이터가 없는 경우
        }
        try {
            // 파일을 쓰기 모드로 열기
            CSVWriter writer = new CSVWriter(new OutputStreamWriter(new FileOutputStream(fileName), "EUC-KR"));

            // 첫 번째 줄에 컬럼명 쓰기
            writer.writeNext(new String[]{"id", "bookId", "memberId", "startDate", "endDate"});

            // 나머지 데이터 쓰기
            for (LoanVO loanVO : newLoanList) {
                writer.writeNext(new String[]{String.valueOf(loanVO.getId()), String.valueOf(loanVO.getBookId()), String.valueOf(loanVO.getMemberId()), loanVO.getStartDate(), loanVO.getEndDate()});
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }


    @Override
    public int deleteByBookId(int id) {
        List<LoanVO> loanList = readAll();
        List<LoanVO> newLoanList = new ArrayList<>();
        boolean isDeleted = false;
        for (LoanVO loanVO : loanList) {
            if (loanVO.getBookId() != id) {
                newLoanList.add(loanVO);
            } else {
                isDeleted = true;
            }
        }
        if (!isDeleted) {
            return 0; // 해당 id에 해당하는 도서 대출 데이터가 없는 경우
        }
        try {
            // 파일을 쓰기 모드로 열기
            CSVWriter writer = new CSVWriter(new OutputStreamWriter(new FileOutputStream(fileName), "EUC-KR"));

            // 첫 번째 줄에 컬럼명 쓰기
            writer.writeNext(new String[]{"id", "memberId", "bookId", "borrowedDate", "returnDueDate", "returnDate", "isReturned"});

            // 나머지 데이터 쓰기
            for (LoanVO loanVO : newLoanList) {
                writer.writeNext(new String[]{String.valueOf(loanVO.getId()), String.valueOf(loanVO.getBookId()), String.valueOf(loanVO.getMemberId()), loanVO.getStartDate(), loanVO.getEndDate()});
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }


    @Override
    public LoanVO read(int id) {
        return dataSource.get(id);
    }

    @Override
    public LoanVO readMem(int id) {
        for (LoanVO vo : dataSource.values()) {
            if (vo.getMemberId() == id) {
                return vo;
            }
        }
        return null;
    }

    @Override
    public LoanVO readBook(int id) {
        for (LoanVO vo : dataSource.values()) {
            if (vo.getBookId() == id) {
                return vo;
            }
        }
        return null;
    }

    @Override
    public List<LoanVO> readAll() {
        return new ArrayList<>(dataSource.values());
    }

    @Override
    public List<LoanVO> readBorrow() {
        return dataSource.values().stream()
                .filter(LoanVO::isPossibleBorrow)
                .collect(Collectors.toList());
    }

    @Override
    public List<LoanVO> readLoan() {
        return dataSource.values().stream()
                .filter(loan -> !loan.isPossibleBorrow())
                .collect(Collectors.toList());
    }
}