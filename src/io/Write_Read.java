package io;

import java.io.*;
import java.util.ArrayList;

public class Write_Read<E> {
    public void write(File file, ArrayList<E> list){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<E> read(File file){
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            return (ArrayList<E>) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
