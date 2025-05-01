package challengeLv2;

import java.util.List;
import java.util.Scanner;

public class KioskV2 {

    // 주문, 취소 메뉴 번호 상수화
    private static final int ORDER_MENU = 4;
    private static final int CANCEL_MENU = 5;

    // 선택된 카테고리의 메뉴 아이템 리스트
    private List<MenuItemV2> menuItems;

    // 전체 메뉴 리스트
    private final List<MenuV2> menus;

    // 사용자 입력 처리 객체
    private final InputHandler input = new InputHandler();

    // 장바구니 객체
    private CartListLV2 cartList;

    // 생성자: 메뉴 리스트 주입
    public KioskV2(List<MenuV2> menus) {
        this.menus = menus;
    }

    // 장바구니 객체 주입
    public void setShopList(CartListLV2 cartList) {
        this.cartList = cartList;
    }

    // 키오스크 실행 메인 메서드
    public int start(Scanner sc) {
        boolean cartListBoolean = cartList.validateEmpty();
        showMainMenu(cartListBoolean);

        int categoryNumber = selectCategory(!cartListBoolean);

        // 주문 또는 취소 처리
        if (cartListBoolean) {
            if (categoryNumber == ORDER_MENU) {
                return processOrder();
            }
            if (categoryNumber == CANCEL_MENU) {
                return 0;
            }
        }

        // 카테고리 선택 → 메뉴 선택 단계로 진행
        menuItems = menus.get(categoryNumber - 1).getCategory();
        return handleMenuSelection(categoryNumber);
    }

    // 카테고리 선택 처리
    public int selectCategory(boolean cart) {
        int max = cart ? 3 : 5;  // 장바구니 비어있으면 메뉴만, 있으면 주문/취소 포함
        int categoryNumber = input.getIntInRange("주문하려는 카테고리를 고르세요!: ", 0, max);

        if (categoryNumber == 0) {
            System.out.println("처음으로 돌아갑니다!");
        }
        return categoryNumber;
    }

    // 메인 메뉴 출력
    public void showMainMenu(boolean cartList) {
        if (cartList){
            System.out.println("아래 메뉴판으로 보시고 메뉴를 골라 입력해주세요");
        }

        System.out.println("              [ Main MENUS ]                  ");
        int sequenceMenu = 1;
        for (MenuV2 menuTitle : menus) {
            System.out.printf("%d. %-15s\n", sequenceMenu, menuTitle.getCategoryName());
            sequenceMenu++;
        }
        System.out.println("0. 종료.\n");

        if (cartList){
            System.out.println("[ ORDER MENU ]\n" +
                    ORDER_MENU + ". Orders       | 장바구니를 확인 후 주문합니다.\n" +
                    CANCEL_MENU + ". Cancel       | 진행중인 주문을 취소합니다.");
        }
    }

    // 선택된 카테고리의 메뉴 아이템들 출력
    public void showCategoryMenuItems(int categoryNumber) {
        System.out.printf("\n              [ %s MENU ]               \n", menus.get(categoryNumber - 1).getCategoryName());
        int sequence = 1;
        for (MenuItemV2 menu : menuItems) {
            System.out.printf("%d. %-15s  | %s | %s\n", sequence, menu.getName(), menu.getPrice(), menu.getDescription());
            sequence++;
        }
        System.out.println("0. 뒤로가기");
    }

    // 주문 처리: 합계 계산, 할인 적용, 주문 확정
    public int processOrder() {
        System.out.println("\n아래와 같이 주문하시겠습니까?\n\n");
        double sum = cartList.showAllRefactored();
        int ans = input.getIntInRange("1. 주문     2. 메뉴판     3. 삭제\n", 1, 3);

        if (ans == 1) {
            double discountRate = calculateDiscount();
            System.out.printf("주문이 완료되었습니다. 금액은 W %.1f 입니다.", sum * discountRate);
            return -1;  // 종료 신호
        } else if (ans == 3) {
            // 메뉴 삭제 처리
            int validate = 1;
            while (validate == 1) {
                String deleteMenu = input.getString("삭제하고 싶은 메뉴 이름을 입력하시오 (삭제 취소 : 0) : ");
                if (deleteMenu.equals("0")) {
                    break;
                }
                validate = cartList.deleteCartByName(deleteMenu);
            }
            return 0;  // 초기 화면으로
        }
        return 0;
    }

    // 카테고리 내 메뉴 선택 처리
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

    // 할인율 계산
    public double calculateDiscount() {
        int discountType = input.getIntInRange("""
                할인 정보를 입력해주세요.
                1. 국가유공자 : 10%\s
                2. 군인     :  5%
                3. 학생     :  3%
                4. 일반     :  0%
               \s""", 1, 4);

        return UserCase.getPercentage(discountType);
    }
}
