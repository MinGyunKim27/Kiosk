import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MenuItem cheeseburger = new MenuItem();
        cheeseburger.setMenu("chesseBurger","W 7.5","소고기 패티와, 치즈가 3장이나 들어간 버거!");
        MenuItem hamburger = new MenuItem();
        hamburger.setMenu("Hamburger","W 6.9", "풍성한 야채와 맛있는 소고기 패티가 들어간 기본 버거!");
        MenuItem mushroomBurger = new MenuItem();
        mushroomBurger.setMenu("MushroomBurger", "W 7.8", "가게 시그니처 메뉴! 특제 소스와 감칠맛 넘치는 버섯이 추가된 특별한 버거!");
        MenuItem chickenBurger = new MenuItem();
        chickenBurger.setMenu("ChickenBurger","W 6.5","치킨 패티가 들어간 매콤한 소스로 입안을 사로잡는 치킨 버거!");

        List<MenuItem> menuItems = new ArrayList<MenuItem>();
        menuItems.add(cheeseburger);
        menuItems.add(chickenBurger);
        menuItems.add(mushroomBurger);
        menuItems.add(hamburger);

        System.out.println("[ J-BURGER MENU ]");
        int sequence = 1;
        for (MenuItem menu : menuItems){
            System.out.printf("%d. %-15s  | %s | %s\n", sequence,menu.getName(),menu.getPrice(),menu.getDescription());
            sequence ++;
        }
    }
}