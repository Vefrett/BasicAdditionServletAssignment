/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vefrett;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gabrielle
 */
@WebServlet(name = "BasicAddition", urlPatterns = {"/addition"})
public class BasicAddition extends HttpServlet {

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
        
        //Get result as string match below
        String number1 = request.getParameter("number1");
        String number2 = request.getParameter("number2");
        BigDecimal num1 = BigDecimal.ZERO;
        BigDecimal num2 = BigDecimal.ZERO;
        String error1 =  "";
        String error2 = "";
                
        if(number1 == null || number1.equals("")){ 
            number1 = "0";
        }
        if(number2 == null || number2.equals("")){
            number2 = "0";
        }
        try{ 
           num1 = new BigDecimal(number1); 
        } catch (NumberFormatException ex){
            error1 = "Not a number";
        }
        try{
           num2 = new BigDecimal(number2); 
        } catch (NumberFormatException ex){
           error2 = "Not a number";
        }
        
        
        
        BigDecimal sum = num1.add(num2);
        String output = number1 + " + " + number2 + " = " + sum;
        
        if (error1.equals("Not a number") && error2.equals("Not a number")
            || error1.equals("Not a number") && error2.equals("") || error1.equals("")
            && error2.equals("Not a number")) {
        output = "There is no sum.";
        number1 = "0";
        number2 = "0";
    } 
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Basic Addition Servlet Assignment</title>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width," 
                    + " initial-scale=1.0\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<header>");
            out.println("<h1>Basic Addition Servlet Assignment</h1>");
            out.println("</header>");
            out.println("<main>");
            out.println("<p>Please enter two numbers and click the Submit" 
                    + " button.</p>");
            out.println("<form action=\"addition\" method=\"POST\" >");
            out.println("<label for=\"number1\">First Number</label>");
            out.println("<input type=\"text\" id=\"number1\" name=\"number1\" " 
                    + "value='" + number1 + "' /> " + error1 );
            out.println("<br />");
            out.println("<label for=\"number2\">Second Number</label>");
            out.println("<input type=\"text\" id=\"number2\" name=\"number2\" " 
                    + " value='" +  number2 + "'/> " + error2 );
            out.println("<br />");
            
            out.println("<input type=\"submit\" value=\"Submit\" />");
            out.println("</form>");
            out.println("<p>Result:</p>" + output) ;
            out.println("");
            out.println("</main>");
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
