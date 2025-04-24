package challengeLv1;

import java.util.ArrayList;
import java.util.List;

/**
 * MenuLV5 클래스
 * - 하나의 메뉴 카테고리(예: Hamburgers, Drinks, Desserts)를 나타냄
 * - 해당 카테고리의 메뉴 항목들을 리스트로 관리
 */
public class MenuV1 {

    // ===== 필드 =====

    private List<MenuItemV1> category = new ArrayList<>(); // 해당 카테고리에 포함된 메뉴 아이템들
    private String categoryName;                            // 카테고리 이름 (예: "Hamburgers")

    // ===== Setter 메서드 =====

    // 카테고리 이름 설정
    public void setCategoryName(String categoryName){
        this.categoryName = categoryName;
    }

    // 카테고리에 속한 메뉴 리스트 직접 설정
    public void setCategory(List<MenuItemV1> category){
        this.category = category;
    }

    // ===== Getter 메서드 =====

    // 카테고리 이름 반환
    public String getCategoryName() {
        return categoryName;
    }

    // 메뉴 리스트 반환
    public List<MenuItemV1> getCategory() {
        return category;
    }
}
