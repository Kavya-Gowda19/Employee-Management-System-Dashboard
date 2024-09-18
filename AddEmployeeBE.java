/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employeedbms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kavya
 */
public class AddEmployeeBE extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
           // out.println("<title>Servlet AddEmployeeBE</title>");            
            out.println("</head>");
            out.println("<body>");
            String name=request.getParameter("sname");
            String dob=request.getParameter("dob");
            String address=request.getParameter("address");
            long mno=Long.parseLong(request.getParameter("mno"));
            int sem=Integer.parseInt(request.getParameter("sem"));
            String emailid=request.getParameter("email");
            String pwd=request.getParameter("pwd");
            long pmno=Long.parseLong(request.getParameter("pmno"));
//            out.println("Nsmr:"+name);
//            out.println("dob:"+dob);
//            out.println("Address"+address);
//            out.println("MNO"+mno);
//            out.println("Semester"+sem);
//            out.println("E-mail"+emailid);
//            out.println("Address"+pwd);
//            out.println("Parent's MNO"+pmno);
        Connection con=DbConnection.getConnectToStudAttd();
        String sql="INSERT INTO STUDDBMSS(NAME,DOB,ADDRESS,MNO,SEM,EMAILID,PWD,PMNO) VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, dob);
        ps.setString(3, address);
        ps.setLong(4, mno);
        ps.setInt(5, sem);
        ps.setString(6, emailid);
        ps.setString(7, pwd);
        ps.setLong(8, pmno);
        int i=ps.executeUpdate();
        if(i>0)
        {
            out.println("<h3> Thank you for Register</h2>");
        }
          con.close();
            //out.println("<h1>Servlet AddStudBE at " + request.getContextPath() + "</h1>");
            out.println("<h1>Servlet AddEmployeeBE at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddEmployeeBE.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddEmployeeBE.class.getName()).log(Level.SEVERE, null, ex);
        }
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
