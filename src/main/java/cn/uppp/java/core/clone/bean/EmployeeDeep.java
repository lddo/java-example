package cn.uppp.java.core.clone.bean;

import lombok.Data;

@Data
public class EmployeeDeep implements Cloneable {
    private String name;
    private EmailDeep emailDeep;

    public EmployeeDeep(String name, EmailDeep emailDeep) {
        this.name = name;
        this.emailDeep = emailDeep;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        EmployeeDeep employeeDeep = (EmployeeDeep) super.clone();
        employeeDeep.setEmailDeep((EmailDeep) emailDeep.clone());
        return employeeDeep;
    }
}
