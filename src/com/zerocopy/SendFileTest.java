package com.zerocopy;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 零拷贝测试
 *
 * @author chenh
 * @version 1.0
 * @date 2023/1/4 18:39
 **/
public class SendFileTest {


    public static void main(String[] args) {

        sendFile();

    }

    private static void sendFile() {
        try {
            FileChannel readChannel = FileChannel.open(Paths.get("C:\\var\\zerocopy.txt"), StandardOpenOption.READ);
            long len = readChannel.size();
            long position = readChannel.position();
            FileChannel writeChannel = FileChannel.open(Paths.get("C:\\var\\zerocopy_bak.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
            readChannel.transferTo(position, len, writeChannel);
            readChannel.close();
            writeChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
