package cn.uppp.java.core.pattern.delegate;

public class DelegateDemo {
    public static void main(String[] args) {
        Teacher tomTeacher = new TomTeacher();
        tomTeacher.collect(new JamesClassLeader());
    }
}
