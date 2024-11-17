/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package craw_data_jsoup.craw_data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Admin
 */
public class Craw_data {

    @SuppressWarnings("SleepWhileInLoop")
    public static void main(String[] args) throws IOException, InterruptedException {
        // link web
        String baseURL = "https://bonbanh.com/oto-xe-moi,";

        // Số trang muốn crawl
        int totalPages = 367;

        // thông tin kết nối SQL server
        String urlDB = "jdbc:sqlserver://LAPTOP-HSS8HFAH;databaseName=CarShop;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String password = "291004";

        // Truy vấn SQL để chèn dữ liệu vào bảng
        String sqlInsert = "INSERT INTO Car\n"
                + "(title, pricetitle, price, year, status, hasgone, origin, style, gearbox, engine, exterior, interior, seats, doors, drive, describe, link)\n"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // Truy vấn SQL để kiểm tra trùng lặp theo link
        String sqlCheckExist = "SELECT COUNT(*) FROM Car WHERE CAST(link AS NVARCHAR(MAX)) = ?";

        Connection connection = null;
        PreparedStatement statement = null;
        PreparedStatement checkStatement = null;

        try {
            // kết nối SQL server
            connection = DriverManager.getConnection(urlDB, user, password);

            for (int i = 1; i <= totalPages; i++) {
                // link trang hiện tại
                String url = baseURL + i;

                // lấy data từ web
                Document doc = Jsoup.connect(url).get();

                // lấy data theo class
                // đi từ cha đến con
                Elements elements = doc.select("div#s-list-car li.car-item");

                // chuẩn bị truy vấn để kiểm tra trùng lặp
                checkStatement = connection.prepareStatement(sqlCheckExist);

                // lưu dữ liệu vào SQL
                statement = connection.prepareStatement(sqlInsert);

                // lấy tiêu đề và giá
                for (Element e : elements) {
                    String tieuDe = e.select("div.cb2_02 h3").text();
                    String deGia = e.select("div.cb3 b").text();
                    String gia = e.select("div.cb3 b").attr("content");
                    String link = e.select("a").attr("href");

                    // Kiểm tra xem dữ liệu với link này đã tồn tại chưa
                    checkStatement.setString(1, link);
                    ResultSet rs = checkStatement.executeQuery();
                    rs.next();
                    int count = rs.getInt(1);

                    // nếu chưa tồn tại
                    if (count == 0) {
                        // Tải và phân tích trang chi tiết xe
                        Document chiTiet = Jsoup.connect("https://bonbanh.com/" + link).get();

                        // trích xuất thêm thông tin từ trang chi tiết
                        Elements thongSo = chiTiet.select("div.col div#mail_parent");
                        Elements moTa = chiTiet.select("div.box_car_detail.box_car_des div.car_des");

                        String namSX = thongSo.get(0).select("span[class=inp]").text();
                        String tinhTrang = thongSo.get(1).select("span[class=inp]").text();
                        //String daDi = thongSo.get(2).select("span[class=inp]").text();
                        String xuatXu = thongSo.get(2).select("span[class=inp]").text();
                        String kieuDang = thongSo.get(3).select("span[class=inp]").text();
                        String hopSo = thongSo.get(4).select("span[class=inp]").text();
                        String dongCo = thongSo.get(5).select("span[class=inp]").text();
                        String ngoaiThat = thongSo.get(6).select("span[class=inp]").text();
                        String noiThat = thongSo.get(7).select("span[class=inp]").text();
                        String choNgoi = thongSo.get(8).select("span[class=inp]").text();
                        String soCua = thongSo.get(9).select("span[class=inp]").text();
                        String danDong = thongSo.get(10).select("span[class=inp]").text();
                        String noiDung = moTa.select("div.des_txt").text();

                        // set giá trị cho câu truy vấn
                        statement.setString(1, tieuDe);
                        statement.setString(2, deGia);
                        statement.setString(3, gia);
                        statement.setString(4, namSX);
                        statement.setString(5, tinhTrang);
                        //statement.setString(6, daDi);
                        statement.setNull(6, java.sql.Types.NVARCHAR);
                        statement.setString(7, xuatXu);
                        statement.setString(8, kieuDang);
                        statement.setString(9, hopSo);
                        statement.setString(10, dongCo);
                        statement.setString(11, ngoaiThat);
                        statement.setString(12, noiThat);
                        statement.setString(13, choNgoi);
                        statement.setString(14, soCua);
                        statement.setString(15, danDong);
                        statement.setString(16, noiDung);
                        statement.setString(17, link);

                        // chèn data
                        statement.executeUpdate();
                    } else {
                        System.out.println("Dữ liệu đã tồn tại, bỏ qua link: " + link);
                    }
                }

                // Thêm thời gian chờ giữa các yêu cầu (1-5 giây)
                Thread.sleep((long) (Math.random() * 5000 + 1000));

                // Kiểm tra link "Next", nếu không có thì dừng
                Element nextLink = doc.select(".navpage .bbl").first();
                if (nextLink == null) {
                    break;  // Nếu không có link "Next", dừng lặp
                }
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
