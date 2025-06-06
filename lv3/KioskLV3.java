package lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KioskLV3 {
    public List<MenuItemLV3> menuItems = new ArrayList<>();

    public KioskLV3(List<MenuItemLV3> menuItems){
        this.menuItems = menuItems;
    }
    public int start(Scanner sc){
        System.out.println("==============저희 매장에 오신것을 환영합니다!!==============\n");

        System.out.println("              [ J-BURGER MENU ]");
        int sequence = 1;
        for (MenuItemLV3 menu : menuItems){
            System.out.printf("%d. %-15s  | %s | %s\n", sequence,menu.getName(),menu.getPrice(),menu.getDescription());
            sequence ++;
        }
        while (true){
            System.out.print("\n주문하려는 메뉴의 숫자를 입력하세요!(0을 입력하면 프로그램이 종료됩니다.) : ");
            int menuNumber = Integer.parseInt(sc.next());
            if (menuNumber == 0){
                System.out.println("프로그램이 종료됩니다.");
                return 1;
            }
            else{
                System.out.printf("\n선택한 메뉴 : %s | %s | %s |",menuItems.get(menuNumber-1).name,menuItems.get(menuNumber-1).price,menuItems.get(menuNumber-1).description);
                System.out.print("를 주문하셨습니다 맞으면 1을 눌러주세요! : ");
                if(sc.next().equals("1")){
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
}
