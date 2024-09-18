/*
 * Add Details to the empdetails database to the empdbms tablename
DB Name:empdetails
table:empdbms
 */
package Employeedbms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddEmpBE extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddEmpBE</title>");            
            out.println(" <link rel=\"stylesheet\" type=\"text/css\" href=\"dboard.css\">");
            out.println("</head>");
            out.println("<body>");
            long id=Long.parseLong(request.getParameter("id"));
            String name=request.getParameter("name");
            String emailid=request.getParameter("emailid");
            String pwd=request.getParameter("pwd");                  
            long mno=Long.parseLong(request.getParameter("mno"));
            String department=request.getParameter("department");
            String designation=request.getParameter("designation");   
            long salary=Long.parseLong(request.getParameter("salary"));
//     
         Connection con = DbConnection.getConnectToEmpAttd();
        String sql="INSERT INTO Employeedbms(ID,NAME,EMAILID,PWD,MNO,DEPARTMENT,DESIGNATION,SALARY) VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setLong(1, id);
        ps.setString(2, name);
        ps.setString(3, emailid);
        ps.setString(4, pwd);
        ps.setLong(5, mno);
        ps.setString(6,department);
        ps.setString(7,designation);
        ps.setLong(8, salary);
        int i=ps.executeUpdate();
        if(i>0)
        {
            out.println("<h3 class=''> Thank you for Register</h2>");
        }
          con.close();  //out.println("<h1>Servlet AddEmpBE at " + requqest.getContextPath() + "</h1>");
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
            Logger.getLogger(AddEmpBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddEmpBE.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AddEmpBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddEmpBE.class.getName()).log(Level.SEVERE, null, ex);
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