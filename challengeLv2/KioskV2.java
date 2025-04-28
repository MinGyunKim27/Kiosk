package challengeLv2;

import java.util.List;
import java.util.Scanner;

public class KioskV2 {

    // 주문, 취소 메뉴 번호 상수화
    private static final int ORDER_MENU = 4;
    private static final int CANCEL_MENU = 5;

    public enum UserCase {
        Case1(0.9, "국가유공자", 1),
        Case2(0.95, "군인", 2),
        Case3(0.97, "학생", 3),
        Case4(1.0, "일반", 4);

        private final double percentage;
        private final String userCase;
        private final Integer type;

        UserCase(double percentage, String userCase, Integer type) {
            this.percentage = percentage;
            this.userCase = userCase;
            this.type = type;
        }

        public static double getPercentage(Integer type) {
            for (UserCase uc : values()) {
                if (uc.type.equals(type)) {
                    return uc.percentage;
                }
            }
            throw new IllegalArgumentException("잘못된 할인 타입입니다.");
        }
    }

    private List<MenuItemV2> menuItems;
    private final List<MenuV2> menus;
    private final InputHandler input = new InputHandler();
    private CartListLV2 cartList;

    public KioskV2(List<MenuV2> menus) {
        this.menus = menus;
    }

    public void setShopList(CartListLV2 cartList) {
        this.cartList = cartList;
    }

    public int start(Scanner sc) {
        if (cartList == null) {
            throw new IllegalStateException("CartList가 설정되지 않았습니다.");
        }

        boolean cartListBoolean = cartList.validateEmpty();

        if (cartListBoolean) {
            System.out.println("아래 메뉴판으로 보시고 메뉴를 골라 입력해주세요");
        }

        showMainMenu();

        if (cartListBoolean) {
            System.out.println("[ ORDER MENU ]\n" +
                    ORDER_MENU + ". Orders       | 장바구니를 확인 후 주문합니다.\n" +
                    CANCEL_MENU + ". Cancel       | 진행중인 주문을 취소합니다.");
        }

        int categoryNumber = selectCategory(!cartListBoolean);

        if (cartListBoolean) {
            if (categoryNumber == ORDER_MENU) {
                return processOrder();
            }
            if (categoryNumber == CANCEL_MENU) {
                return 0;
            }
        }

        menuItems = menus.get(categoryNumber - 1).getCategory();
        return handleMenuSelection(categoryNumber);
    }

    public int selectCategory(boolean cart) {
        int max = cart ? 3 : 5;
        int categoryNumber = input.getIntInRange("주문하려는 카테고리를 고르세요!: ", 0, max);

        if (categoryNumber == 0) {
            System.out.println("처음으로 돌아갑니다!");
        }
        return categoryNumber;
    }

    public void showMainMenu() {
        System.out.println("              [ Main MENU ]                  ");
        int sequenceMenu = 1;
        for (MenuV2 menuTitle : menus) {
            System.out.printf("%d. %-15s\n", sequenceMenu, menuTitle.getCategoryName());
            sequenceMenu++;
        }
        System.out.println("0. 종료.\n");
    }

    public void showCategoryMenuItems(int categoryNumber) {
        System.out.printf("\n              [ %s MENU ]               \n", menus.get(categoryNumber - 1).getCategoryName());
        int sequence = 1;
        for (MenuItemV2 menu : menuItems) {
            System.out.printf("%d. %-15s  | %s | %s\n", sequence, menu.getName(), menu.getPrice(), menu.getDescription());
            sequence++;
        }
        System.out.println("0. 뒤로가기");
    }

    public int processOrder() {
        System.out.println("\n아래와 같이 주문하시겠습니까?\n\n");
        double sum = cartList.showAllRefactored();
        int ans = input.getIntInRange("1. 주문     2. 메뉴판     3. 삭제\n", 1, 3);

        if (ans == 1) {
            double discountRate = calculateDiscount();
            System.out.printf("주문이 완료되었습니다. 금액은 W %.1f 입니다.", sum * discountRate);
            return -1;
        } else if (ans == 3) {
            int validate = 1;
            while (validate == 1) {
                String deleteMenu = input.getString("삭제하고 싶은 메뉴 이름을 입력하시오 (삭제 취소 : 0) : ");
                if (deleteMenu.equals("0")) {
                    break;
                }
                validate = cartList.deleteCartByName(deleteMenu);
            }
            return 0;
        }
        return 0;
    }

    public int handleMenuSelection(int categoryNumber) {
        while (true) {
            showCategoryMenuItems(categoryNumber);

            int menuNumber = input.getIntInRange("\n주문하려는 메뉴의 숫자를 입력하세요! : ", 0, 4);

            if (menuNumber == 0) {
                System.out.println("프로그램이 종료됩니다.");
                return -1;
            }

            MenuItemV2 selected = menuItems.get(menuNumber - 1);
            System.out.printf("\n선택한 메뉴 : %s | %s | %s |\n", selected.getName(), selected.getPrice(), selected.getDescription());

            System.out.printf("\n| %s | %s | %s |\n위 메뉴를 장바구니에 추가하시겠습니까?\n", selected.getName(), selected.getPrice(), selected.getDescription());
            if (input.getIntInRange("1. 확인     2. 취소 \n", 1, 2) == 1) {
                cartList.addCart(selected);
                System.out.printf("\n%s 이 장바구니에 추가되었습니다.\n\n", selected.getName());
                break;
            } else {
                System.out.println("\n취소되었습니다.");
            }
        }
        return 0;
    }

    public double calculateDiscount() {
        int discountType = input.getIntInRange("""
                할인 정보를 입력해주세요.
                1. 국가유공자 : 10% 
                2. 군인     :  5%
                3. 학생     :  3%
                4. 일반     :  0%
                """, 1, 4);

        return UserCase.getPercentage(discountType);
    }
}
