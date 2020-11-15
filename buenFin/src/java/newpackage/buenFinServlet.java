
import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class buenFinServlet extends HttpServlet
{
   protected void processRequest( HttpServletRequest request, HttpServletResponse response )
       throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        //Precios
        String [][] Precio = { // Precios para modelos Playeras
                               { "$ 250", "$ 200", "$ 180", "$ 230" },
                               // Precios para modelos Sudaderas
			       { "$ 300", "$ 340", "$ 235"},
                               // Precios para modelos bolsas
			       { "$ 95", "$ 100"}};
        String [][] PrecioN = { // Precios para modelos Playeras
                               { "$ 150", "$ 170", "$ 150", "$ 200" },
                               // Precios para modelos Sudaderas
			       { "$ 150", "$ 300", "$ 130"},
                               // Precios para modelos bolsas
			       { "$ 45", "$ 50"}};

//		String[][] Imagen = {{ "<img src=\"Imagenes/Volvo/vt880_US_800x600.jpg\"/>", "MM01", "MM02", "MM03" },
        
 		String[][] Imagen = { // Imagenes de modelos Playeras
                                      { "\"Imagenes/Playeras/corazon.jpg\"", 
			               "\"Imagenes/Playeras/dinosaurio.jpg\"", 
			               "\"Imagenes/Playeras/elefante.jpg\"", 
			               "\"Imagenes/Playeras/rostro.jpg\"" },
                                     // Im�genes de modelos Sudaderas
           		             { "\"Imagenes/Sudaderas/astronauta.jpg\"", 
				       "\"Imagenes/Sudaderas/conejos.jpg\"", 
				       "\"Imagenes/Sudaderas/escarabajo.jpg\""},
                                     // Im�genes de modelos Bolsas
				     { "\"Imagenes/Bolsas/dinosaurio.jpg\"",
				       "\"Imagenes/Bolsas/mano.jpg\""}};
                
                String [][] Descripcion = { // Modelos Playera
                                        { "Playera de algodón bordada a mano con corazón floreciendo",  
                                          "Playera de algodón con estampado de dinosaurio", 
                                          "Playera de algodón bordada a mano con frase y elefante", 
                                          "Playera de algodon con bordado en espejo de rostros" },
                                        // Modelos Sudaderas
				        { "Sudadera bordada a mano de astronauta",  "Sudadera con estampado de conejos en 'espejo'", "Sudadera con estampado de escarabajo"},
                                        //  Modelos Bolsas
				        { "Bolsa de yute negro con estampado de dinosaurio",  "Bolsa de yute negro con estampado de brazo"}};

		String [][] Modelos = { // Modelos Playera
                                        { "Corazon",  "Dinosaurio", "Elefante", "Rostro" },
                                        // Modelos Sudaderas
				        { "Astronauta",  "Conejos", "Escarabajo"},
                                        //  Modelos Bolsas
				        { "Dinosaurio",  "Mano"}};
                
                

	int Articulo = Integer.parseInt( request.getParameter( "articulo" ));
        int Modelo = Integer.parseInt( request.getParameter(  "modelo" ));
        //int Descrip = Integer.parseInt( request.getParameter(  "descripcion" ));

		System.out.println( "-----> Valor de los par�metros: " );
		System.out.println( "Articulo : " + Articulo + " Modelo: " + Modelo);

		if ( Modelo == -1 )
		   {
		 	 String ModelosStr = "";
			 for( int i = 0; i < Modelos[ Articulo ].length; i++ )
				ModelosStr = ModelosStr + Modelos[ Articulo ][ i ] + "|";
			 response.setContentType( "text/html" );
			 System.out.println( ModelosStr );
			 out.println( ModelosStr );
		   }
		else
		  {
			 //formaci�n del documento XML de respuesta
			   response.setContentType( "text/xml;charset=UTF-8" );
			   String textoXML = "<?xml version='1.0'?>" ;
			   textoXML += "<Tienda>" ;
                           textoXML += "<Imagen>" + Imagen[ Articulo ][ Modelo ] + "</Imagen>" ;
                           textoXML += "<Detalles>" + Descripcion[ Articulo ][ Modelo ] + "</Detalles>" ;
			   textoXML += "<Antes>" + Precio[ Articulo ][ Modelo ]  + "</Antes>" ;
                           textoXML += "<Ahora>" + PrecioN[ Articulo ][ Modelo ]  + "</Ahora>" ;
                           //textoXML += "<Descripcion>" + Descripcion[ Articulo ][ Modelo ] + "</Descripcion>" ;
			   textoXML += "</Tienda>" ;
			   out.println( textoXML ) ;
		  }
        out.close() ;
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
       throws ServletException, IOException {
        
		processRequest( request, response );
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
       throws ServletException, IOException {
        
		processRequest( request, response );
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {

		return "Short description" ;
    }
    // </editor-fold>
}
