/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Bean.Bean;
import Modelo.miModelo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ameri
 */
@WebServlet(name = "HolaMundo", urlPatterns = {"/HolaMundo"})
public class HolaMundo extends HttpServlet {
    Bean bean = new Bean();
    miModelo modelo = new miModelo();

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HolaMundo</title>");            
            out.println("</head>");
            out.println("<body>");
            
            /*Los asignamos*/
            bean.setNombre(request.getParameter("usuario"));
            bean.setContrasenia(request.getParameter("password"));
            /*Título de la página*/
            out.println("<h1> Inicio de sesión </h1>");
            
            
            
            String tmp;
            for(Enumeration<String> params = request.getParameterNames();params.hasMoreElements();){
                tmp = params.nextElement();
            out.println(tmp+": "+request.getParameter(tmp)+"<br>");
            }
            
            if(modelo.valida( bean.getContrasenia(),bean.getNombre())){
                out.println("Bienvenido");
            } else {
                out.println("Acceso denegado");
            }
            
            
            
            
            out.println("<h1>Servlet HolaMundo at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            out.close();
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
