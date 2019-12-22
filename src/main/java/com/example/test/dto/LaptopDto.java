package com.example.test.dto;

public class LaptopDto {
    private Long id;
    private String laptopName;
    private String brand;
    private String model;
    private String color;
    private String processor;
    private Long clockSpeed;
    private String vga;
    private Integer ramCapacity;
    private Integer hddCapacity;
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
}
