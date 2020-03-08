package com.zhoujian.iodemo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Main {
    public static void main(String[] args) {
        io1();
    }

    private static void io1() {
        try (OutputStream outputStream = new FileOutputStream("./iodemo/text.txt")) {
            outputStream.write('a');
            outputStream.write('b');
            outputStream.write('b');
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
