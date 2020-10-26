/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ame_coronado
 */

import java.io.IOException;
import java.io.PrintWriter;
/*Calendar*/
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import newpackage.Bean;


@WebServlet(urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {
    Calendar c1= new GregorianCalendar();
    Bean bean = new Bean();
    String[] mes = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre 👻", "Noviembre", "Diciembre"}; 
    

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
            out.println("<title>Servlet NewServlet</title>"); 
            /*Agregamos css*/
            out.println("<link rel=\"stylesheet\" href=\"css/mystyle.css\">");
            out.println("</head>");
            out.println("<body>");
            bean.setNombre(request.getParameter("nombre"));
            bean.setEdad(Integer.parseInt(request.getParameter("edad")));     
            
            /*Título de la página*/
            out.println("<h1> ¿Ya puedo votar? </h1>"); 
            
            /*Si son mayores de 18 años, se imprime en pantalla que ya pueden votar*/
            if(bean.getEdad()>=18){
                out.println("<h2>"+"Felicidades "+bean.getNombre()+" eres mayor de edad, y puedes votar 😀"+"</h2>");
            }else{
                out.println("<h2>"+bean.getNombre()+", aún no tienes la edad para votar 😕 "+"</h2>");
            }
            
            /*Se obtiene el número de mes en el que estamos*/
            int dia = c1.get(Calendar.MONTH);
            String nombreMes = "";
            /*Según el número de mes, se guarda su nombre*/
            for (String me : mes) {
                nombreMes=mes[dia];
            }
            /*Se le desea al usuario un buen mes*/
            out.println("<h4>"+"Ten un buen "+ nombreMes+"</h4>");
            
 
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