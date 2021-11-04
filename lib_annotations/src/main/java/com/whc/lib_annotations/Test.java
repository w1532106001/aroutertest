package com.whc.lib_annotations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Test {
    public static void main(String[] args) {

        User2 user2 = new User2("wjdkfaksssssssssss",12321343);
        try {
            File file = new File("C:\\Users\\whc\\AndroidStudioProjects\\MyApplication3\\lib_annotations\\src\\main\\java\\com\\whc\\lib_annotations\\a.txt");
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
            if(user2.getClass() instanceof Serializable){
                outputStream.writeObject(user2);
                outputStream.close();
                System.out.println("序列化成功");
            }

            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            User2 user21 = (User2) objectInputStream.readObject();
            objectInputStream.close();
            System.out.println("反序列化成功 user:"+user21);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
