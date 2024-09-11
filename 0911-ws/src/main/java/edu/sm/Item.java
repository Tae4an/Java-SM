package edu.sm;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class Item {
    private int id;
    private String name;
    private int price;
    private String imgName;
    private LocalDate registrationDate;
    private LocalDate updateDate;
    private String registrant;

    public Item() {
    }

    public Item(String name, int price, String imgName, String registrant) {
        this.name = name;
        this.price = price;
        this.imgName = imgName;
        this.registrant = registrant;
    }
}