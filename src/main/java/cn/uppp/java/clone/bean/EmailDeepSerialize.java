package cn.uppp.java.clone.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * 被引用对象需实现Serializable接口
 */
@Data
public class EmailDeepSerialize implements Serializable {
    private static final long serialVersionUID = 7053666545231971902L;

    private String content;

    public EmailDeepSerialize(String content) {
        this.content = content;
    }
}
