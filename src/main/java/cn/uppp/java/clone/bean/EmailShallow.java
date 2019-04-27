package cn.uppp.java.clone.bean;

import lombok.Data;

@Data
public class EmailShallow {
    private String content;

    public EmailShallow(String content) {
        this.content = content;
    }
}
