package validate;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValiDate {
    static Scanner sc = new Scanner(System.in);

    public String DinhDang_DangKyTK(String str){
        Pattern pattern = Pattern.compile("^[A-Z]+[\\w]{3,}@gmail\\.com");
        Matcher matcher = pattern.matcher(str);

        if (matcher.find()){
            return str.substring(matcher.start(), matcher.end());
        }else {
            System.out.println("Sai định dạng rồi! " + "Ví dụ Dinhdeptrai@gmail.com");
            return null;
        }
    }

    public String DinhDang_DangKyMK(String str){
        Pattern pattern = Pattern.compile("[\\w]{6}");
        Matcher matcher = pattern.matcher(str);

        if (matcher.find()){
            return str.substring(matcher.start(), matcher.end());
        }else {
            System.out.println("Nhập tối thiểu 6 ký tự");
            return null;
        }
    }

}
