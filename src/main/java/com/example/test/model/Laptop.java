package com.example.test.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "laptop")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createAt", "updateAt"}, allowGetters = true)
public class Laptop implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="laptop_name")
    private String laptopName;

    @Column(name="brand")
    private String brand;

    @Column(name="model")
    private String model;

    @Column(name="color")
    private String color;

    @Column(name="processor")
    private String processor;

    @Column(name="clock_speed")
    private Long clockSpeed;

    @Column(name="vga")
    private String vga;

    @Column(name="ram_capacity")
    private Integer ramCapacity;

    @Column(name="hdd_capacity")
    private Integer hddCapacity;

    @Column(name="price")
    private Integer price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLaptopName() {
        return laptopName;
    }

    public void setLaptopName(String laptopName) {
        this.laptopName = laptopName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public Long getClockSpeed() {
        return clockSpeed;
    }

    public void setClockSpeed(Long clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    public String getVga() {
        return vga;
    }

    public void setVga(String vga) {
        this.vga = vga;
    }

    public Integer getRamCapacity() {
        return ramCapacity;
    }

    public void setRamCapacity(Integer ramCapacity) {
        this.ramCapacity = ramCapacity;
    }

    public Integer getHddCapacity() {
        return hddCapacity;
    }

    public void setHddCapacity(Integer hddCapacity) {
        this.hddCapacity = hddCapacity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", laptopName='" + laptopName + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", processor='" + processor + '\'' +
                ", clockSpeed=" + clockSpeed +
                ", vga='" + vga + '\'' +
                ", ramCapacity=" + ramCapacity +
                ", hddCapacity=" + hddCapacity +
                ", price=" + price +
                '}';
    }
}
