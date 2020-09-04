package javalearning.nio;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author: Jeremy
 * @Date: 2019/7/10 12:56
 */
public class FileTest {
    public static String FILE_PATH = "/Users/Jeremy/Desktop/Program/Interview/src/main/resources/file.txt";
    public RandomAccessFile raf;

    public FileTest(){
        try {
            raf = new RandomAccessFile(FILE_PATH, "rw");
        } catch (FileNotFoundException e){
            System.out.println(e);
        }
    }

    public void write() throws Exception{
        if (raf == null){
            return;
        }
        // 获取文件管道
        FileChannel rafChannel = raf.getChannel();
        // 准备数据
        String data = "新数据，时间： " + System.currentTimeMillis();
        System.out.println("原数据：\n" + "   " + data);
        ByteBuffer buffer = ByteBuffer.allocate(128);
        buffer.clear();
        buffer.put(data.getBytes());
        buffer.flip();

        // 写入数据
        rafChannel.write(buffer);

        rafChannel.close();
        raf.close();
    }

    public void read() throws Exception{
        if (raf == null){
            return;
        }
        // 重新打开管道
        FileChannel rafChannel = raf.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(128);
        // 读取刚刚写入的数据
        buffer.clear();
        rafChannel.read(buffer);

        // 打印读取出的数据
        buffer.flip();
        byte[] bytes = new byte[buffer.limit()];
        buffer.get(bytes);
        System.out.println("读取到的数据：\n" + "   " + new String(bytes));

        rafChannel.close();
        raf.close();
    }
    public static void main(String[] args) throws Exception {
        FileTest fileTest = new FileTest();
        fileTest.write();
        fileTest.read();
    }
}
