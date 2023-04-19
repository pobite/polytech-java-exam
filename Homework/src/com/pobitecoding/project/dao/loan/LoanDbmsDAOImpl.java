package com.pobitecoding.project.dao.loan;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.pobitecoding.project.controller.main.MainController;
import com.pobitecoding.project.vo.LoanVO;

public class LoanDbmsDAOImpl implements LoanDAO {

    @Override
    public int create(LoanVO loanVO) {
        String insertQuery = "INSERT INTO loan (loanid, memberid, bookid, ispossibleborrow, ispossibleextend, startdate, enddate) "
                + "VALUES (LOAN_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement pstmt = MainController.conn.prepareStatement(insertQuery)) {
            pstmt.setInt(1, loanVO.getMemberId());
            pstmt.setInt(2, loanVO.getBookId());
            pstmt.setString(3, loanVO.isPossibleBorrow() ? "true" : "false");
            pstmt.setString(4, loanVO.isPossibleBorrow() ? "true" : "false");
            pstmt.setString(5, loanVO.getStartDate());
            pstmt.setString(6, loanVO.getEndDate());

            int rowCount = pstmt.executeUpdate();
            return rowCount;

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(int id) {
        String deleteQuery = "DELETE FROM LOAN WHERE loanId = ?";
        
        try (PreparedStatement pstmt = MainController.conn.prepareStatement(deleteQuery)) {
            pstmt.setInt(1, id);
            int rowCount = pstmt.executeUpdate();
            return rowCount;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int deleteByBookId(int id) {
        String deleteQuery = "DELETE FROM LOAN WHERE bookId = ?";
        
        try (PreparedStatement pstmt = MainController.conn.prepareStatement(deleteQuery)) {
            pstmt.setInt(1, id);
            int rowCount = pstmt.executeUpdate();
            return rowCount;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public LoanVO read(int id) {
        LoanVO loan = null;
        try {
            // PreparedStatement를 사용하여 파라미터를 바인딩하고 쿼리 실행
            PreparedStatement pstmt = MainController.conn.prepareStatement("SELECT * FROM loan WHERE LOANID = ?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            // 조회 결과를 BookVO 객체에 매핑
            if (rs.next()) {
                loan = new LoanVO();
                loan.setMemberId(rs.getInt("memberId"));
                loan.setBookId(rs.getInt("bookId"));
                loan.setPossibleBorrow(rs.getBoolean("isPossibleBorrow"));
                loan.setPossibleExtend(rs.getBoolean("isPossibleExtend"));
                loan.setStartDate(rs.getString("startDate"));
                loan.setEndDate(rs.getString("endDate"));
            }
            
            // 자원 해제
            rs.close();
            pstmt.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loan;
    }

    @Override
    public LoanVO readMem(int id) {
        LoanVO loan = null;
        try {
            // PreparedStatement를 사용하여 파라미터를 바인딩하고 쿼리 실행
            PreparedStatement pstmt = MainController.conn.prepareStatement("SELECT * FROM loan WHERE MEMBERID = ?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            // 조회 결과를 BookVO 객체에 매핑
            if (rs.next()) {
                loan = new LoanVO();
                loan.setMemberId(rs.getInt("memberId"));
                loan.setBookId(rs.getInt("bookId"));
                loan.setPossibleBorrow(rs.getBoolean("isPossibleBorrow"));
                loan.setPossibleExtend(rs.getBoolean("isPossibleExtend"));
                loan.setStartDate(rs.getString("startDate"));
                loan.setEndDate(rs.getString("endDate"));
            }
            
            // 자원 해제
            rs.close();
            pstmt.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loan;
    }

    @Override
    public LoanVO readBook(int id) {
        LoanVO loan = null;
        try {
            // PreparedStatement를 사용하여 파라미터를 바인딩하고 쿼리 실행
            PreparedStatement pstmt = MainController.conn.prepareStatement("SELECT * FROM loan WHERE BOOKID = ?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            // 조회 결과를 BookVO 객체에 매핑
            if (rs.next()) {
                loan = new LoanVO();
                loan.setMemberId(rs.getInt("memberId"));
                loan.setBookId(rs.getInt("bookId"));
                loan.setPossibleBorrow(rs.getBoolean("isPossibleBorrow"));
                loan.setPossibleExtend(rs.getBoolean("isPossibleExtend"));
                loan.setStartDate(rs.getString("startDate"));
                loan.setEndDate(rs.getString("endDate"));
            }
            
            // 자원 해제
            rs.close();
            pstmt.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loan;
    }

    @Override
    public List<LoanVO> readAll() {
        List<LoanVO> loanList = new ArrayList<>();

        String selectQuery = "SELECT * FROM LOAN";

        try (Statement stmt = MainController.conn.createStatement(); ResultSet rs = stmt.executeQuery(selectQuery)) {
            while (rs.next()) {
                int id = rs.getInt("loanId");
                int memberId = rs.getInt("memberId");
                int bookId = rs.getInt("bookId");
                boolean isPossibleBorrow = rs.getBoolean("isPossibleBorrow");
                boolean isPossibleExtend = rs.getBoolean("isPossibleExtend");
                String startDate = rs.getString("startDate");
                String endDate = rs.getString("endDate");

                LoanVO loanVO = new LoanVO(id, memberId, bookId, isPossibleBorrow, isPossibleExtend, startDate, endDate);
                loanList.add(loanVO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return loanList;
    }

    @Override
    public List<LoanVO> readBorrow() {
        List<LoanVO> loanList = new ArrayList<>();

        String selectQuery = "SELECT * FROM LOAN WHERE ISPOSSIBLEBORROW = 'true'";

        try (Statement stmt = MainController.conn.createStatement(); ResultSet rs = stmt.executeQuery(selectQuery)) {
            while (rs.next()) {
                int id = rs.getInt("loanId");
                int memberId = rs.getInt("memberId");
                int bookId = rs.getInt("bookId");
                boolean isPossibleBorrow = rs.getBoolean("isPossibleBorrow");
                boolean isPossibleExtend = rs.getBoolean("isPossibleExtend");
                String startDate = rs.getString("startDate");
                String endDate = rs.getString("endDate");

                LoanVO loanVO = new LoanVO(id, memberId, bookId, isPossibleBorrow, isPossibleExtend, startDate, endDate);
                loanList.add(loanVO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return loanList;
    }

    @Override
    public List<LoanVO> readLoan() {
        List<LoanVO> loanList = new ArrayList<>();

        String selectQuery = "SELECT * FROM LOAN WHERE ispossibleborrow = 'false'";

        try (Statement stmt = MainController.conn.createStatement(); ResultSet rs = stmt.executeQuery(selectQuery)) {
            while (rs.next()) {
                int id = rs.getInt("loanId");
                int memberId = rs.getInt("memberId");
                int bookId = rs.getInt("bookId");
                boolean isPossibleBorrow = rs.getBoolean("isPossibleBorrow");
                boolean isPossibleExtend = rs.getBoolean("isPossibleExtend");
                String startDate = rs.getString("startDate");
                String endDate = rs.getString("endDate");

                LoanVO loanVO = new LoanVO(id, memberId, bookId, isPossibleBorrow, isPossibleExtend, startDate, endDate);
                loanList.add(loanVO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return loanList;
    }

    @Override
    public int update(LoanVO loanVO) {
        String updateQuery = "UPDATE LOAN SET memberId=?, bookId=?, isPossibleBorrow=?, isPossibleExtend=?, startDate=?, endDate=? WHERE BOOKID = ?";
        
        try (PreparedStatement pstmt = MainController.conn.prepareStatement(updateQuery)) {
            pstmt.setInt(1, loanVO.getMemberId());
            pstmt.setInt(2, loanVO.getBookId());
            pstmt.setString(3, loanVO.isPossibleBorrow() ? "true" : "false");
            pstmt.setString(4, loanVO.isPossibleBorrow() ? "true" : "false");
            pstmt.setString(5, loanVO.getStartDate());
            pstmt.setString(6, loanVO.getEndDate());
            pstmt.setInt(7, loanVO.getBookId());

            int rowCount = pstmt.executeUpdate();
            return rowCount;

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}