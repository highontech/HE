/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hp
 */
@WebServlet(urlPatterns = {"/loginservlet"})
public class loginservlet extends HttpServlet {

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
     throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        
        
        String username = request.getParameter("username");
        String pass = request.getParameter("password");
        String designation = request.getParameter("designation");
        
        try (PrintWriter out = response.getWriter()) {
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            // String driver = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
            String url = "jdbc:sqlserver://localhost:1527;databaseName=HOT ERP";
            String user = "HOTERP";
            String passdatabase ="1122";
            
            try {
                out.println("<h1>Connection 0</h1>");
                // Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
                Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
                Connection con = DriverManager.getConnection(url, user, passdatabase);
                out.println("<h1>"+username+ "</h1>");
                out.println("<h1>"+pass+"</h1>");
                out.println("<h1>"+designation+"</h1>");
                out.println("<h1>Connection 1</h1>");
                Statement stmt = con.createStatement();
                String query = "INSERT INTO login (username, password, designation) VALUES('"+username+"','"+pass+"','"+designation+"');";
                stmt.executeQuery(query);

                out.println("<h1>Inserted </h1>");
 
            } catch(Exception e) {
                
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Error</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1> "+ e + "  </h1>");
                out.println("</body>");
                out.println("</html>");
            }  
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
    }
}


