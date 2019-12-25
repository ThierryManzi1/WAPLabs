/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Owner
 */
public class QuizServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     *
     */
    HttpSession session = null;
    private int index =0;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Quiz q = new Quiz();
      
        if(session!=null){
            session.invalidate();
            session = null;
        }
          session = request.getSession();
          session.setAttribute("mytest", q);
          q.setRes(0); //is it necessary??
        if(index< q.getQuestions().length){
            
            PrintWriter out = response.getWriter();
            out.print("<html><head><title>Test</title>"
                    +"<link href ='styles.css' type='text/css' rel= stylesheet></head>");
            out.print("<body><form method='POST' action='QuizServlet'>");
            out.print("<h1>The number Quiz</h1>");
            out.print("<p>Your current score is :"+q.getRes()+"</p>");
            out.print("<p>Guess the next number in the sequence.</p>");
            out.print("<p>"+q.getQuestions()[index]+"</p>");
            out.print("Your answer:<input type='text' name='userres'/>");
            out.print("<input type='submit' value='Submit'");
            out.print("</form>");
            out.print("</body></html>");
            index++;
        }else{
            session.invalidate();
            
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

        session = request.getSession();

        Quiz q = (Quiz) session.getAttribute("mytest");
        int answer = Integer.parseInt(request.getParameter("userres"));
        if (answer == Quiz.getAnswers()[index - 1]) {
            q.setRes(q.getRes() + 1);
        }
        if (index < q.getQuestions().length) {
            PrintWriter out = response.getWriter();
            out.print("<html><head><title>Test</title>"
                    + "<link href ='styles.css' type ='text/css' rel ='stylesheet'> </head><body></head><body>");
            out.print("<form method='POST' action='QuizServlet'>");
            out.print("<h1>The Number Quiz</h1>");
            out.print("<p>Your current score is " + q.getRes() + "</p>");
            out.print("<p>Guess the next number in the sequence.</p>");
            out.print("<p>" + q.getQuestions()[index] + "</p>");
            out.print("Your answer: <input type='text' name='userres'/>");
            out.print("<input type='submit' value='Submit'/>");
            out.print("</form>");
            out.print("</body></html>");
            index++;
        } else {

            PrintWriter out = response.getWriter();
            out.print("<html><head><title>Test</title>"
                    + "<link href ='styles.css' type ='text/css' rel ='stylesheet'> </head><body></head><body>");
            out.print("<div class='final'>");
            out.print("<h1>The Number Quiz</h1>");
            out.print("<p>Your current score is " + q.getRes() + "</p>");
            out.print("<p>You have completed the Number Quiz with a score of " + q.getRes() + " out of " + q.getQuestions().length + ".</p>");

            out.print("</div>");
            out.print("</body></html>");
            session.invalidate();
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
