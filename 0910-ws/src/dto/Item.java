package dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Item {
    private int id;
    private String name;
    private int price;
    private final LocalDateTime registrationTime;
    private String imgName;

    public Item() {
        this.registrationTime = LocalDateTime.now();
    }

    public Item(int id, String name, int price, String imgName) {
        this();
        this.id = id;
        this.name = name;
        this.price = price;
        this.imgName = imgName;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getRegistrationTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return registrationTime.format(formatter);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", registrationTime=" + getRegistrationTime() +
                ", imgName=" + imgName +
                '}';
    }
}

