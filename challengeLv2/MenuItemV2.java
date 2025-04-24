package challengeLv2;

/**
 * 단일 메뉴 아이템(햄버거, 음료, 디저트 등)의 정보를 저장하는 클래스
 * - name: 메뉴 이름
 * - price: 메뉴 가격 (문자열 형식으로 저장, e.g., "W 7.5")
 * - description: 메뉴 설명
 */
public class MenuItemV2 {

    // ===== 필드 =====
    private String name;        // 메뉴 이름
    private String price;       // 메뉴 가격
    private String description; // 메뉴 설명

    // ===== 기본 생성자 =====
    public MenuItemV2() {}

    // ===== 전체 필드 초기화 메서드 (bulk setter, 초기화 헬퍼) =====
    public void setMenu(String name, String price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // ===== 개별 필드 설정자 (setter) =====
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // ===== 개별 필드 접근자 (getter) =====
    public String getName() {
        return this.name;
    }

    public String getPrice() {
        return this.price;
    }

    public String getDescription() {
        return this.description;
    }
}
