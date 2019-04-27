package cn.uppp.java.pattern.delegate;

public class TomTeacher implements Teacher {

    public void collect(ClassLeader classLeader) {
        System.out.println("Tom老师，将收集任务交给班长James");
        classLeader.collectHomework();
    }
}
