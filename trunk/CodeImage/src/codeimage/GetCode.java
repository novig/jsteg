package codeimage;

import java.io.*;

public class GetCode {
      FileInputStream image;
         byte rgb[];

    GetCode(String filename) throws IOException {
        image = null;
        image = new FileInputStream(filename);
        int infhead = 54;
        byte buf[] = new byte[infhead];
        image.read(buf, 0, infhead);
        int size = image.available();
        if (size > 0) {
            rgb = new byte[size];
            image.read(rgb, 0, size);
        }
    }

    public int[] readCodeFromImage(int size,int value) throws IOException {
        if (value > 8)
            return null;
        int code[] = new int[size];
        byte nil = (byte) ((Math.pow(2, value)) - 1);
        int points = (int) Math.ceil(32 / value) + 1;

        for (int i = 0; i < code.length; i++) {
            int info = 0;
            int bytes = value;
            for (int j = 0; j < points; j++) {
                int current = (rgb[i * points + j] & 0xFF);
                current = (current &  nil); // обнуляем всё кроме val битов
                info = info | (current << (bytes - value));
                bytes += value;
            }
            code[i] = info;
        }
     return code;
    }

}
