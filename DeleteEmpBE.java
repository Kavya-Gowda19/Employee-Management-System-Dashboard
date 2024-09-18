/*
  Delete Details to the empdetails database to the studdbms tablename
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

/**
 *
 * @author 91953
 */
//@WebServlet(name = "DeleteEmpBE", urlPatterns = {"/DeleteEmpBE"})
public class DeleteEmpBE extends HttpServlet {

    /*
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DeleteEmpBE</title>");  
            out.println(" <link rel=\"stylesheet\" type=\"text/css\" href=\"dboard.css\">");
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet DeleteEmpBE at " + request.getContextPath() + "</h1>");
            int id=Integer.parseInt(request.getParameter("ID"));
            //out.println("Student Id:"+sid);
            Connection con = DbConnection.getConnectToEmpAttd();
            String sql = "DELETE FROM EMPDBMS WHERE ID=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            int i = ps.executeUpdate();
            if (i > 0) {
                out.println("<h2>Employee Record Deleted</h2>");
            }
            con.close();
            out.println("</body>");
            out.println("</html>");
            
        }
    }

        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DeleteEmpBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DeleteEmpBE.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DeleteEmpBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DeleteEmpBE.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}