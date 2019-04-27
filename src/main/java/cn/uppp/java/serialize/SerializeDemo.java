package cn.uppp.java.serialize;

import cn.uppp.java.serialize.bean.Person;

import java.io.*;

/**
 * 序列化
 */
public class SerializeDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        testSerializeToFile();
    }

    /**
     * 序列化到文件
     */
    public static void testSerializeToFile() throws IOException, ClassNotFoundException {
        Person person = new Person(1, "tom");
        // 序列化
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(person);
        // 写入文件
        File file = new File("D:/Person.class");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(baos.toByteArray());

        // 读取文件
        FileInputStream fis = new FileInputStream(file);
        byte[] fileByte = new byte[(int) file.length()];
        fis.read(fileByte);
        //反序列化
        ByteArrayInputStream bais = new ByteArrayInputStream(fileByte);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Person person1 = (Person) ois.readObject();
        System.out.println(person1.toString());
    }
}
