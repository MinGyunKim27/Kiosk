package challengeLv1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 메뉴 카테고리 리스트 생성
        List<MenuV1> menuList = new ArrayList<>();

        // 각 카테고리 객체 생성
        MenuV1 hamburgers = new MenuV1();
        MenuV1 drinks = new MenuV1();
        MenuV1 desserts = new MenuV1();

        // 카테고리들을 전체 메뉴 리스트에 추가
        menuList.add(hamburgers);
        menuList.add(drinks);
        menuList.add(desserts);

        // 키오스크에 메뉴 리스트 전달
        KioskV1 kiosk = new KioskV1(menuList);

        // ===== 햄버거 메뉴 세팅 =====
        MenuItemV1 cheeseburger = new MenuItemV1();
        cheeseburger.setMenu("cheeseBurger", "W 7.5", "소고기 패티와, 치즈가 3장이나 들어간 버거!");

        MenuItemV1 hamburger = new MenuItemV1();
        hamburger.setMenu("Hamburger", "W 6.9", "풍성한 야채와 맛있는 소고기 패티가 들어간 기본 버거!");

        MenuItemV1 mushroomBurger = new MenuItemV1();
        mushroomBurger.setMenu("mushroomBurger", "W 7.8", "특제 소스와 그릴로 구운 버섯이 틀어간 시그니처 버거!");

        MenuItemV1 chickenBurger = new MenuItemV1();
        chickenBurger.setMenu("ChickenBurger", "W 6.5", "치킨 패티가 들어간 매콤한 소스로 입안을 사로잡는 치킨 버거!");

        // ===== 음료 메뉴 세팅 =====
        MenuItemV1 coke = new MenuItemV1();
        coke.setMenu("Coke", "W 2.0", "톡 쏘는 탄산이 매력적인 코카콜라!");

        MenuItemV1 sprite = new MenuItemV1();
        sprite.setMenu("Sprite", "W 2.0", "레몬향이 상큼한 스프라이트!");

        MenuItemV1 orangeJuice = new MenuItemV1();
        orangeJuice.setMenu("Orange Juice", "W 2.5", "신선한 오렌지를 그대로 담은 100% 오렌지 주스!");

        MenuItemV1 icedTea = new MenuItemV1();
        icedTea.setMenu("Iced Tea", "W 2.3", "달콤한 복숭아향이 나는 시원한 아이스티!");

        // ===== 디저트 메뉴 세팅 =====
        MenuItemV1 vanillaIceCream = new MenuItemV1();
        vanillaIceCream.setMenu("Vanilla Ice Cream", "W 1.8", "부드럽고 진한 바닐라 아이스크림!");

        MenuItemV1 chocolateCake = new MenuItemV1();
        chocolateCake.setMenu("Chocolate Cake", "W 3.0", "진한 초콜릿이 가득한 촉촉한 케이크!");

        MenuItemV1 applePie = new MenuItemV1();
        applePie.setMenu("Apple Pie", "W 2.7", "따뜻한 사과 속이 들어간 바삭한 애플파이!");

        MenuItemV1 churros = new MenuItemV1();
        churros.setMenu("Churros", "W 2.5", "달콤한 시나몬 슈가가 뿌려진 바삭한 츄러스!");

        // ===== 각 카테고리에 메뉴 아이템 추가 =====
        hamburgers.getCategory().add(cheeseburger);
        hamburgers.getCategory().add(chickenBurger);
        hamburgers.getCategory().add(mushroomBurger);
        hamburgers.getCategory().add(hamburger);

        drinks.getCategory().add(coke);
        drinks.getCategory().add(sprite);
        drinks.getCategory().add(orangeJuice);
        drinks.getCategory().add(icedTea);

        desserts.getCategory().add(vanillaIceCream);
        desserts.getCategory().add(chocolateCake);
        desserts.getCategory().add(applePie);
        desserts.getCategory().add(churros);

        // ===== 카테고리 이름 설정 =====
        hamburgers.setCategoryName("Hamburgers");
        drinks.setCategoryName("Drinks");
        desserts.setCategoryName("Desserts");

        // ===== 키오스크 시작 =====
        while (true) {
            int breakNum = kiosk.start(sc); // 사용자 입력으로 메뉴 탐색 시작
            if (breakNum == 1) {
                break; // 사용자가 종료를 선택하면 루프 탈출
            }
        }
    }
}
