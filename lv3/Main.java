package lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    private static Thread Tread;

    public static void setMenu(String name,String price, String description,MenuItemLV3 menuItemLV3){
        menuItemLV3.name = name;
        menuItemLV3.description = description;
        menuItemLV3.price = price;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<MenuItemLV3> menuItems = new ArrayList<>();
        KioskLV3 kiosk = new KioskLV3(menuItems);

        MenuItemLV3 cheeseburger = new MenuItemLV3();
        setMenu("cheeseBurger","W 7.5","소고기 패티와, 치즈가 3장이나 들어간 버거!",cheeseburger);

        MenuItemLV3 hamburger = new MenuItemLV3();
        setMenu("Hamburger","W 6.9","풍성한 야채와 맛있는 소고기 패티가 들어간 기본 버거!",hamburger);

        MenuItemLV3 mushroomBurger = new MenuItemLV3();
        setMenu("mushroomBurger","W 7.8","특제 소스와 그릴로 구운 버섯이 틀어간 시그니처 버거!",mushroomBurger);

        MenuItemLV3 chickenBurger = new MenuItemLV3();
        setMenu("ChickenBurger","W 6.5","치킨 패티가 들어간 매콤한 소스로 입안을 사로잡는 치킨 버거!",chickenBurger);



        menuItems.add(cheeseburger);
        menuItems.add(chickenBurger);
        menuItems.add(mushroomBurger);
        menuItems.add(hamburger);

        while (true){
            int breakNum = kiosk.start(sc);
            if (breakNum == 1){
                break;
            }
        }
    }
}