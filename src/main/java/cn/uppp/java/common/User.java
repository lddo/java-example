package cn.uppp.java.common;

import lombok.Data;
import org.springframework.stereotype.Controller;

@Data
@Controller
public class User {
    private Integer id;
    private String name;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
