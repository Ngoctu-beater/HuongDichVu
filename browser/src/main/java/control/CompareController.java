/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import entity.product;

/**
 *
 * @author Admin
 */
@WebServlet(name = "CompareController", urlPatterns = {"/comparecar"})
public class CompareController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // Lấy `id` từ request
        String id = request.getParameter("ids");

        if (id == null || id.isEmpty()) {
            request.setAttribute("error", "Không có xe nào được chọn.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }

        // Lấy danh sách `comparisonList` từ session
        HttpSession session = request.getSession();
        List<String> comparisonList = (List<String>) session.getAttribute("comparisonList");
        if (comparisonList == null) {
            comparisonList = new ArrayList<>();
        }

        // Thêm `id` mới vào danh sách nếu chưa tồn tại
        if (!comparisonList.contains(id)) {
            comparisonList.add(id);
        }

        // Cập nhật danh sách `comparisonList` trong session
        session.setAttribute("comparisonList", comparisonList);

        // Gửi yêu cầu tới API để lấy chi tiết xe
        List<product> carDetails = new ArrayList<>();
        try {
            // Xây dựng URL API với các `id` trong danh sách
            String joinedIds = String.join(",", comparisonList);
            String apiUrl = "http://localhost:8080/carshop/api/car?cid=" + joinedIds;

            // Gửi yêu cầu GET tới API
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            // Kiểm tra mã phản hồi
            int status = connection.getResponseCode();
            if (status == 200) {
                // Đọc phản hồi JSON từ API
                StringBuilder jsonResponse = new StringBuilder();
                try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        jsonResponse.append(inputLine);
                    }
                }

                // Chuyển đổi JSON thành danh sách Product
                Gson gson = new Gson();
                Type listType = new TypeToken<List<product>>() {
                }.getType();
                carDetails = gson.fromJson(jsonResponse.toString(), listType);

            } else {
                request.setAttribute("error", "Không thể lấy dữ liệu từ API. Mã lỗi: " + status);
                request.getRequestDispatcher("error.jsp").forward(request, response);
                return;
            }

        } catch (IOException e) {
            e.printStackTrace();
            request.setAttribute("error", "Lỗi kết nối đến API: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }

        // Chuyển danh sách xe đến trang hiển thị (compare.jsp)
        if (!carDetails.isEmpty()) {
            request.setAttribute("listCar", carDetails);
            request.getRequestDispatcher("compare.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "Không tìm thấy thông tin xe.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
