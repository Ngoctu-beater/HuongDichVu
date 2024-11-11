/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import dao.DAO;
import dao.DAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "EditController", urlPatterns = {"/EditController"})
public class EditController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     private DAO editDAO = new DAOImpl();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String cid = request.getParameter("carId");
        int id = Integer.parseInt(cid);
        String name = request.getParameter("carName");
        String pricetitle = request.getParameter("carPriceTitle");
        String cprice = request.getParameter("carPrice");
        int price = Integer.parseInt(cprice);
        String cyear = request.getParameter("carYear");
        int year = Integer.parseInt(cyear);
        String status = request.getParameter("carStatus");
        String hasgone = request.getParameter("carHasgone");
        String origin = request.getParameter("carOrigin");
        String style = request.getParameter("carStyle");
        String gearbox = request.getParameter("carGearbox");
        String engine = request.getParameter("carEngine");
        String exterior = request.getParameter("carExterior");
        String interior = request.getParameter("carInterior");
        String seats = request.getParameter("carSeats");
        String doors = request.getParameter("carDoors");
        String drive = request.getParameter("carDrive");
        String describe = request.getParameter("carDescribe");
        String link = request.getParameter("carLink");

        editDAO.editCar(name, pricetitle, price, year, status, hasgone, origin, style, gearbox, engine, exterior, interior, seats, doors, drive, describe, link, id);
        response.sendRedirect("CarController");
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
