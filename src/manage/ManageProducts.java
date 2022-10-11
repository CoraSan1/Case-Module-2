package manage;

import io.Write_Read;
import models.Products;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ManageProducts {
    File file = new File("F:\\Java\\Case Module 2\\src\\fileText\\product.txt");

    Write_Read<Products> write_read = new Write_Read<>();
    ArrayList<Products> products = write_read.read(file);

    Scanner sc = new Scanner(System.in);

    public ArrayList<Products> getProducts() {
        return products;
    }

    public Products createProduct() {
        System.out.println("Nhập mã sản phẩm: ");
        int id;
        while (true) {

            try {
                id = Integer.parseInt(sc.nextLine());
                if (checkID(id)){
                    break;
                }else {
                    System.out.println("ID đã tồn tại");

                }

            } catch (NumberFormatException e) {
                System.out.println("Nhập mã sản phẩm là số");
            }
        }

        System.out.println("Nhập tên sản phẩm: ");
        String name = sc.nextLine();

        System.out.println("Nhập giá sản phẩm: ");
        double price;
        while (true) {
            try {
                price = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Giá tiền là số má ơi");
            }
        }

        System.out.println("Mô tả sản phẩm: ");
        String discrible = sc.nextLine();

        System.out.println("Nhập xuất xứ sản phẩm: ");
        String madeBy = sc.nextLine();

        Products product = new Products(id, name, price, discrible, madeBy);
        return product;
    }

    public void addProduct() {

        products.add(createProduct());
        write_read.write(file, products);

    }

    public void editProduct() {
        System.out.println("Nhập mã sản phẩm muốn sửa");
        int id;
        while (true) {
            try {
                id = Integer.parseInt(sc.nextLine());
                System.out.println("");
                break;
            } catch (NumberFormatException e) {
                System.out.println("Nhập số thôi mà :(((");
            }
        }
        int index = -1;

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Sản phẩm không tồn tại");
        } else {
            products.set(index, createProduct());
        }
        System.out.println("Sửa sản phẩm thành công");
        write_read.write(file, products);

    }

    public void removeProduct() {
        System.out.println("Nhập mã sản phẩm muốn xóa");
        int id;
        while (true) {
            try {
                id = Integer.parseInt(sc.nextLine());
                System.out.println("");
                break;
            } catch (NumberFormatException e) {
                System.out.println("Mã sản phẩm là số thôi, đcm!");
            }
        }
        int index = -1;

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Sản phẩm không tồn tại");
        } else {
            products.remove(products.get(index));
        }
        System.out.println("Xóa  sản phẩm thành công");
        write_read.write(file, products);
    }

    public void showProduct() {
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i));
        }
    }

    public boolean checkID(int id) {

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                return false;
            }
        }
        return true;
    }


}
