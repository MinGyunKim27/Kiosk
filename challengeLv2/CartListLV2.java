package challengeLv2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CartListLV2 {
    private List<MenuItemV2> CartList = new ArrayList<>();

    public void addCart(MenuItemV2 menuItem){
        CartList.add(menuItem);
    }

    public List<MenuItemV2> getCartList() {
        return CartList;
    }

    public void setCartList(List<MenuItemV2> shopList1){
        this.CartList = shopList1;
    }

    public void deleteCartByName(String name) {
        CartList = CartList.stream()
                .filter(item -> !item.getName().equals(name))  // 해당 이름이 아닌 것만 필터링
                .collect(Collectors.toList());
    }

    public boolean validateEmpty(){
        return !CartList.isEmpty();
    }

    public double showAll(){
        int sequence = 1;
        double sumOfAll = 0.0;
        if (!CartList.isEmpty()){
            System.out.println("[ Orders ]");
            for (MenuItemV2 item: CartList){
                System.out.printf("%d. %-15s  | %s | %s\n", sequence,item.getName(),item.getPrice(),item.getDescription());
                sumOfAll +=  Double.parseDouble(item.getPrice().replace("W","").trim());
                sequence ++;
            }
            System.out.println("\n[ Total ]");
            System.out.printf("W %.1f\n",sumOfAll);

        }
        return sumOfAll;
    }

    public double showAllRefactored() {
        if (CartList.isEmpty()) {
            return 0.0;
        }

        System.out.println("[ Orders ]");

        // 메뉴 출력
        CartList.stream()
                .forEach(item -> System.out.printf("%-15s  | %s | %s\n",
                        item.getName(), item.getPrice(), item.getDescription()));

        // 합계 계산
        double sumOfAll = CartList.stream()
                .mapToDouble(item -> Double.parseDouble(item.getPrice().replace("W", "").trim()))
                .sum();

        System.out.println("\n[ Total ]");
        System.out.printf("W %.1f\n", sumOfAll);

        return sumOfAll;
    }

}
