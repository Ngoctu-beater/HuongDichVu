/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import com.google.gson.Gson;
import dao.DAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.DAO;
import entity.Company;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
@WebServlet(name = "StatisticsController", urlPatterns = {"/StatisticsController"})
public class StatisticsController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private DAO statisticsDAO = new DAOImpl();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int countCompany = statisticsDAO.getTotalCompany();
        long totalPrice = statisticsDAO.getTotalPrice();
        int countCar = statisticsDAO.getTotalCar();
        int newCar = statisticsDAO.getNewCar();
        int usedCar = statisticsDAO.getUsedCar();

        String data = "[" + newCar + "," + usedCar + "]";

        // Lấy danh sách tên công ty và số lượng xe từ DAO
        List<Object[]> numberByCompany = statisticsDAO.numberByCompany();
        List<String> companyNames = new ArrayList<>();
        List<Integer> carCounts = new ArrayList<>();

        // Duyệt qua danh sách để phân tách tên công ty và số lượng xe
        for (Object[] companyData : numberByCompany) {
            companyNames.add((String) companyData[0]);
            carCounts.add((Integer) companyData[1]);
        }

        // Tạo chuỗi JSON cho biểu đồ
        String nameCompany = new Gson().toJson(companyNames);
        String dataCompany = new Gson().toJson(carCounts);
        request.setAttribute("totalCompany", countCompany);
        request.setAttribute("totalPrice", totalPrice);
        request.setAttribute("totalCar", countCar);
        request.setAttribute("data", data);
        request.setAttribute("nameCompany", nameCompany);
        request.setAttribute("dataCompany", dataCompany);
        request.getRequestDispatcher("statistics.jsp").forward(request, response);
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
