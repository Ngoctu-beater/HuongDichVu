/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import entity.Admin;
import entity.Car;
import entity.Company;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface DAO {
    Admin login(String account, String password);
    List<Car> getAllCar();
    int getTotalCar();
    List<Car> pagingCar(int index);
    int getNewCar();
    int getUsedCar();
    List<Car> searchByName(String txtSearch);
    void deleteCar(String cid);
    boolean addCar(String title, String pricetitle, int price, int year, String status, String hasgone, String origin, String style, String gearbox, String engine, String exterior, String interior, String seats, String doors, String drive, String describe, String link);
    Car getCarById(String cid);
    void editCar(String title, String pricetitle, int price, int year, String status, String hasgone, String origin, String style, String gearbox, String engine, String exterior, String interior, String seats, String doors, String drive, String describe, String link, int id);
    int getTotalCompany();
    long getTotalPrice();
    List<Company> getByName();
    List<Object[]> numberByCompany();
}
