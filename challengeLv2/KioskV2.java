package challengeLv2;

import java.util.List;
import java.util.Scanner;

/**
 * KioskLV5 클래스
 * - 메뉴 카테고리 목록을 출력하고
 * - 사용자 입력을 받아
 * - 해당 카테고리의 메뉴를 보여주고
 * - 주문을 진행하는 키오스크 로직
 */
public class KioskV2 {

    public enum UserCase{
        Case1 (0.9,"국가유공자",1),
        Case2 (0.95,"군인",2),
        Case3 (0.97,"학생",3),
        Case4 (1.0,"일반",4);

        private final double percentage;
        private final String userCase;
        private final Integer Type;

        UserCase(double percentage, String userCase,Integer Type) {
            this.percentage = percentage;
            this.userCase = userCase;
            this.Type = Type;
        }

        public static double getPercentage(Integer Type){
            for (UserCase uc : values()) {
                if (uc.Type.equals(Type)) {
                    return uc.percentage;
                }
            }
            throw new RuntimeException();
        }

        public String getUserCase() {
            return userCase;
        }
    }

    private List<MenuItemV2> menuItems;      // 선택된 카테고리의 메뉴 아이템 목록
    private final List<MenuV2> menus;        // 전체 메뉴 카테고리 목록
    InputHandler input = new InputHandler();
    private CartListLV2 cartList;

    // 생성자: 카테고리별 메뉴 리스트를 주입받음
    public KioskV2(List<MenuV2> menus){
        this.menus = menus;
    }

    public void setShopList(CartListLV2 cartList) {
        this.cartList = cartList;
    }

    // 키오스크 메인 시작 메서드
    public int start(Scanner sc){

        if (cartList.validateEmpty()){
            System.out.println("아래 메뉴판으로 보시고 메뉴를 골라 입력해주세요");
        }

        showMenus();

        if (cartList.validateEmpty()){
            System.out.println("[ ORDER MENU ]\n" +
                    "4. Orders       | 장바구니를 확인 후 주문합니다.\n" +
                    "5. Cancel       | 진행중인 주문을 취소합니다.");
        }

        // ===== 사용자로부터 카테고리 번호 입력 받기 =====
        int categoryNumber = pickCategory();

        if (categoryNumber == 4){
            return order();
        }

        // 선택한 카테고리의 메뉴 목록 불러오기
        menuItems = menus.get(categoryNumber - 1).getCategory();

        // ===== 해당 카테고리 메뉴 선택 반복 =====
        while (true){
            showMenuItems(categoryNumber);

            // 메뉴 번호 입력
            int menuNumber = input.getInt("\n주문하려는 메뉴의 숫자를 입력하세요! : ");
            if (menuNumber == 0){
                System.out.println("프로그램이 종료됩니다.");
                return -1;
            } else {
                // 메뉴 상세 정보 출력
                MenuItemV2 selected = menuItems.get(menuNumber - 1);
                System.out.printf("\n선택한 메뉴 : %s | %s | %s |\n", selected.getName(), selected.getPrice(), selected.getDescription());

                // 확인 입력
                System.out.printf("\n| %s | %s | %s |\n위 메뉴를 장바구니에 추가하시겠습니까?\n", selected.getName(), selected.getPrice(), selected.getDescription());
                if (input.getInt("1. 확인     2. 취소 \n") == 1){
                    this.cartList.addCart(selected);
                    System.out.printf("\n%s 이 장바구니에 추가되었습니다.\n\n",selected.getName());
                    break; // 주문 완료 후 메뉴 반복 종료
                } else {
                    System.out.println("\n취소되었습니다.");
                }
            }
        }

        return 0; // 루프 종료 후 다시 메인 메뉴로 돌아갈 수 있도록
    }

    public int pickCategory(){
        int categoryNumber = 0;
        categoryNumber = input.getInt("주문하려는 카테고리를 고르세요!: ");
        if (categoryNumber == 0){
            System.out.println("프로그램이 종료됩니다.");
            return -1;
        }
        return categoryNumber;
    }

    public void showMenus(){
        System.out.println("              [ Main MENU ]                  ");
        int sequenceMenu = 1;
        for (MenuV2 menuTitle : menus){
            System.out.printf("%d. %-15s\n", sequenceMenu, menuTitle.getCategoryName());
            sequenceMenu ++;
        }
        System.out.println("0. 종료.\n");
    }

    public void showMenuItems(int categoryNumber){
        System.out.printf("\n              [ %s MENU ]               \n",menus.get(categoryNumber-1).getCategoryName());
        int sequence = 1;

        for (MenuItemV2 menu : menuItems){
            System.out.printf("%d. %-15s  | %s | %s\n", sequence,menu.getName(),menu.getPrice(),menu.getDescription());
            sequence ++;
        }
        System.out.println("0. 뒤로가기");
    }

    public int order(){
        System.out.println("아래와 같이 주문하시겠습니까?");
        double sum = cartList.showAllRefactored();
        int ans =  input.getInt("1. 주문     2. 메뉴판\n");
        if (ans == 1){
            double discountRate = discount();
            System.out.printf("주문이 완료되었습니다. 금액은 W %.1f 입니다.",sum*discountRate);
            return -1;
        }
        return 0;

    }

    public double discount(){
        int discountType = input.getInt("할인 정보를 입력해주세요.\n" +
                "1. 국가유공자 : 10% \n" +
                "2. 군인     :  5%\n" +
                "3. 학생     :  3%\n" +
                "4. 일반     :  0%\n");
        return UserCase.getPercentage(discountType);

    }


}
