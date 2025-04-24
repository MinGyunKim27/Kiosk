package lv4;

import java.util.ArrayList;
import java.util.List;

public class MenuLV4 {
    public List<MenuItemLV4> category = new ArrayList<>();
    public String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public List<MenuItemLV4> getCategory() {
        return category;
    }
}
