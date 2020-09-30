/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stormcloud.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author StormCloud
 */
public class calc extends HttpServlet {

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
        getServletContext().getRequestDispatcher("/WEB-INF/calculator.jsp").forward(request, response);
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
        
        getServletContext().getRequestDispatcher("/WEB-INF/calculator.jsp").forward(request, response);
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
        
        String number1 = request.getParameter("num1");
        String number2 = request.getParameter("num2");
        String act =  request.getParameter("action");
        String result = "";
        
        request.setAttribute("number1", number1);
        request.setAttribute("number2", number2);
        
        if (number1 == null || number1.equals("") ||
                number2 == null || number2.equals("")) {
            request.setAttribute("incomplete", true);
            
            
            
        }else{
            double num1,num2;
            num1 = Double.parseDouble(number1);
            num2 = Double.parseDouble(number2);
            
            switch(act.charAt(0)){
                case '+':
                    result = Double.toString(num1+num2);
                    break;
                case '-':
                    result = Double.toString(num1-num2);
                    break;
                case '*':
                    result = Double.toString(num1*num2);
                    break;
                case '/':
                    result = Double.toString(num1/num2);
                    break;
            }
            request.setAttribute("result", result);
        }
        
        
        getServletContext().getRequestDispatcher("/WEB-INF/calculator.jsp").forward(request, response);
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
