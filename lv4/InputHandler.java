package lv4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandler {

    private final Scanner scanner = new Scanner(System.in);

    public Integer getInt(String message){
        int input;
        while (true) {
            System.out.print(message);
            try {
                input = scanner.nextInt();
                return input;
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                scanner.nextLine(); // 입력 버퍼 정리
            }
        }
    }
}
