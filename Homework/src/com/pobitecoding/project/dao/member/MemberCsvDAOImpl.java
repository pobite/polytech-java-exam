package com.pobitecoding.project.dao.member;

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
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import com.pobitecoding.project.vo.MemberVO;

public class MemberCsvDAOImpl implements MemberDAO {

    private static int memberCount = 1;
    private String fileName = "member.csv"; // 파일명
    private Map<Integer, MemberVO> dataSource;  // MemberVO 데이터를 담는 Map
    
    public MemberCsvDAOImpl() {
        dataSource = new HashMap<>();

        try (CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(fileName), "EUC-KR"))) {

            // 첫 번째 줄은 컬럼명이므로 건너뛰기
            reader.skip(1);

            // 데이터 읽어들이기
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                int id = Integer.parseInt(nextLine[0]);
                String name = nextLine[1];
                int gender = Integer.parseInt(nextLine[2]);
                int age = Integer.parseInt(nextLine[3]);
                String address = nextLine[4];
                String number = nextLine[5];
                String birthDate = nextLine[6];
                String joinDate = nextLine[7];
                
                // VO 생성하여 Map에 삽입
                MemberVO memberVO = new MemberVO(id, name, gender, age, address, number, birthDate, joinDate);
                dataSource.put(id, memberVO);

                memberCount = Math.max(memberCount, id + 1); // memberCount 업데이트
            }

        } catch (FileNotFoundException e) {
            // System.out.println("MemberCsvDAOImpl: " + fileName + " 파일이 존재하지 않습니다.");
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
    
    
    @Override
    public int create(MemberVO memberVO) {
        try {
            // 파일을 쓰기 모드로 열기
            memberVO.setId(memberCount++);
            CSVWriter writer = new CSVWriter(new OutputStreamWriter(new FileOutputStream(fileName, true), "EUC-KR"));

            // 첫 번째 줄에 컬럼명 추가
            if (new File(fileName).length() == 0) {
                writer.writeNext(new String[]{"id", "name", "gender", "age", "address", "number", "birthDate", "joinDate"});
            }
            
            // 새로운 레코드 추가
            writer.writeNext(new String[]{String.valueOf(memberVO.getId()), memberVO.getName(), String.valueOf(memberVO.getGender()),
                    String.valueOf(memberVO.getAge()), memberVO.getAddress(), String.valueOf(memberVO.getNumber()), memberVO.getBirthDate(), memberVO.getJoinDate()});
            writer.close();
            
            // Map에 삽입
            memberVO.setId(memberCount);
            dataSource.put(memberCount++, memberVO);
            
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @Override
    public int delete(int id) {
        List<MemberVO> memberList = readAll();
        List<MemberVO> newMemberList = new ArrayList<>();
        boolean isDeleted = false;
        for (MemberVO memberVO : memberList) {
            if (memberVO.getId() != id) {
                newMemberList.add(memberVO);
            } else {
                isDeleted = true;
                dataSource.remove(memberVO.getId());
            }
        }
        if (!isDeleted) {
            return 0; // 해당 id에 해당하는 회원 데이터가 없는 경우
        }
        try {
            // 파일을 쓰기 모드로 열기
            CSVWriter writer = new CSVWriter(new OutputStreamWriter(new FileOutputStream(fileName), "EUC-KR"));

            // 첫 번째 줄에 컬럼명 쓰기
            writer.writeNext(new String[]{"id", "name", "gender", "age", "address", "number", "birthDate", "joinDate"});

            // 나머지 데이터 쓰기
            for (MemberVO memberVO : newMemberList) {
                writer.writeNext(new String[]{String.valueOf(memberVO.getId()), memberVO.getName(), String.valueOf(memberVO.getGender()),
                    String.valueOf(memberVO.getAge()), memberVO.getAddress(), memberVO.getNumber(), memberVO.getBirthDate(), memberVO.getJoinDate()});
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @Override
    public MemberVO read(int id) {
        return dataSource.get(id);
    }

    @Override
    public List<MemberVO> readAll() {
        return new ArrayList<>(dataSource.values());
    }
}