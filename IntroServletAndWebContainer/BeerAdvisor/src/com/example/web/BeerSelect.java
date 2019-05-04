package com.example.web;

import com.example.model.BeerExpert;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "BeerSelect")
public class BeerSelect extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String c = request.getParameter("color");
        BeerExpert be = new BeerExpert();
        List result = be.getBrands(c);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("Beer Selection Advice<br>");

        Iterator it = result.iterator();
        while (it.hasNext()) {
            out.print("<br>try: " + it.next());
        }
    }

}
