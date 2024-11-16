/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import entity.Admin;
import entity.Car;
import entity.Company;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DAOImpl implements DAO {

    // hiển thị dữ liệu xe trong DB
    @Override
    public List<Car> getAllCar() {
        Connection conn = null;
        List<Car> list = new ArrayList<>();

        try {
            conn = DBContext.getConnection();
            String query = "SELECT * FROM Car";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Car car = new Car();
                car.setId(rs.getInt("id"));
                car.setTitle(rs.getNString("title"));
                car.setPricetitle(rs.getString("pricetitle"));
                car.setYear(rs.getInt("year"));
                car.setStatus(rs.getString("status"));
                car.setOrigin(rs.getString("origin"));
                car.setExterior(rs.getString("exterior"));
                car.setInterior(rs.getString("interior"));
                list.add(car);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.closeConnection(conn);
        }
        return list;
    }

    // tổng tất cả xe
    @Override
    public int getTotalCar() {
        Connection conn = null;

        try {
            conn = DBContext.getConnection();
            String query = "SELECT COUNT (*) FROM Car";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.closeConnection(conn);
        }
        return 0;
    }

    // số bản ghi trên mỗi trang
    @Override
    public List<Car> pagingCar(int index) {
        Connection conn = null;
        List<Car> list = new ArrayList<>();
        try {
            conn = DBContext.getConnection();
            String query = "SELECT * FROM Car\n"
                    + "ORDER BY id\n"
                    + "OFFSET ? ROWS FETCH NEXT 20 ROW ONLY";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, (index - 1) * 20);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Car car = new Car();
                car.setId(rs.getInt("id"));
                car.setTitle(rs.getNString("title"));
                car.setPricetitle(rs.getString("pricetitle"));
                car.setYear(rs.getInt("year"));
                car.setStatus(rs.getString("status"));
                car.setOrigin(rs.getString("origin"));
                car.setExterior(rs.getString("exterior"));
                car.setInterior(rs.getString("interior"));
                list.add(car);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.closeConnection(conn);
        }
        return list;
    }

    // thống kê xe mới
    @Override
    public int getNewCar() {
        Connection conn = null;

        try {
            conn = DBContext.getConnection();
            String query = "SELECT COUNT(*) FROM Car\n"
                    + "WHERE [status] LIKE N'%mới%'";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.closeConnection(conn);
        }
        return 0;
    }

    
    // thống kê xe đã dùng
    @Override
    public int getUsedCar() {
        Connection conn = null;

        try {
            conn = DBContext.getConnection();
            String query = "SELECT COUNT(*) FROM Car\n"
                    + "WHERE [status] LIKE N'%đã dùng%'";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.closeConnection(conn);
        }
        return 0;
    }

    // kiểm tra login
    @Override
    public Admin login(String account, String password) {
        Connection conn = null;

        try {
            conn = DBContext.getConnection();
            String query = "SELECT * FROM [Admin]\n"
                    + "WHERE account = ?\n"
                    + "and [password] = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, account);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Admin(rs.getString(1),
                        rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.closeConnection(conn);
        }
        return null;
    }

    // tìm kiếm
    @Override
    public List<Car> searchByName(String txtSearch) {
        Connection conn = null;
        List<Car> list = new ArrayList<>();
        try {
            conn = DBContext.getConnection();
            String query = "SELECT * FROM Car\n"
                    + "WHERE title LIKE ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Car car = new Car();
                car.setId(rs.getInt("id"));
                car.setTitle(rs.getNString("title"));
                car.setPricetitle(rs.getString("pricetitle"));
                car.setYear(rs.getInt("year"));
                car.setStatus(rs.getString("status"));
                car.setOrigin(rs.getString("origin"));
                car.setExterior(rs.getString("exterior"));
                car.setInterior(rs.getString("interior"));
                list.add(car);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.closeConnection(conn);
        }
        return list;
    }

    // xóa
    @Override
    public void deleteCar(String cid) {
        Connection conn = null;

        try {
            conn = DBContext.getConnection();
            String query = "DELETE FROM Car\n"
                    + "WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.closeConnection(conn);
        }
    }

    // thêm
    @Override
    public boolean addCar(String title, String pricetitle, int price, int year, String status, String hasgone, String origin, String style, String gearbox, String engine, String exterior, String interior, String seats, String doors, String drive, String describe, String link) {
        Connection conn = null;

        try {
            conn = DBContext.getConnection();
            String query = "INSERT INTO Car\n"
                    + "(title, pricetitle, price, year, status, hasgone, origin, style, gearbox, engine, exterior, interior, seats, doors, drive, describe, link)\n"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, title);
            ps.setString(2, pricetitle);
            ps.setInt(3, price);
            ps.setInt(4, year);
            ps.setString(5, status);
            ps.setString(6, hasgone);
            ps.setString(7, origin);
            ps.setString(8, style);
            ps.setString(9, gearbox);
            ps.setString(10, engine);
            ps.setString(11, exterior);
            ps.setString(12, interior);
            ps.setString(13, seats);
            ps.setString(14, doors);
            ps.setString(15, drive);
            ps.setString(16, describe);
            ps.setString(17, link);
            
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.closeConnection(conn);
        }
        return false;
    }

    @Override
    public Car getCarById(String cid) {
        Connection conn = null;

        try {
            conn = DBContext.getConnection();
            String query = "SELECT * FROM Car\n"
                    + "WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Car(rs.getInt("id"),
                        rs.getNString("title"),
                        rs.getString("pricetitle"),
                        rs.getInt("price"),
                        rs.getInt("year"),
                        rs.getString("status"),
                        rs.getString("hasgone"),
                        rs.getString("origin"),
                        rs.getString("style"),
                        rs.getString("gearbox"),
                        rs.getString("engine"),
                        rs.getString("exterior"),
                        rs.getString("interior"),
                        rs.getString("seats"),
                        rs.getString("doors"),
                        rs.getString("drive"),
                        rs.getString("describe"),
                        rs.getString("link"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.closeConnection(conn);
        }
        return null;
    }

    // chỉnh sửa
    @Override
    public void editCar(String title, String pricetitle, int price, int year, String status, String hasgone, String origin, String style, String gearbox, String engine, String exterior, String interior, String seats, String doors, String drive, String describe, String link, int id) {
        Connection conn = null;

        try {
            conn = DBContext.getConnection();
            String query = "UPDATE Car SET title = ?, pricetitle = ?, price = ?, year = ?, status = ?, "
                    + "hasgone = ?, origin = ?, style = ?, gearbox = ?, engine = ?, exterior = ?, "
                    + "interior = ?, seats = ?, doors = ?, drive = ?, describe = ?, link = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, title);
            ps.setString(2, pricetitle);
            ps.setInt(3, price);
            ps.setInt(4, year);
            ps.setString(5, status);
            ps.setString(6, hasgone);
            ps.setString(7, origin);
            ps.setString(8, style);
            ps.setString(9, gearbox);
            ps.setString(10, engine);
            ps.setString(11, exterior);
            ps.setString(12, interior);
            ps.setString(13, seats);
            ps.setString(14, doors);
            ps.setString(15, drive);
            ps.setString(16, describe);
            ps.setString(17, link);
            ps.setInt(18, id);
            ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.closeConnection(conn);
        }
    }

    // tổng hãng xe
    @Override
    public int getTotalCompany() {
        Connection conn = null;

        try {
            conn = DBContext.getConnection();
            String query = "SELECT COUNT (*) FROM Company";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.closeConnection(conn);
        }
        return 0;
    }

    // thống kê vốn đầu tư
    @Override
    public long getTotalPrice() {
        Connection conn = null;
        long totalPrice = 0;
        try {
            conn = DBContext.getConnection();
            String query = "SELECT SUM(price)\n"
                    + "FROM Car";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                totalPrice = rs.getLong(1);;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.closeConnection(conn);
        }
        return totalPrice;
    }

    @Override
    public List<Company> getByName() {
        Connection conn = null;
        List<Company> list = new ArrayList<>();
        try {
            conn = DBContext.getConnection();
            String query = "SELECT [name] FROM Company";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Company company = new Company();
                company.setName(rs.getString("name"));
                list.add(company);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.closeConnection(conn);
        }
        return list;
    }

    // dữ liệu vẽ biểu đồ
    @Override
    public List<Object[]> numberByCompany() {
        Connection conn = null;
        List<Object[]> list = new ArrayList<>();
        try {
            conn = DBContext.getConnection();
            String query = "SELECT \n"
                    + "    LEFT(title, CHARINDEX(' ', title + ' ') - 1),\n"
                    + "    COUNT (*)\n"
                    + "FROM Car\n"
                    + "GROUP BY LEFT(title, CHARINDEX(' ', title + ' ') - 1);";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Object[]{rs.getString(1), rs.getInt(2)});
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.closeConnection(conn);
        }
        return list;
    }
}
