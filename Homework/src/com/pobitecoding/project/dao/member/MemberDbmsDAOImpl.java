package com.pobitecoding.project.dao.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.pobitecoding.project.controller.main.MainController;
import com.pobitecoding.project.vo.BookVO;
import com.pobitecoding.project.vo.MemberVO;

public class MemberDbmsDAOImpl implements MemberDAO {
    
    @Override
    public int create(MemberVO memberVO) {
        String insertQuery = "INSERT INTO MEMBER (memberId, memberName, gender, age, address, memberNumber, birthDate, joinDate) " +
                "VALUES (MEMBER_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = MainController.conn.prepareStatement(insertQuery)) {
            pstmt.setString(1, memberVO.getName());
            pstmt.setInt(2, memberVO.getGender());
            pstmt.setInt(3, memberVO.getAge());
            pstmt.setString(4, memberVO.getAddress());
            pstmt.setString(5, memberVO.getNumber());
            pstmt.setString(6, memberVO.getBirthDate());
            pstmt.setString(7, memberVO.getJoinDate());

            int rowCount = pstmt.executeUpdate();
            return rowCount;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(int id) {
        String deleteQuery = "DELETE FROM MEMBER WHERE memberId = ?";
        
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
    public MemberVO read(int id) {
        MemberVO member = null;
        try {
            // PreparedStatement를 사용하여 파라미터를 바인딩하고 쿼리 실행
            PreparedStatement pstmt = MainController.conn.prepareStatement("SELECT * FROM MEMBER WHERE memberId = ?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            // 조회 결과를 BookVO 객체에 매핑
            if (rs.next()) {
                member = new MemberVO();
                member.setId(rs.getInt("memberId"));
                member.setName(rs.getString("memberName"));
                member.setGender(rs.getInt("gender"));
                member.setAge(rs.getInt("age"));
                member.setAddress(rs.getString("address"));
                member.setNumber(rs.getString("memberNumber"));
                member.setBirthDate(rs.getString("birthDate"));
                member.setJoinDate(rs.getString("joinDate"));
            }
            
            // 자원 해제
            rs.close();
            pstmt.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return member;
    }

    @Override
    public List<MemberVO> readAll() {
        List<MemberVO> memberList = new ArrayList<>();

        String selectQuery = "SELECT * FROM MEMBER";

        try (Statement stmt = MainController.conn.createStatement(); ResultSet rs = stmt.executeQuery(selectQuery)) {
            while (rs.next()) {
                int id = rs.getInt("memberId");
                String name = rs.getString("memberName");
                int gender = rs.getInt("gender");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                String number = rs.getString("memberNumber");
                String birthDate = rs.getString("birthDate");
                String joinDate = rs.getString("joinDate");
                
                MemberVO memberVO = new MemberVO(id, name, gender, age, address, number,
                        birthDate, joinDate);
                memberList.add(memberVO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return memberList;
    }
    
    public int update(MemberVO memberVO) {
        String updateQuery = "UPDATE MEMBER SET memberName = ?, gender = ?, age = ?, address = ?, memberNumber = ?, birthDate = ?, joinDate = ? WHERE memberId = ?";

        try (PreparedStatement pstmt = MainController.conn.prepareStatement(updateQuery)) {
            pstmt.setString(1, memberVO.getName());
            pstmt.setInt(2, memberVO.getGender());
            pstmt.setInt(3, memberVO.getAge());
            pstmt.setString(4, memberVO.getAddress());
            pstmt.setString(5, memberVO.getNumber());
            pstmt.setString(6, memberVO.getBirthDate());
            pstmt.setString(7, memberVO.getJoinDate());
            pstmt.setInt(8, memberVO.getId());

            int rowCount = pstmt.executeUpdate();
            return rowCount;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
   
}