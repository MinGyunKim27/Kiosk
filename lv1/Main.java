package lv1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("[ SHAKESHACK MENU ]\n" +
                "1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거\n" +
                "2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거\n" +
                "3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거\n" +
                "4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거\n" +
                "0. 종료      | 종료\n");


        while (true){
            System.out.print("\n원하시는 메뉴의 번호를 입력해 주세요 : ");
            String answer = scanner.next();
            switch (answer){
                case "1" : System.out.print("ShackBurger를 주문 하시겠습니까? \n맞으시면 1을 입력해 주세요 : ");
                    if(scanner.next().equals("1")){
                        System.out.println("주문 완료했습니다. 영수증을 수령해주세요");
                        System.out.println("프로그램을 종료합니다.");
                        return;
                    }
                    else {
                        System.out.println("\n다시 다른 메뉴를 입력해주세요!");
                    }

                    break;
                case "2" : System.out.print("SmokeShack 주문 하시겠습니까? \n맞으시면 1을 입력해 주세요");
                    if(scanner.next().equals("1")){
                        System.out.println("주문 완료했습니다. 영수증을 수령해주세요");
                        System.out.println("프로그램을 종료합니다.");
                        return;
                    }
                    else {
                        System.out.println("\n다시 다른 메뉴를 입력해주세요!");
                    }
                    break;
                case "3" : System.out.print("Cheeseburger 주문 하시겠습니까? \n맞으시면 1을 입력해 주세요");
                    if(scanner.next().equals("1")){
                        System.out.println("주문 완료했습니다. 영수증을 수령해주세요");
                        System.out.println("프로그램을 종료합니다.");
                        return;
                    }
                    else {
                        System.out.println("\n다시 다른 메뉴를 입력해주세요!");
                    }

                    break;
                case "4" : System.out.print("Hamburger 주문 하시겠습니까? \n맞으시면 1을 입력해 주세요");
                    if(scanner.next().equals("1")){
                        System.out.println("주문 완료했습니다. 영수증을 수령해주세요");
                        System.out.println("프로그램을 종료합니다.");
                        return;
                    }
                    else {
                        System.out.println("\n다시 다른 메뉴를 입력해주세요!");
                    }

                    break;
                case "5" :
                    System.out.println("프로그램을 종료합니다.");
                    break;
            }


        }



    }
}
