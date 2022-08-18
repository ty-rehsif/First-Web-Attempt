/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers_servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Applicant;
import models.ApplicantFileIO;

/**
 *
 * @author Tyrese Fisher
 */
public class DecisionMaker extends HttpServlet {

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
    //create file name to pass to IO class
    final String file = "C:\\Users\\Tyrese Fisher\\Documents\\NetBeansProjects\\"
            + "Assignments\\Assignment I\\Assignment1_Tyrese_Fisher\\ApplicantIO.txt";
    //create forwarding url and variables to get parameters
    //get the parameters
        String url = "/ThankYou.jsp";
        String iq = request.getParameter("iq");
        String beverage = request.getParameter("beverage");
        String [] powers = request.getParameterValues("superpower");
        //validate the id, beverage and powers to user has
            if (iq == null || beverage == null ||
                    iq.trim().isEmpty() || beverage.trim().isEmpty()){ 
                url = "/AboutMe.jsp";
                }
            else{ 
 
        //create an array list to store the powers for passing
        //convert the string array into a list
            ArrayList<String> pList = new ArrayList<>(); 
        //sending this message if no powers are selected
            if (powers == null){
                pList.add("Having No Power Is A Power");
            }
            else{
            pList.addAll(Arrays.asList(powers));
            }
        //create variables for the hidden inputs from the previous servlet
            try{
            String fullname = request.getParameter("fullname");
            String email = request.getParameter("email");
        //create the object to store the variables in for file output
        //do not have the parse this info
        //create ArrayList objects for the applicants
            Applicant applicant = new Applicant(fullname,email,iq,beverage,pList);
        //get score from Application model to reply different messages
            int score = applicant.getScore();
        //writing the applicant to the file using the writeToFile() from ApplicantIO
            ApplicantFileIO.writeToFile(applicant,file);
        //setting name, email, iq, beverage, superpower and score attribute
            request.setAttribute("fullname", fullname);
            request.setAttribute("email", email);
            request.setAttribute("iq", iq);
            request.setAttribute("beverage", beverage);
            request.setAttribute("superpower", pList);
            
            request.setAttribute("score", score);
            String message;
        //if score 60 or more pass
            if(score >=60){
                message = "Congratulations! Welcome to Marvel!";
                }
        //if score less than 60 fail
            else{
                message = "Thank you for your interest. Good luck.";
                }
        //setting and creating the message attribute
            request.setAttribute("message", message);
            }catch(Exception e){
                log(e);
                }       
                }
            getServletContext().getRequestDispatcher(url).forward(request, response);
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

    private void log(Exception e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
