package lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    private static Thread Tread;

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        MenuItem cheeseburger = new MenuItem();
        cheeseburger.name = "cheeseBurger";
        cheeseburger.price = "W 7.5";
        cheeseburger.description = "소고기 패티와, 치즈가 3장이나 들어간 버거!";

        MenuItem hamburger = new MenuItem();
        hamburger.name = "Hamburger";
        hamburger.price = "W 6.9";
        hamburger.description = "풍성한 야채와 맛있는 소고기 패티가 들어간 기본 버거!";

        MenuItem mushroomBurger = new MenuItem();
        mushroomBurger.name = "mushroomBurger";
        mushroomBurger.price = "W 7.8";
        mushroomBurger.description = "특제 소스와 그릴로 구운 버섯이 틀어간 시그니처 버거!";

        MenuItem chickenBurger = new MenuItem();
        chickenBurger.name = "ChickenBurger";
        chickenBurger.price = "W 6.5";
        chickenBurger.description = "치킨 패티가 들어간 매콤한 소스로 입안을 사로잡는 치킨 버거!";

        List<MenuItem> menuItems = new ArrayList<MenuItem>();
        menuItems.add(cheeseburger);
        menuItems.add(chickenBurger);
        menuItems.add(mushroomBurger);
        menuItems.add(hamburger);

        while (true){

            System.out.println("==============저희 매장에 오신것을 환영합니다!!==============\n");

            System.out.println("              [ J-BURGER MENU ]");
            int sequence = 1;
            for (MenuItem menu : menuItems){
                System.out.printf("%d. %-15s  | %s | %s\n", sequence,menu.getName(),menu.getPrice(),menu.getDescription());
                sequence ++;
            }
            while (true){
                System.out.print("\n주문하려는 메뉴의 숫자를 입력하세요!(0을 입력하면 프로그램이 종료됩니다.) : ");
                int menuNumber = Integer.parseInt(sc.next());
                if (menuNumber == 0){
                    System.out.println("프로그램이 종료됩니다.");
                    return;
                }
                else{
                    System.out.printf("\n선택한 메뉴 : %s | %s | %s |",menuItems.get(menuNumber-1).name,menuItems.get(menuNumber-1).price,menuItems.get(menuNumber-1).description);
                    System.out.print("를 주문하셨습니다 맞으면 1을 눌러주세요! : ");
                    if(sc.next().equals("1")){
                        System.out.println("\n주문 완료했습니다. 영수증을 수령해주세요\n\n");
                        try {
                            Thread.sleep(1000);  // 1초 멈춤
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        break;
                    }
                    else {
                        System.out.println("\n다시 다른 메뉴를 입력해주세요!");
                    }
                }
            }
        }
    }
}