/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.modulosoftwarega7.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ClienteServlet")
public class ClienteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Recibir datos del formulario
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String email = request.getParameter("email");

        try (PrintWriter out = response.getWriter()) {
            // Validar que los datos no estén vacíos o nulos
            if (name == null || name.isEmpty() ||
                phone == null || phone.isEmpty() ||
                address == null || address.isEmpty() ||
                email == null || email.isEmpty()) {

                out.println("<html>");
                out.println("<head><title>Error</title></head>");
                out.println("<body>");
                out.println("<h1>Error: Datos incompletos</h1>");
                out.println("<p>Por favor, completa todos los campos del formulario.</p>");
                out.println("<a href='index.html'>Volver al formulario</a>");
                out.println("</body>");
                out.println("</html>");
            } else {
                // Construir una respuesta HTML para datos válidos
                out.println("<html>");
                out.println("<head><title>Cliente Registrado</title></head>");
                out.println("<body>");
                out.println("<h1>Cliente registrado exitosamente</h1>");
                out.println("<p><strong>Nombre:</strong> " + name + "</p>");
                out.println("<p><strong>Teléfono:</strong> " + phone + "</p>");
                out.println("<p><strong>Dirección:</strong> " + address + "</p>");
                out.println("<p><strong>Correo:</strong> " + email + "</p>");
                out.println("<a href='index.html'>Volver al formulario</a>");
                out.println("</body>");
                out.println("</html>");
            }
        }
    }
}
