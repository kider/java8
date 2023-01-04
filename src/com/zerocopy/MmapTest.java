package com.zerocopy;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 零拷贝测试
 *
 * @author chenh
 * @version 1.0
 * @date 2023/1/4 18:00
 **/
public class MmapTest {

    public static void main(String[] args) {
        //mmp1();
        //mmp2();
        mmp3();
    }

    private static void mmp1() {
        File file = new File("C:\\var\\zerocopy.txt");
        long len = file.length();
        byte[] ds = new byte[(int) len];
        try {
            MappedByteBuffer mappedByteBuffer = new RandomAccessFile(file, "r")
                    .getChannel()
                    .map(FileChannel.MapMode.READ_ONLY, 0, len);
            for (int offset = 0; offset < len; offset++) {
                byte b = mappedByteBuffer.get();
                ds[offset] = b;
            }

            String result = new String(ds, "UTF-8");
            System.out.printf("mmp1-> %s", result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void mmp2() {
        try {
            FileChannel readChannel = FileChannel.open(Paths.get("C:\\var\\zerocopy.txt"), StandardOpenOption.READ);
            long len = readChannel.size();
            byte[] ds = new byte[(int) len];
            MappedByteBuffer mappedByteBuffer = readChannel.map(FileChannel.MapMode.READ_ONLY, 0, len);
            for (int offset = 0; offset < len; offset++) {
                byte b = mappedByteBuffer.get();
                ds[offset] = b;
            }
            String result = new String(ds, "UTF-8");
            System.out.printf("mmp2-> %s", result);
            readChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void mmp3() {
        try {
            FileChannel readChannel = FileChannel.open(Paths.get("C:\\var\\zerocopy.txt"), StandardOpenOption.READ);
            long len = readChannel.size();
            MappedByteBuffer data = readChannel.map(FileChannel.MapMode.READ_ONLY, 0, len);
            FileChannel writeChannel = FileChannel.open(Paths.get("C:\\var\\zerocopy_bak.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
            writeChannel.write(data);
            readChannel.close();
            writeChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}