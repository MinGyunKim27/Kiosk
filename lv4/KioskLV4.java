package lv4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KioskLV4 {
    public List<MenuItemLV4> menuItems = new ArrayList<>();
    public List<MenuLV4> menus;
    private static final InputHandler input = new InputHandler();

    public KioskLV4(List<MenuLV4> menus){
        this.menus = menus;
    }
    public int start(Scanner sc){

        showMenus();

        int categoryNumber = pickCategory();
        if (categoryNumber == -1){
            return -1;
        }

        menuItems = menus.get(categoryNumber-1).category;

        while (true){
            showMenuItems(categoryNumber);

            int menuNumber = input.getInt("\n주문하려는 메뉴의 숫자를 입력하세요! : ");
            if (menuNumber == 0){
                System.out.println("이전으로 돌아갑니다.");
                break;
            }
            else{
                System.out.printf("\n선택한 메뉴 : %s | %s | %s |\n",menuItems.get(menuNumber-1).name,menuItems.get(menuNumber-1).price,menuItems.get(menuNumber-1).description);

                if(input.getInt("맞으면 1을 눌러주세요! : ") == 1){
                    System.out.println("결제하시겠습니까?");


                    System.out.println("\n주문 완료했습니다. 영수증을 수령해주세요\n\n");


                    break;
                }
                else {
                    System.out.println("\n다시 다른 메뉴를 입력해주세요!");
                }
            }
        }
        return 0;
    }

    public int pickCategory(){
        int categoryNumber = 0;
        categoryNumber = input.getInt("주문하려는 카테고리를 고르세요!: ");
        if (categoryNumber == 0){
            System.out.println("프로그램이 종료됩니다.");
            return -1;
        }

        menuItems = menus.get(categoryNumber-1).category;
        return categoryNumber;
    }

    public void showMenuItems(int categoryNumber){
        System.out.printf("\n              [ %s MENU ]\n",menus.get(categoryNumber-1).categoryName);
        int sequence = 1;

        for (MenuItemLV4 menu : menuItems){
            System.out.printf("%d. %-15s  | %s | %s\n", sequence,menu.getName(),menu.getPrice(),menu.getDescription());
            sequence ++;
        }
        System.out.println("0. 뒤로가기");
    }

    public void showMenus(){
        System.out.println("\n==============저희 매장에 오신것을 환영합니다!!==============\n");

        System.out.println("              [ Main MENU ]");
        int sequenceMenu = 1;
        for (MenuLV4 menuTitle : menus){
            System.out.printf("%d. %-15s\n", sequenceMenu, menuTitle.categoryName);
            sequenceMenu ++;
        }
        System.out.println("0. 종료.");
    }
}
