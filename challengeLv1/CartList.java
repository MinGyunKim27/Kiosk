package challengeLv1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CartList {
    private List<MenuItemV1> CartList = new ArrayList<>();

    public void addCart(MenuItemV1 menuItem){
        CartList.add(menuItem);
    }

    public List<MenuItemV1> getCartList() {
        return CartList;
    }

    public void setCartList(List<MenuItemV1> shopList1){
        this.CartList = shopList1;
    }

    public void deleteCartByName(MenuItemV1 menuItemV1) {
        CartList.remove(menuItemV1);
    }

    public boolean validateEmpty(){
        return !CartList.isEmpty();
    }

    public double showAll(){
        int sequence = 1;
        double sumOfAll = 0.0;
        if (!CartList.isEmpty()){
            System.out.println("[ Orders ]");
            for (MenuItemV1 item: CartList){
                System.out.printf("%d. %-15s  | %s | %s\n", sequence,item.getName(),item.getPrice(),item.getDescription());
                sumOfAll +=  Double.parseDouble(item.getPrice().replace("W","").trim());
                sequence ++;
            }
            System.out.println("\n[ Total ]");
            System.out.printf("W %.1f\n",sumOfAll);

        }
        return sumOfAll;
    }

}
