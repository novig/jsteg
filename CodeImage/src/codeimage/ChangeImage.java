package codeimage;
import java.io.*;

public class ChangeImage {
     FileInputStream image;
     byte rgb[];
     int width;
     int height;
     byte head[];
     byte infohead[];
     int bitcount;
     int pad;

    ChangeImage(String filename) throws IOException {
        image = null;
        image = new FileInputStream(filename);
        head = new byte[14];
        infohead = new byte[40];
        image.read(head, 0, 14);
        image.read(infohead, 0, 40);
        int size = image.available();
        if (size > 0) {
            rgb = new byte[size];
            image.read(rgb, 0, size);
        }
        width = (((int) infohead[7] & 0xff) << 24) | (((int) infohead[6] & 0xff) << 16) | (((int) infohead[5] & 0xff) << 8) | (int) infohead[4] & 0xff;
        height = (((int) infohead[11] & 0xff) << 24) | (((int) infohead[10] & 0xff) << 16) | (((int) infohead[9] & 0xff) << 8) | (int) infohead[8] & 0xff;
        bitcount = (((int)infohead[15]&0xff)<<8) | (int)infohead[14]&0xff;
        int sizeimage = (((int) infohead[23] & 0xff) << 24) | (((int) infohead[22] & 0xff) << 16) | (((int) infohead[21] & 0xff) << 8) | (int) infohead[20] & 0xff;
        pad = (sizeimage / height) - width * 3;
    }

    public void writeCodeToImage(int code[], int value) throws IOException {
        if (bitcount != 24)
            return;
        if (value > 8) 
            return;
        byte nil = (byte) ((Math.pow(2, value)) - 1);
        int points = (int) Math.ceil(32 / value) + 1;

        for (int i = 0; i < code.length; i++) {
            int info = code[i];
            for (int j = 0; j < points; j++) {
                int current = (rgb[i * points + j] & 0xFF);
                current =  (current & (255 - nil)); // зануляем val младших битов
                current =  (current | (info & nil)); // записываем в текущий цвет новую информацию
                info = info >> value;
                rgb[points * i + j] = (byte)current;
            }
        }
    }
}
