package com.arun.designpattern.decoratorpattern;

import java.io.*;

/**
 * @author arun on 9/24/20
 */

public class DecoratorEveryDayDemo {

    public static void main(String[] args) throws IOException {
        File file = new File("./output.txt");
        boolean newFile = file.createNewFile();

        if (newFile) {

            OutputStream outputStream = new FileOutputStream(file);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeChars("text");

            dataOutputStream.close();
            outputStream.close();
        }
    }
}
