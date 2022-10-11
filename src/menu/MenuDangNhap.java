package menu;

import manage.ManageAccount;

import java.util.Scanner;

public class MenuDangNhap {
    public static MenuDangNhap menuDangNhap;
    ManageAccount manageAccount = new ManageAccount();

    Scanner sc = new Scanner(System.in);

    public void ManHinhDangNhap() {
        while (true) {
            System.out.println("1. Đăng nhập");
            System.out.println("2. Đăng ký");
            int choice = 0;
            while (choice < 1 || choice > 2) {
                try {
                    choice = Integer.parseInt(sc.nextLine());
                    if (choice < 1 || choice > 2) {
                        System.out.println("Bạn chỉ được chọn 1 hoặc 2 thôi");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Nhập số !");
                }
            }
            switch (choice) {
                case 1:
                    manageAccount.login();
                    break;
                case 2:
                    manageAccount.register();
                    break;
                case 3:
                    return;
            }
        }


    }


}



