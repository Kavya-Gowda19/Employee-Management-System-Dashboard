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

public class UpdateEmpBE extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateEmpBE</title>"); 
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"dboard.css\">");
            out.println("</head>");
            out.println("<body>");

            int id = Integer.parseInt(request.getParameter("id"));
            long mno = Long.parseLong(request.getParameter("mno"));
            String name = request.getParameter("name");
            long salary = Long.parseLong(request.getParameter("salary"));

            Connection con = null;
            PreparedStatement ps = null;
            try {
                con = DbConnection.getConnectToEmpAttd();
                String sql = "UPDATE EMPDBMS SET MNO=?, NAME=?, SALARY=? WHERE ID=?";
                ps = con.prepareStatement(sql);
                ps.setLong(1, mno);
                ps.setString(2, name);
                ps.setLong(3, salary);
                ps.setInt(4, id);

                int i = ps.executeUpdate();
                if (i > 0) {
                    out.println("<h2>Employee Record Updated</h2>");
                } else {
                    out.println("<h2>Failed to update employee record</h2>");
                }
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(UpdateEmpBE.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(UpdateEmpBE.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}