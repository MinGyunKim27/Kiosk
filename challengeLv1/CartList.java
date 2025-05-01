package challengeLv1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CartList {

    // 장바구니에 담긴 메뉴 아이템 리스트
    private List<MenuItemV1> CartList = new ArrayList<>();

    // 장바구니에 메뉴 아이템 추가
    public void addCart(MenuItemV1 menuItem){
        CartList.add(menuItem);
    }

    // 장바구니 전체 가져오기 (외부에서 읽기용)
    public List<MenuItemV1> getCartList() {
        return CartList;
    }

    // 장바구니에 외부에서 받은 리스트로 교체 (전체 덮어쓰기)
    public void setCartList(List<MenuItemV1> shopList1){
        this.CartList = shopList1;
    }

    // 특정 메뉴 아이템을 장바구니에서 삭제
    public void deleteCartByName(MenuItemV1 menuItemV1) {
        CartList.remove(menuItemV1);
    }

    // 장바구니가 비어 있는지 확인 (비어 있지 않으면 true 반환)
    public boolean validateEmpty(){
        return !CartList.isEmpty();
    }

    // 장바구니 전체 출력 및 총합 계산
    public double showAll(){
        int sequence = 1;
        double sumOfAll = 0.0;

        System.out.println("[ Orders ]");

        // 장바구니 아이템 순서대로 출력 + 가격 합산
        for (MenuItemV1 item : CartList){
            System.out.printf("%d. %-15s  | %s | %s\n",
                    sequence, item.getName(), item.getPrice(), item.getDescription());
            sumOfAll += Double.parseDouble(item.getPrice().replace("W", "").trim());
            sequence++;
        }

        // 총합 출력
        System.out.println("\n[ Total ]");
        System.out.printf("W %.1f\n", sumOfAll);

        return sumOfAll;
    }

}
