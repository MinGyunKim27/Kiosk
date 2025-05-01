package challengeLv2;

import java.util.HashMap;
import java.util.Map;

public enum UserCase {
    Case1(0.9, "국가유공자", 1),
    Case2(0.95, "군인", 2),
    Case3(0.97, "학생", 3),
    Case4(1.0, "일반", 4);

    private final double percentage;
    private final String userCase;
    private final Integer type;
    private static final Map<Integer, UserCase> TYPE_MAP = new HashMap<>();

    static {
        for (UserCase uc : values()) {
            UserCase.TYPE_MAP.put(uc.type, uc);
        }
    }

    UserCase(double percentage, String userCase, Integer type) {
        this.percentage = percentage;
        this.userCase = userCase;
        this.type = type;
    }

    public static double getPercentage(Integer type) {
        UserCase uc = TYPE_MAP.get(type);
        if (uc == null) {
            throw new IllegalArgumentException("잘못된 할인 타입입니다.");
        }
        return uc.percentage;
    }

}