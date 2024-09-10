package dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Customer {
    private String id;
    private String pw;
    private String name;
    private final LocalDateTime signUpTime;
    public Customer() {
        this.signUpTime = LocalDateTime.now();
    }
    public Customer(String id, String pw, String name) {
        this();
        this.id = id;
        this.pw = pw;
        this.name = name;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getSignUpTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return signUpTime.format(formatter);
    }
    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", name='" + name + '\'' +
                ", signUpTime=" + getSignUpTime() +
                '}';
    }
}
