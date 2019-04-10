package cn.uppp.java.core.pattern.delegate;

import java.util.HashMap;
import java.util.Map;

public class JamesClassLeader implements ClassLeader {

    private static Map<String, Student> studentMap = new HashMap<>();

    static {
        studentMap.put("James", new JamesClassLeader());
        studentMap.put("Mic", new MicStudent());
        studentMap.put("Jack", new JackStudent());
    }

    @Override
    public void collectHomework() {
        System.out.println("班长James收集作业");
        studentMap.forEach((key, value) -> value.handHomework());
    }

    @Override
    public void handHomework() {
        System.out.println("学生James交作业");
    }

}
