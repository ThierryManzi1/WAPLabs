/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.cs472;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Owner
 */
public class Calculator extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param req
     * @param res
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String n1 = req.getParameter("num1");
        String n2 = req.getParameter("num2");
        String n3 = req.getParameter("num3");
        String n4 = req.getParameter("num4");
        int i = 0;
        int j = 0;
        int l = 0;
        int m = 0;
        int answer1 =0, answer2 =0;
        
        if (!n1.equals("") && !n2.equals("")) {
             PrintWriter out = res.getWriter();
            i = Integer.parseInt(req.getParameter("num1"));
            j = Integer.parseInt(req.getParameter("num2"));
            answer1 = i+j;
            out.println(Integer.toString(i) + "+" + Integer.toString(j) + " = " + answer1);
        }
        if (!n3.equals("") && !n4.equals("")) {
             PrintWriter out = res.getWriter();
            l = Integer.parseInt(req.getParameter("num3"));
            m = Integer.parseInt(req.getParameter("num4"));
            answer2 = l*m;
            out.println(Integer.toString(l) + "+" + Integer.toString(m) + " = " + answer2);
            
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet req
     * @param response servlet res
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    }




