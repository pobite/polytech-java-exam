package com.pobitecoding.project.dao.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import com.pobitecoding.project.vo.BookVO;

public class BookDbmsDAOImpl implements BookDAO {
    
    // Oracle JDBC 드라이버를 로드합니다. 
    private Connection conn = null;
    
    public BookDbmsDAOImpl() {
        
        // 데이터베이스에 연결합니다.
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@192.168.119.119:1521/dink";
            String user = "scott";
            String passwd = "tiger";
            conn = DriverManager.getConnection(url, user, passwd);
            System.out.println(conn);
        
        } catch (ClassNotFoundException e) {
            // 드라이버 로드 중 예외가 발생한 경우 처리합니다.
            e.printStackTrace();
        } catch (SQLException e) {
            // 데이터베이스 연결 및 쿼리 실행 중 예외가 발생한 경우 처리합니다.
            e.printStackTrace();
        }
    }
    
    @Override
    public int create(BookVO bookVO) {
        String insertQuery = "INSERT INTO books (id, title, author, publisher, publication_date, is_possible_borrow) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {
            // id는 자동 생성되므로 '?'로 설정
            pstmt.setString(1, null);
            pstmt.setString(2, bookVO.getTitle());
            pstmt.setString(3, bookVO.getAuthor());
            pstmt.setString(4, bookVO.getPublisher());
            pstmt.setString(5, bookVO.getPublicationDate());
            pstmt.setBoolean(6, bookVO.isPossibleBorrow());
            
            int rowCount = pstmt.executeUpdate();
            return rowCount;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(int id) {
        // TODO Auto-generated method stub
        return 0;
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