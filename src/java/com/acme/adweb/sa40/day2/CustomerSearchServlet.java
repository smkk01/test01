/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.adweb.sa40.day2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/search")
public class CustomerSearchServlet extends HttpServlet {
    
    @EJB private CustomerBean customerBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Integer custId = Integer.parseInt(req.getParameter("custId"));
        
        Customer customer = customerBean.find(custId);
        String msg;
        
        resp.setContentType("text/plain");
        if (null == customer) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            msg = "Cannot find customer " + custId;
        } else {
            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
            msg = customer.toString();
        }
        
        try (PrintWriter pw = resp.getWriter()) {
            pw.println(msg);
        }
    }
    
    
    
}
