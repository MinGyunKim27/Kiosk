package lv5;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * InputHandler 클래스
 * - 사용자로부터 정수(int) 입력을 안전하게 받기 위한 클래스
 * - 숫자 외의 입력이 들어올 경우 예외 처리하여 재입력 유도
 */
public class InputHandler {

    private final Scanner scanner = new Scanner(System.in); // 표준 입력을 위한 Scanner 객체

    /**
     * 사용자로부터 정수형 숫자를 입력받는 메서드
     * - 메시지를 출력하고, 숫자를 입력받음
     * - 숫자가 아닌 값이 들어오면 예외 메시지를 출력하고 다시 입력받음
     *
     * @param message 사용자에게 출력할 메시지
     * @return 입력받은 정수 값
     */
    public Integer getInt(String message) {
        int input;
        while (true) {
            System.out.print(message); // 메시지 출력
            try {
                input = scanner.nextInt(); // 사용자 입력 시도
                return input;             // 정상 입력되면 반환
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                scanner.nextLine(); // 입력 버퍼 비워서 다음 입력을 받기 위한 준비
            }
        }
    }
}
