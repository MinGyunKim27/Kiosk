package lv5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * KioskLV5 클래스
 * - 메뉴 카테고리 목록을 출력하고
 * - 사용자 입력을 받아
 * - 해당 카테고리의 메뉴를 보여주고
 * - 주문을 진행하는 키오스크 로직
 */
public class KioskLV5 {

    private List<MenuItemLV5> menuItems;      // 선택된 카테고리의 메뉴 아이템 목록
    private final List<MenuLV5> menus;        // 전체 메뉴 카테고리 목록

    // 생성자: 카테고리별 메뉴 리스트를 주입받음
    public KioskLV5(List<MenuLV5> menus){
        this.menus = menus;
    }

    // 키오스크 메인 시작 메서드
    public int start(Scanner sc){
        InputHandler input = new InputHandler();

        // ===== 메인 메뉴 화면 출력 =====
        System.out.println("\n==============저희 매장에 오신것을 환영합니다!!==============\n");
        System.out.println("              [ Main MENU ]");

        int sequenceMenu = 1;
        for (MenuLV5 menuTitle : menus){
            System.out.printf("%d. %-15s\n", sequenceMenu, menuTitle.getCategoryName());
            sequenceMenu++;
        }
        System.out.println("0. 종료");

        // ===== 사용자로부터 카테고리 번호 입력 받기 =====
        int categoryNumber = input.getInt("주문하려는 카테고리를 고르세요!: ");
        if (categoryNumber == 0){
            System.out.println("프로그램이 종료됩니다.");
            return 1; // 종료 신호 반환
        }

        // 선택한 카테고리의 메뉴 목록 불러오기
        menuItems = menus.get(categoryNumber - 1).getCategory();

        // ===== 해당 카테고리 메뉴 선택 반복 =====
        while (true){
            System.out.printf("\n              [ %s MENU ]\n", menus.get(categoryNumber - 1).getCategoryName());

            int sequence = 1;
            for (MenuItemLV5 menu : menuItems){
                System.out.printf("%d. %-15s  | %s | %s\n", sequence, menu.getName(), menu.getPrice(), menu.getDescription());
                sequence++;
            }
            System.out.println("0. 종료");

            // 메뉴 번호 입력
            int menuNumber = input.getInt("\n주문하려는 메뉴의 숫자를 입력하세요! : ");
            if (menuNumber == 0){
                System.out.println("프로그램이 종료됩니다.");
                return 1;
            } else {
                // 메뉴 상세 정보 출력
                MenuItemLV5 selected = menuItems.get(menuNumber - 1);
                System.out.printf("\n선택한 메뉴 : %s | %s | %s |\n", selected.getName(), selected.getPrice(), selected.getDescription());

                // 확인 입력
                if (input.getInt(" 맞으면 1을 눌러주세요! : ") == 1){
                    System.out.println("\n주문 완료했습니다. 영수증을 수령해주세요\n\n");
                    break; // 주문 완료 후 메뉴 반복 종료
                } else {
                    System.out.println("\n다시 다른 메뉴를 입력해주세요!");
                }
            }
        }

        return 0; // 루프 종료 후 다시 메인 메뉴로 돌아갈 수 있도록
    }
}
