package challengeLv1;

import java.util.List;
import java.util.Scanner;

public class KioskV1 {

    private List<MenuItemV1> menuItems;
    private final List<MenuV1> menus;
    InputHandler input = new InputHandler();
    private CartList cartList;

    public KioskV1(List<MenuV1> menus){
        this.menus = menus;
    }

    public void setShopList(CartList cartList) {
        this.cartList = cartList;
    }

    public int start(Scanner sc){

        boolean cartListBoolean = cartList.validateEmpty();

        if (cartListBoolean){
            System.out.println("아래 메뉴판으로 보시고 메뉴를 골라 입력해주세요");
            showMainMenu();
            System.out.println("[ ORDER MENU ]\n" +
                    "4. Orders       | 장바구니를 확인 후 주문합니다.\n" +
                    "5. Cancel       | 진행중인 주문을 취소합니다.");
        } else {
            showMainMenu();
        }

        int categoryNumber = selectCategory(!cartListBoolean);

        if (categoryNumber == 4){
            return processOrder();
        }

        if (categoryNumber == 5){
            return 0;
        }

        menuItems = menus.get(categoryNumber - 1).getCategory();

        while (true){
            showCategoryMenuItems(categoryNumber);

            int menuNumber = input.getIntInRange("\n주문하려는 메뉴의 숫자를 입력하세요! : ", 0, 4);

            if (menuNumber == 0){
                System.out.println("처음으로 돌아갑니다.");
                return 0;
            } else {
                MenuItemV1 selected = menuItems.get(menuNumber - 1);
                System.out.printf("\n선택한 메뉴 : %s | %s | %s |\n", selected.getName(), selected.getPrice(), selected.getDescription());

                System.out.printf("\n| %s | %s | %s |\n위 메뉴를 장바구니에 추가하시겠습니까?\n", selected.getName(), selected.getPrice(), selected.getDescription());
                if (input.getIntInRange("1. 확인     2. 취소 \n", 1, 2) == 1){
                    cartList.addCart(selected);
                    System.out.printf("\n%s 이 장바구니에 추가되었습니다.\n\n", selected.getName());
                    break;
                } else {
                    System.out.println("\n취소되었습니다.");
                }
            }
        }

        return 0;
    }

    public int selectCategory(boolean cart){
        int categoryNumber;

        if (cart){
            categoryNumber = input.getIntInRange("주문하려는 카테고리를 고르세요!: ", 0, 3);
        } else {
            categoryNumber = input.getIntInRange("주문하려는 카테고리를 고르세요!: ", 0, 5);
        }

        if (categoryNumber == 0){
            System.out.println("처음으로 돌아갑니다!");
            return 0;
        }

        return categoryNumber;
    }

    public void showMainMenu(){
        System.out.println("              [ Main MENU ]                  ");
        int sequenceMenu = 1;
        for (MenuV1 menuTitle : menus){
            System.out.printf("%d. %-18s\n", sequenceMenu, menuTitle.getCategoryName());
            sequenceMenu++;
        }
        System.out.println("0. 종료.\n");
    }

    public void showCategoryMenuItems(int categoryNumber){
        System.out.printf("\n              [ %s MENU ]               \n", menus.get(categoryNumber-1).getCategoryName());
        int sequence = 1;
        for (MenuItemV1 menu : menuItems){
            System.out.printf("%d. %-18s  | %s | %s\n", sequence, menu.getName(), menu.getPrice(), menu.getDescription());
            sequence++;
        }
        System.out.println("0. 뒤로가기");
    }

    public int processOrder(){
        System.out.println("\n아래와 같이 주문하시겠습니까?\n\n");
        double sum = cartList.showAll();
        int ans = input.getIntInRange("1. 주문     2. 메뉴판\n", 1, 2);
        if (ans == 1){
            System.out.printf("주문이 완료되었습니다. 금액은 W %.1f 입니다.", sum);
            return -1;
        }
        return 0;
    }
}
