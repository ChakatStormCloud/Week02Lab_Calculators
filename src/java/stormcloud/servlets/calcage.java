/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stormcloud.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author StormCloud
 */
public class calcage extends HttpServlet {
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
        getServletContext().getRequestDispatcher("/WEB-INF/agecalc.jsp").forward(request, response);
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
        
        getServletContext().getRequestDispatcher("/WEB-INF/agecalc.jsp").forward(request, response);
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
        
        Date bdate = null;
        try{
            if (request.getParameter("IE").equals("true")){
                
                bdate = Date.valueOf(
                                request.getParameter("byear")+"-"+
                                request.getParameter("bmonth")+"-"+
                                request.getParameter("bday"));
            }else{
                System.out.println(request.getParameter("bdate"));
                bdate = Date.valueOf(request.getParameter("bdate"));
            }
            
            request.setAttribute("bdate", bdate.toString());
            request.setAttribute("byear", bdate.getYear()+1900);
            request.setAttribute("bmonth", bdate.getMonth()+1);
            request.setAttribute("bday", bdate.getDate());
            
            Date now = Date.valueOf(LocalDate.now());
            
            //I really hate this code, but it's after midnight and it works
            int age = now.getYear()-bdate.getYear();
            if(now.getMonth()-bdate.getMonth()<0){
                age--;
            }else if(now.getMonth()-bdate.getMonth()==0){
                if(now.getDate()-bdate.getDate()<0)age--;
            }
            
            request.setAttribute("age", age);
            
            
        }catch(IllegalArgumentException e){
            //e.printStackTrace();
            request.setAttribute("invalid", true);
            
            request.setAttribute("bdate", request.getParameter("bdate"));
            request.setAttribute("byear", request.getParameter("byear"));
            request.setAttribute("bmonth", request.getParameter("bmonth"));
            request.setAttribute("bday", request.getParameter("bday"));
            getServletContext().getRequestDispatcher("/WEB-INF/agecalc.jsp").forward(request, response);
            return;
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/agecalc.jsp").forward(request, response);
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
