package com.qipeng.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * NIO-Channel
 *
 * @author Alatai
 * @version 1.0
 * @date 2022/01/26 14:44
 */
public class TestChannel {

    public static void main(String[] args) {
        try (RandomAccessFile file = new RandomAccessFile("nio.txt", "rw"); FileChannel channel = file.getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(48);
            // 把数据写入buffer
            int read = channel.read(buffer);

            while (read != -1) {
                System.out.println("read " + read);
                // 调用flip()
                // 把buffer从写模式调整为读模式
                buffer.flip();

                while (buffer.hasRemaining()) {
                    // 从Buffer中读取数据
                    System.out.print((char) buffer.get());
                }

                // 调用buffer.clear()或者buffer.compact()
                // clear: 清空整个buffer
                // compact: 只清空已读数据
                buffer.clear();
                read = channel.read(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
