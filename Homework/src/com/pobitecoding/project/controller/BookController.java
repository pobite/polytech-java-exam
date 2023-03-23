package com.pobitecoding.project.controller;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import com.pobitecoding.project.service.BookService;
import com.pobitecoding.project.service.BookServiceImpl;
import com.pobitecoding.project.util.BookUtil;

public class BookController {
    
    public static void main(String[] args) {
        
        BookService service = new BookServiceImpl();
        
        /**
         * 처음 출력문
         * 
         * 1. 회원관리
         * 2. 도서관리
         * 3. 종료
         */
        
        
        /**
         * 두 번째 출력문
         * 
         * 0. 뒤로
         * 1. 회원조회
         * 2. 회원등록
         * 3. 회원수정
         * 4. 회원삭제
         * 5. 삭제취소
         */

        Scanner scan = new Scanner(System.in);

        while(true) {

            BookUtil.printFirstMenu();
            
            /**
             * 입력 받아 menu에 저장
             */
            int menu = scan.nextInt();
            scan.nextLine();    // Enter를 무시
            
            
            /**
             * 회원관리
             */
            if (menu == 0) {
                
                BookUtil.printSecondMenu();
                /**
                 * 입력 받아 menu에 저장
                 */
                menu = scan.nextInt();
                scan.nextLine();    // Enter를 무시
                
                if (BookUtil.isInCorrectNumber(menu)) break;
                
                /**
                 * 등록
                 */
                if (menu == 0) {
                    break;
                }
                /**
                 * 회원조회
                 */
                else if (menu == 1) {

                    System.out.println("등록할 메뉴 타입을 입력하세요(숫자): ");

                    /**
                     * key: 고객의 입력 값
                     * 해당 key로 음료 선별.
                     */
                    int type = scan.nextInt();
                    scan.nextLine();

                    /**
                     * 뒤로가기: 1~4 이외의 숫자 입력 시
                     */
                    BookUtil.firstTypeCheck(menu)

                    String typeName = MenuMgntUtil.changeItemType(type);

                    System.out.println("등록할 아이템명을 입력하세요(문자): ");
                    String name = scan.nextLine();


                    MenuMgntVO vo = new MenuMgntVO();
                    vo.setItemName(name);

                    /**
                     * true일 시 제대로 등록 완료
                     */
                    if ( service.create(typeName, vo) ) {
                        System.out.println(name + "이(가) 등록되었습니다.");
                    }
                }
                /**
                 * 수정
                 */
                else if (menu == 2) {

                    MenuMgntUtil.printItemTypeMenu();
                    System.out.println("수정할 메뉴 타입을 입력하세요:");

                    /**
                     * key: 고객의 입력 값
                     * 해당 key로 음료 선별.
                     */
                    int type = scan.nextInt();
                    scan.nextLine();

                    /**
                     * 뒤로가기: 1~4 이외의 숫자 입력 시
                     */
                    if (type < 1 || type > 4) {
                        continue;
                    }
                    String typeName = MenuMgntUtil.changeItemType(type);

                    System.out.println("수정할 아이템 인덱스를 입력하세요(숫자): ");
                    int index = scan.nextInt();
                    scan.nextLine();


                    System.out.println("수정할 아이템명을 입력하세요(문자): ");
                    String name = scan.nextLine();


                    MenuMgntVO vo = service.read(typeName, index);

                    if (vo != null) {
                        vo.setItemName(name);
                        System.out.println(name +  "로 수정되었습니다.");
                    }
                    else {
                        System.out.println( "아이템이 존재하지 않습니다.");
                    }

                }
                /**
                 * 삭제
                 */
                else if (menu == 3) {

                    MenuMgntUtil.printItemTypeMenu();
                    System.out.println("삭제할 메뉴 타입을 입력하세요(숫자): ");

                    /**
                     * key: 고객의 입력 값
                     * 해당 key로 음료 선별.
                     */
                    int type = scan.nextInt();
                    scan.nextLine();

                    /**
                     * 뒤로가기: 1~4 이외의 숫자 입력 시
                     */
                    if (type < 1 || type > 4) {
                        continue;
                    }

                    String typeName = MenuMgntUtil.changeItemType(type);

                    System.out.println("삭제할 아이템 인덱스를 입력하세요(숫자): ");
                    int index = scan.nextInt();
                    scan.nextLine();

                    boolean isSuccess = false;
                    isSuccess = service.delete(typeName, index);

                    if (isSuccess) {
                        System.out.println( "삭제되었습니다.");
                    }
                    else {
                        System.out.println( "아이템이 존재하지 않습니다.");
                    }   

                }
                /**
                 * 조회 1건
                 */
                else if (menu == 4) {

                    MenuMgntUtil.printItemTypeMenu();
                    System.out.println("조회할 메뉴 타입을 입력하세요:");

                    /**
                     * key: 고객의 입력 값
                     * 해당 key로 음료 선별.
                     */
                    int type = scan.nextInt();
                    scan.nextLine();

                    /**
                     * 뒤로가기: 1~4 이외의 숫자 입력 시
                     */
                    if (type < 1 || type > 4) {
                        continue;
                    }
                    String typeName = MenuMgntUtil.changeItemType(type);

                    System.out.println("조회할 아이템 인덱스를 입력하세요(숫자): ");
                    int index = scan.nextInt();
                    scan.nextLine();

                    MenuMgntVO vo = service.read(typeName, index);

                    if (vo != null) {
                        System.out.println(vo.getItemName());
                    }
                    else {
                        System.out.println("아이템이 존재하지 않습니다.");
                    }
                }
                /**
                 * 조회(종류별)
                 */
                else if (menu == 5) {

                    MenuMgntUtil.printItemTypeMenu();
                    System.out.println("종료할 메뉴 타입을 입력하세요(숫자): ");

                    int type = scan.nextInt();
                    scan.nextLine();

                    /**
                     * 뒤로가기: 1~4 이외의 숫자 입력 시
                     */
                    if (type < 1 || type > 4) {
                        continue;
                    }
                    String typeName = MenuMgntUtil.changeItemType(type);
                    System.out.println("<" + typeName + ">");

                    List<MenuMgntVO> MenuList = service.readSome(typeName);

                    if (MenuList != null) {
                        for (MenuMgntVO menuMgntVO : MenuList) {
                            System.out.println(menuMgntVO);
                        }
                    }
                }
                /**
                 * 조회(전체)
                 */
                else if (menu == 6) {

                    Map<String, List<MenuMgntVO>> types = service.readAll();
                    for (String key : types.keySet()) {
                        List<MenuMgntVO> value = types.get(key);
                        System.out.println("<" + key +">");
                        for (MenuMgntVO item : value) {
                            System.out.println(item.getItemName());
                        }
                    }
                }
                /**
                 * 종료: 1~6 이외의 숫자 입력 시
                 */
                else {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }
            }
            /**
             * 도서관리
             */
            else if (menu == 1) {
                
            }
            /**
             * 종료
             */
            else if (menu == 2) {
                break;
            }
        }
    }
}