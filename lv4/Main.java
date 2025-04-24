package lv4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void setMenu(String name, String price, String description, MenuItemLV4 menuItem){
        menuItem.name = name;
        menuItem.description = description;
        menuItem.price = price;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<MenuLV4> menuList = new ArrayList<>();

        MenuLV4 hamburgers = new MenuLV4();
        MenuLV4 drinks = new MenuLV4();
        MenuLV4 desserts = new MenuLV4();

        menuList.add(hamburgers);
        menuList.add(drinks);
        menuList.add(desserts);


        KioskLV4 kiosk = new KioskLV4(menuList);

        //햄버거 메뉴 세팅
        MenuItemLV4 cheeseburger = new MenuItemLV4();
        setMenu("cheeseBurger","W 7.5","소고기 패티와, 치즈가 3장이나 들어간 버거!",cheeseburger);
        MenuItemLV4 hamburger = new MenuItemLV4();
        setMenu("Hamburger","W 6.9","풍성한 야채와 맛있는 소고기 패티가 들어간 기본 버거!",hamburger);
        MenuItemLV4 mushroomBurger = new MenuItemLV4();
        setMenu("mushroomBurger","W 7.8","특제 소스와 그릴로 구운 버섯이 틀어간 시그니처 버거!",mushroomBurger);
        MenuItemLV4 chickenBurger = new MenuItemLV4();
        setMenu("ChickenBurger","W 6.5","치킨 패티가 들어간 매콤한 소스로 입안을 사로잡는 치킨 버거!",chickenBurger);

        //음료 메뉴 세팅
        MenuItemLV4 coke = new MenuItemLV4();
        setMenu("Coke", "W 2.0", "톡 쏘는 탄산이 매력적인 코카콜라!", coke);
        MenuItemLV4 sprite = new MenuItemLV4();
        setMenu("Sprite", "W 2.0", "레몬향이 상큼한 스프라이트!", sprite);
        MenuItemLV4 orangeJuice = new MenuItemLV4();
        setMenu("Orange Juice", "W 2.5", "신선한 오렌지를 그대로 담은 100% 오렌지 주스!", orangeJuice);
        MenuItemLV4 icedTea = new MenuItemLV4();
        setMenu("Iced Tea", "W 2.3", "달콤한 복숭아향이 나는 시원한 아이스티!", icedTea);

        // 디저트 메뉴 세팅
        MenuItemLV4 vanillaIceCream = new MenuItemLV4();
        setMenu("Vanilla Ice Cream", "W 1.8", "부드럽고 진한 바닐라 아이스크림!", vanillaIceCream);
        MenuItemLV4 chocolateCake = new MenuItemLV4();
        setMenu("Chocolate Cake", "W 3.0", "진한 초콜릿이 가득한 촉촉한 케이크!", chocolateCake);
        MenuItemLV4 applePie = new MenuItemLV4();
        setMenu("Apple Pie", "W 2.7", "따뜻한 사과 속이 들어간 바삭한 애플파이!", applePie);
        MenuItemLV4 churros = new MenuItemLV4();
        setMenu("Churros", "W 2.5", "달콤한 시나몬 슈가가 뿌려진 바삭한 츄러스!", churros);

        // 리스트에 추가
        hamburgers.category.add(cheeseburger);
        hamburgers.category.add(chickenBurger);
        hamburgers.category.add(mushroomBurger);
        hamburgers.category.add(hamburger);

        drinks.category.add(coke);
        drinks.category.add(sprite);
        drinks.category.add(orangeJuice);
        drinks.category.add(icedTea);

        desserts.category.add(vanillaIceCream);
        desserts.category.add(chocolateCake);
        desserts.category.add(applePie);
        desserts.category.add(churros);

        //menu 들 삽입
        hamburgers.categoryName = "Hamburgers";
        drinks.categoryName = "Drinks";
        desserts.categoryName = "Desserts";


        while (true){
            int breakNum = kiosk.start(sc);
            if (breakNum == 1){
                break;
            }
        }
    }
}