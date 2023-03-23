package com.pobitecoding.project.util;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import com.pobitecoding.project.controller.BookController;
import com.pobitecoding.project.vo.MemberVO;

public abstract class CustomerUtil {
    
    /**
     * 회원조회
     * 모든 회원을 조회합니다.
     */
    public static void customerSearch() {
        List<MemberVO> memberList = BookController.memberService.readAll();
        
        if (memberList.size() != 0) {
            for (MemberVO member : memberList) {
                System.out.println(member.toString());
            }
        }
        else {
            System.out.println("등록된 회원이 없습니다.");
        }
    }
    
    /**
     * 회원가입
     * 회원 정보를 입력받아 회원가입을 합니다.
     * 
     * Input: name, gender, birthDate, address, number
     */
    public static void customerJoin() {
        System.out.println("회원의 성함을 입력하세요:");
        String name = BookController.scan.nextLine();
        
        System.out.println("회원의 성별을 입력하세요:");
        System.out.println("(0: 남자, 1: 여자, 2: 기타");
        int gender = BookController.scan.nextInt();
        BookController.scan.nextLine();
        
        System.out.println("회원의 생년월일을 입력하세요:");
        System.out.println("ex. yyyy/mm/dd");
        String birthString = BookController.scan.nextLine();

        System.out.println("회원의 주소를 입력하세요:");
        String address = BookController.scan.nextLine();
        
        System.out.println("회원의 번호를 입력하세요:");
        System.out.println("ex. '-' 구분자를 사용바랍니다.");
        String number = BookController.scan.nextLine();
        
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/mm/dd");
        String nowString = format.format(now);
        
        MemberVO vo = new MemberVO();
        vo.setName(name);
        vo.setGender(gender);
        vo.setBirthDate(birthString);
        vo.setAddress(address);
        vo.setNumber(number);
        vo.setBirthDate(nowString);
        
        if (BookController.memberService.create(vo)) {
            System.out.println(name + "회원이 등록되었습니다.");
        }
    }
    
    /**
     * 회원수정
     * id를 기준으로 한 명의 회원을 수정합니다. 
     */
    public static void customerEdit() {
        System.out.println("수정할 id를 입력하세요:");
        int id = BookController.scan.nextInt();
        BookController.scan.nextLine();

        MemberVO vo = BookController.memberService.read(id);
        
        /**
         * 회원이 존재하지 않는 경우
         */
        if (vo == null) {
            System.out.println("회원이 존재하지 않습니다.");
        }
        
        /**
         * 회원이 존재하는 경우
         */
        else {
            
//            boolean isSuccess = false;
            
            List<String> types = Arrays.asList("1. 이름", "2. 성별", "3. 주소",
                                               "4. 번호", "5. 생일");
            
            for (String type : types) {
                System.out.println(type);
            }
            
            System.out.println("변경할 타입을 선택하세요:");
            int type = BookController.scan.nextInt();
            BookController.scan.nextLine();
            
            switch (type) {
                case 1 :
                    System.out.println("변경할 성함을 입력하세요:");
                    String name = BookController.scan.nextLine();
                    vo.setName(name);
                    break;
                case 2 :
                    System.out.println("변경할 성별을 입력하세요:");
                    int gender = BookController.scan.nextInt();
                    BookController.scan.nextLine();
                    vo.setGender(gender);
                    break;
                case 3 :
                    System.out.println("변경할 주소를 입력하세요:");
                    String address = BookController.scan.nextLine();
                    vo.setAddress(address);
                    break;
                case 4 :
                    System.out.println("변경할 번호를 입력하세요:");
                    String number = BookController.scan.nextLine();
                    vo.setNumber(number);
                    break;
                case 5 :
                    System.out.println("변경할 생일을 입력하세요:");
                    System.out.println("ex. yyyy/mm/dd");
                    String birthString = BookController.scan.nextLine();
                    vo.setNumber(birthString);
                    break;
                default :
                    System.out.println("잘못된 입력");
                    break;
            }
                
//                if (isSuccess) {
//                    System.out.println("처리되었습니다.");
//                }
        }
    }

    
    /**
     * 회원삭제
     * id를 기준으로 한 명의 회원을 삭제합니다.
     */
    public static void customerDelete() {
        
        System.out.println("삭제할 회원의 id를 입력하세요:");
        int id = BookController.scan.nextInt();
        BookController.scan.nextLine();

        boolean isSuccess = false;
        isSuccess = BookController.memberService.delete(id);

        if (isSuccess) {
            System.out.println( "회원이 삭제되었습니다.");
        }
        else {
            System.out.println( "회원이 존재하지 않습니다.");
        }   
    }
    
    /**
     * 회원삭제 취소
     * 이전 회원삭제 명령을 취소합니다.
     */
    public static void deleteRollback() {
        if (BookController.memberService.create(BookController.prviousMember)) {
            System.out.println(BookController.prviousMember.getName() + "회원이 복구되었습니다.");
        }
    }
}