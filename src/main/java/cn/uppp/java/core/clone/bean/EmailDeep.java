package cn.uppp.java.core.clone.bean;

import lombok.Data;

@Data
public class EmailDeep implements Cloneable {
    private String content;

    public EmailDeep(String content) {
        this.content = content;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
