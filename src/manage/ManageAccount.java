package manage;

import io.Write_Read;
import menu.MenuDangNhap;
//import menu.Menu_User;
import models.Products;
import models.User;
import validate.ValiDate;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ManageAccount {
    File file = new File("F:\\Java\\Case Module 2\\src\\fileText\\text.txt");
    File file2 = new File("F:\\Java\\Case Module 2\\src\\fileText\\giohang.txt");

    Write_Read<User> write_read = new Write_Read<>();
    Write_Read<Products> write_read2 = new Write_Read<>();

    ArrayList<User> users = write_read.read(file);
    ArrayList<Products> gioHang = write_read2.read(file2);

    Scanner sc = new Scanner(System.in);

    ManageProducts manageProducts = new ManageProducts();

    ValiDate valiDate = new ValiDate();


    public void login() {
        System.out.println("Nhập username: ");
        String username = sc.nextLine();

        System.out.println("Nhập password: ");
        String password = sc.nextLine();
        int choice = 0;
        if (username.equals("Admin") && password.equals("123")) {
            menuAdmin();
            ++choice;
        } else {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getUsername().equals(username) && users.get(i).getPassword().equals(password)) {
                    menu_User();
                    ++choice;
                }
            }
        }
        if (choice == 0) {
            System.out.println("Tài khoản hoặc mật khẩu không tồn tại!!!");
        }


    }

    public void menuAdmin() {
        while (true) {
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị sản phẩm");
            System.out.println("3. Nhập tên sản phẩm muốn sửa");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Hiển thị tổng doanh thu ");
            System.out.println("6. Hiển thị thông tin người dùng");
            System.out.println("7. Xóa tài khoản người dùng");
            System.out.println("8. Quay về màn hình đăng nhặp");
            int choice = 0;
            while (choice < 1 || choice > 7) {
                try {
                    choice = Integer.parseInt(sc.nextLine());
                    if (choice < 1 || choice > 8) {
                        System.out.println("Chọn từ 1-8 thôi đại ca ơiiii :'(");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Nhập số đi mà đại ca @@");
                }
                switch (choice) {
                    case 1:
                        manageProducts.addProduct();
                        break;
                    case 2:
                        manageProducts.showProduct();
                        break;
                    case 3:
                        manageProducts.editProduct();
                        break;
                    case 4:
                        manageProducts.removeProduct();
                        break;
                    case 5:
                        DoanhThu();
                        break;
                    case 6:
                        showAccount();
                        break;
                    case 7:
                        removeAccount();
                        break;
                    case 8:
                        MenuDangNhap.menuDangNhap.ManHinhDangNhap();
                        break;
                }
            }
        }
    }

    public void menu_User() {
        while (true) {
            System.out.println("1. Hiểm thị danh sách sản phẩm");
            System.out.println("2. Thêm sản phẩm vào giỏ hàng");
            System.out.println("3. Xóa sản phẩm trong giỏ hàng");
            System.out.println("4. Hiển sản phẩm trong giỏ hàng và tổng tiền");
            System.out.println("5. Quay về màn hình đăng nhập");
            int choice = 0;
            while (choice < 1 || choice > 5) {
                try {
                    choice = Integer.parseInt(sc.nextLine());
                    if (choice < 1 || choice > 5) {
                        System.out.println("Chọn từ 1- 5 thôi");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Nhập số thôi");
                }
            }

            switch (choice) {
                case 1:
                    manageProducts.showProduct();
                    break;
                case 2:
                    manageProducts.showProduct();
                    buyProduct();
                    break;
                case 3:
                    removeProduct();
                    break;
                case 4:
                    showGioHang();
                    break;
                case 5:
                    MenuDangNhap.menuDangNhap.ManHinhDangNhap();
            }

        }

    }


    public void register() {
        System.out.println("Nhập họ và tên: ");
        String name = sc.nextLine();

        System.out.println("Nhập tuổi: ");
        int age;
        while (true) {
            try {
                age = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Nhập số má ơi :(((");
            }
        }

        String username = null;
        while (username == null) {
            try {
                System.out.println("Nhập username: ");
                username = sc.nextLine();
                username = valiDate.DinhDang_DangKyTK(username);
                if (checkUsername(username)) {
                    System.out.println("username đã tồn tại");
                    username = null;
                }
            }catch (Exception e){
                System.out.println("");
            }

        }
        String password = null;
        while (password == null) {
            System.out.println("Nhập password: ");
            password = sc.nextLine();
            password = valiDate.DinhDang_DangKyMK(password);
        }
        System.out.println("Đăng ký thành công");
        gioHang = new ArrayList<>();
        users.add(new User(name, age, username, password, gioHang));
        write_read.write(file, users);
    }

    public boolean checkUsername(String username) {

        for (User user : users) {
            if (user.getUsername().equals(username) || username.equals("Admin")) {
                return true;
            }
        }
        return false;
    }

    public void buyProduct() {
        System.out.println("Nhập tên sản phẩm muốn thêm vào giỏ hàng: ");
        String name = sc.nextLine();

        for (int i = 0; i < manageProducts.products.size(); i++) {
            if (manageProducts.getProducts().get(i).getName().equals(name)) {
                gioHang.add(manageProducts.getProducts().get(i));
                System.out.println("Thêm sản phẩm thành công");
            } else {
                System.out.println("Sản phẩm không tồn tại!");
            }
        }

        write_read.write(file, users);
        write_read2.write(file2, gioHang);
    }

    public void removeProduct() {
        System.out.println("Nhập tên sản phẩm muốn xóa khỏi giỏ hàng: ");
        String name = sc.nextLine();

        for (int i = 0; i < manageProducts.products.size(); i++) {
            if (manageProducts.products.get(i).getName().equals(name)) {
                gioHang.remove(i);
                System.out.println("Xóa sản phẩm thành công");
            } else {
                System.out.println("Sản phẩm không tồn tại!");
            }
        }
        write_read.write(file, users);
        write_read2.write(file2, gioHang);
    }

    public void showGioHang() {
        for (int i = 0; i < gioHang.size(); i++) {
            System.out.println(gioHang.get(i));
        }
        System.out.println("Tổng tiền giỏ hàng: " + tongTien());
        ThanhToan_xxx();
        gioHang = new ArrayList<>();
    }


    public double tongTien() {
        double tongTien = 0.0;

        for (int i = 0; i < gioHang.size(); i++) {
            tongTien += gioHang.get(i).getPrice();
        }
        return tongTien;


    }

    public void ThanhToan_xxx() {
        System.out.println("Bạn muốn mua ko");
        System.out.println("y/n");
        String x = sc.nextLine();
        if (x.equalsIgnoreCase("y")) {
            System.out.println("Đã thanh toán");
        }
    }

    public void DoanhThu() {
        double doanhthu = 0;
        for (int i = 0; i < users.size(); i++) {
            doanhthu += tongTien();
        }
        System.out.println("Doanh thu của bạn là: " + doanhthu);
    }

    public void showAccount() {
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));
        }
    }

    public void removeAccount() {
        System.out.println("Nhập tên tài khoản muốn xóa khỏi hệ thống");
        String name = sc.nextLine();
        int choice = 0;

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(name)) {
                users.remove(i);
                ++choice;

            }
        }
        if (choice != 0) {
            System.out.println("Xóa tài khoản thành công");
        } else {
            System.out.println("Tên tài khoản không tồn tại");
        }
        write_read.write(file, users);
    }

}
