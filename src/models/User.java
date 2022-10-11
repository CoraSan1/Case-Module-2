package models;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private String name;
    private int age;



    private String username;
    private String password;
    private ArrayList<Products> gioHang;


    public User() {
    }


    public User(String name, int age, String username, String password, ArrayList<Products> gioHang) {
        this.name = name;
        this.age = age;
        this.username = username;
        this.password = password;
        this.gioHang = gioHang;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Products> getGioHang() {
        return gioHang;
    }

    public void setGioHang(ArrayList<Products> gioHang) {
        this.gioHang = gioHang;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gioHang=" + gioHang +
                '}';
    }
}
