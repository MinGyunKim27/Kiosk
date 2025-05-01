package challengeLv2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CartListLV2 {

    // 장바구니 아이템 리스트
    private List<MenuItemV2> cartList = new ArrayList<>();

    // 장바구니에 메뉴 아이템 추가
    public void addCart(MenuItemV2 menuItem){
        cartList.add(menuItem);
    }

    // 장바구니 리스트 가져오기 (외부에서 읽기용)
    public List<MenuItemV2> getCartList() {
        return cartList;
    }

    // 외부 리스트의 아이템들을 장바구니에 추가 (전체 덮어쓰기 아님, 추가만)
    public void setCartList(List<MenuItemV2> shopList1){
        this.cartList.addAll(shopList1);
    }

    // 이름으로 장바구니 항목 삭제
    public int deleteCartByName(String name) {
        // 이름이 일치하는 메뉴 아이템 이름 리스트 생성
        List<String> deletedList = cartList.stream()
                .map(MenuItemV2::getName)
                .filter(itemName -> itemName.equals(name.trim()))
                .toList();

        if (deletedList.isEmpty()){
            System.out.println("일치하는 메뉴 명이 없습니다!");
            System.out.println("다시 입력하시오");
            return 1;  // 삭제 실패 (다시 시도)
        }
        else {
            // 이름이 일치하지 않는 항목만 남김 → 이름 일치 항목 삭제
            cartList = cartList.stream()
                    .filter(item -> !item.getName().equals(name))
                    .collect(Collectors.toList());
            System.out.println("삭제되었습니다!");
        }
        return -1;  // 삭제 성공
    }

    // 장바구니 비어 있는지 확인 (비어있지 않으면 true 반환)
    public boolean validateEmpty(){
        return !cartList.isEmpty();
    }

    // 장바구니 전체 출력 및 합계 계산
    public double showAllRefactored() {
        if (cartList.isEmpty()) {
            return 0.0;
        }

        System.out.println("[ Orders ]");

        // 메뉴 항목 출력
        cartList.stream()
                .forEach(item -> System.out.printf("%-15s  | %s | %s\n",
                        item.getName(), item.getPrice(), item.getDescription()));

        // 합계 계산 (문자열에서 "W" 제거 후 double로 변환)
        double sumOfAll = cartList.stream()
                .mapToDouble(item -> Double.parseDouble(item.getPrice().replace("W", "").trim()))
                .sum();

        System.out.println("\n[ Total ]");
        System.out.printf("W %.1f\n", sumOfAll);

        return sumOfAll;
    }
}
