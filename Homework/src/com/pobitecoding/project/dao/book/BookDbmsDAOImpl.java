package com.pobitecoding.project.dao.book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.pobitecoding.project.controller.main.MainController;
import com.pobitecoding.project.vo.BookVO;

public class BookDbmsDAOImpl implements BookDAO {
    
    
    @Override
    public int create(BookVO bookVO) {
        String insertQuery = "INSERT INTO BOOK2 (bookId, title, author, publisher, publicationDate, isPossibleBorrow) " +
                "VALUES (BOOK2_SEQ.NEXTVAL, ?, ?, ?, ?, 'true')";

        try (PreparedStatement pstmt = MainController.conn.prepareStatement(insertQuery)) {
            pstmt.setString(1, bookVO.getTitle());
            pstmt.setString(2, bookVO.getAuthor());
            pstmt.setString(3, bookVO.getPublisher());
            pstmt.setString(4, bookVO.getPublicationDate());
//            pstmt.setBoolean(5, bookVO.isPossibleBorrow());

            int rowCount = pstmt.executeUpdate();
            return rowCount;

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }


    @Override
    public int delete(int id) {
        String deleteQuery = "DELETE FROM BOOK2 WHERE bookId = ?";
        
        try (PreparedStatement pstmt = MainController.conn.prepareStatement(deleteQuery)) {
            pstmt.setInt(1, id);
            int rowCount = pstmt.executeUpdate();
            return rowCount;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public BookVO read(int id) {
        BookVO book = null;
        try {
            // PreparedStatement를 사용하여 파라미터를 바인딩하고 쿼리 실행
            PreparedStatement pstmt = MainController.conn.prepareStatement("SELECT * FROM book2 WHERE BOOKID = ?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            // 조회 결과를 BookVO 객체에 매핑
            if (rs.next()) {
                book = new BookVO();
                book.setId(rs.getInt("bookId"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setPublisher(rs.getString("publisher"));
                book.setPublicationDate(rs.getString("publicationDate"));
                book.setPossibleBorrow(rs.getBoolean("isPossibleBorrow"));
            }
            
            // 자원 해제
            rs.close();
            pstmt.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }


    @Override
    public List<BookVO> readAll() {
        List<BookVO> bookList = new ArrayList<>();

        String selectQuery = "SELECT * FROM BOOK2";

        try (Statement stmt = MainController.conn.createStatement(); ResultSet rs = stmt.executeQuery(selectQuery)) {
            while (rs.next()) {
                int id = rs.getInt("BOOKID");
                String title = rs.getString("TITLE");
                String author = rs.getString("AUTHOR");
                String publisher = rs.getString("PUBLISHER");
                String publicationDate = rs.getString("PUBLICATIONDATE");
                boolean isPossibleBorrow = rs.getBoolean("ISPOSSIBLEBORROW");

                BookVO bookVO = new BookVO(id, title, author, publisher, publicationDate, isPossibleBorrow);
                bookList.add(bookVO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return bookList;
    }

    @Override
    public List<BookVO> readBorrow() {
        List<BookVO> borrowList = new ArrayList<>();

        String selectQuery = "SELECT * FROM BOOK2 WHERE ISPOSSIBLEBORROW = FALSE";

        try (Statement stmt = MainController.conn.createStatement(); ResultSet rs = stmt.executeQuery(selectQuery)) {
            while (rs.next()) {
                int id = rs.getInt("BOOKID");
                String title = rs.getString("TITLE");
                String author = rs.getString("AUTHOR");
                String publisher = rs.getString("PUBLISHER");
                String publicationDate = rs.getString("PUBLICATIONDATE");
                boolean isPossibleBorrow = rs.getBoolean("ISPOSSIBLEBORROW");

                BookVO bookVO = new BookVO(id, title, author, publisher, publicationDate, isPossibleBorrow);
                borrowList.add(bookVO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return borrowList;
    }

    @Override
    public List<BookVO> readLoan() {
        List<BookVO> loanList = new ArrayList<>();

        String selectQuery = "SELECT * FROM BOOK2 WHERE ISPOSSIBLEBORROW = TRUE";

        try (Statement stmt = MainController.conn.createStatement(); ResultSet rs = stmt.executeQuery(selectQuery)) {
            while (rs.next()) {
                int id = rs.getInt("BOOKID");
                String title = rs.getString("TITLE");
                String author = rs.getString("AUTHOR");
                String publisher = rs.getString("PUBLISHER");
                String publicationDate = rs.getString("PUBLICATIONDATE");
                boolean isPossibleBorrow = rs.getBoolean("ISPOSSIBLEBORROW");

                BookVO bookVO = new BookVO(id, title, author, publisher, publicationDate, isPossibleBorrow);
                loanList.add(bookVO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return loanList;
    }

    @Override
    public int update(BookVO bookVO) {
        String updateQuery = "UPDATE BOOK2 SET TITLE=?, AUTHOR=?, PUBLISHER=?, PUBLICATIONDATE=?, ISPOSSIBLEBORROW=? WHERE BOOKID=?";
        
        try (PreparedStatement pstmt = MainController.conn.prepareStatement(updateQuery)) {
            pstmt.setString(1, bookVO.getTitle());
            pstmt.setString(2, bookVO.getAuthor());
            pstmt.setString(3, bookVO.getPublisher());
            pstmt.setString(4, bookVO.getPublicationDate());
            pstmt.setString(5, bookVO.isPossibleBorrow() ? "true" : "false");
            pstmt.setInt(6, bookVO.getId());

            int rowCount = pstmt.executeUpdate();
            return rowCount;

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}