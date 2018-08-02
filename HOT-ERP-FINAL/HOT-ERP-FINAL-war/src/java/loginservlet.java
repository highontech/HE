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
            String url = "jdbc:sqlserver://localhost:1433;databaseName=HOT ERP";
            String user = "HOTERP";
            String passdatabase ="1122";
            
            try {
                
                String usern = null;
                String passw = null;
                String desig = null;
               
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection con = DriverManager.getConnection(url, user, passdatabase);
                Statement stmt = con.createStatement();
                String query="SELECT * FROM login WHERE CONVERT(VARCHAR, username)='"+username+"' AND CONVERT(VARCHAR, password)='"+pass+"'AND CONVERT(VARCHAR, designation)='"+designation+"';";
            
                ResultSet rs = stmt.executeQuery(query);
                try {
                    rs.next();
                    usern=rs.getString("username");    
                    passw=rs.getString("password");    
                    desig=rs.getString("designation");
                    
                    
                   if(desig.equals("MD"))
                    {
                        
                    }
                      
                  else if(desig.equals("CEO"))
                    {
                        
                    }
                    
                    else if(desig.equals("MO"))
                    {
                        
                    }
                    
                   else if(desig.equals("CTO"))
                    {
                        
                    }
                    
                   
                   else if(desig.equals("Team Leader"))
                    {
                          response.sendRedirect("http://localhost:8080/HOT-ERP-FINAL-war/teamlead.jsp");      
                    }   
                    
                   else if(desig.equals("Team Member"))
                    {
                        
                    }
                    
                   else if(desig.equals("HR Manager"))
                    {
                        
                    }
                    
                   else if(desig.equals("Product Manager"))
                    {
                        
                    }
                    
                    
                   
                } catch(Exception e) {
                    out.print(e);
                    usern = null;
                    passw = null;
                    desig = null;
                    response.sendRedirect("http://localhost:8080/HOT-ERP-FINAL-war/login.jsp");
                    out.print("Cant Login");
                }
 
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


