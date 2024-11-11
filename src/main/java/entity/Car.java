/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Admin
 */
public class Car {
    private int id;
    private String title;
    private String pricetitle;
    private int price;
    private int year;
    private String status;
    private String hasgone;
    private String origin;
    private String style;
    private String gearbox;
    private String engine;
    private String exterior;
    private String interior;
    private String seats;
    private String doors;
    private String drive;
    private String describe;
    private String link;

    public Car() {
    }

    public Car(int id, String title, String pricetitle, int price, int year, String status, String hasgone, String origin, String style, String gearbox, String engine, String exterior, String interior, String seats, String doors, String drive, String describe, String link) {
        this.id = id;
        this.title = title;
        this.pricetitle = pricetitle;
        this.price = price;
        this.year = year;
        this.status = status;
        this.hasgone = hasgone;
        this.origin = origin;
        this.style = style;
        this.gearbox = gearbox;
        this.engine = engine;
        this.exterior = exterior;
        this.interior = interior;
        this.seats = seats;
        this.doors = doors;
        this.drive = drive;
        this.describe = describe;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPricetitle() {
        return pricetitle;
    }

    public void setPricetitle(String pricetitle) {
        this.pricetitle = pricetitle;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHasgone() {
        return hasgone;
    }

    public void setHasgone(String hasgone) {
        this.hasgone = hasgone;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getExterior() {
        return exterior;
    }

    public void setExterior(String exterior) {
        this.exterior = exterior;
    }

    public String getInterior() {
        return interior;
    }

    public void setInterior(String interior) {
        this.interior = interior;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getDoors() {
        return doors;
    }

    public void setDoors(String doors) {
        this.doors = doors;
    }

    public String getDrive() {
        return drive;
    }

    public void setDrive(String drive) {
        this.drive = drive;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
