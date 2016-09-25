/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dominio.Tradutor;
import dominio.TradutorTXT;
import excecoes.TradutorException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author paulorcv
 */
@WebServlet("/traduzir")
public class TradutorServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
   
            String palavra = request.getParameter("palavra");
            Tradutor tradutor = new TradutorTXT();
            
            
            String palavraTraduzida = "";
            try {
                palavraTraduzida = tradutor.traduzirPalavra(palavra);
            } catch (TradutorException ex) {
                Logger.getLogger(TradutorServlet.class.getName()).log(Level.SEVERE, null, ex);
                palavraTraduzida = "----";
            }
            
            request.setAttribute("palavraTraduzida", palavraTraduzida);
            request.getRequestDispatcher("resultado.jsp").forward(request, response);
            
            
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

}
