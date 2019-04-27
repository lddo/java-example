package cn.uppp.java.clone.bean;

import lombok.Data;

import java.io.*;

@Data
public class EmployeeDeepSerialize implements Serializable {
    private static final long serialVersionUID = 5510730466067394804L;

    private String name;
    private EmailDeepSerialize emailDeepSerialize;

    public EmployeeDeepSerialize(String name, EmailDeepSerialize emailDeepSerialize) {
        this.name = name;
        this.emailDeepSerialize = emailDeepSerialize;
    }

    public EmployeeDeepSerialize deepClone() throws IOException, ClassNotFoundException {
        // 序列化
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(this);
        // 反序列化
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        return (EmployeeDeepSerialize) ois.readObject();
    }
}
