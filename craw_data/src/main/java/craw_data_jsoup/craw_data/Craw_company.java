/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package craw_data_jsoup.craw_data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Admin
 */
public class Craw_company {

    public static void main(String[] args) throws IOException {
        // link web
        String url = "https://oto.com.vn/";

        // thông tin kết nối SQL server
        String urlDB = "jdbc:sqlserver://LAPTOP-HSS8HFAH;databaseName=CarShop;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String password = "291004";

        // Truy vấn SQL để chèn dữ liệu vào bảng
        String sqlInsert = "INSERT INTO Company (name, images) VALUES (?, ?)";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // lấy data từ web
            Document doc = Jsoup.connect(url).get();

            // lấy data theo class
            // đi từ cha đến con
            Elements elements = doc.select("div.list.swiper-wrapper div.item");

            // kết nối SQL server
            connection = DriverManager.getConnection(urlDB, user, password);

            // lưu dữ liệu vào SQL
            statement = connection.prepareStatement(sqlInsert);

            for (Element e : elements) {
                String tenHang = e.select("a[class=name]").text();
                String anh = e.select("a[class=photo] img").attr("data-src");

                statement.setString(1, tenHang);
                statement.setString(2, anh);

                // chèn data
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Lỗi kết nối!");
            e.printStackTrace();
        } finally {
            // Đảm bảo đóng kết nối và PreparedStatement
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
