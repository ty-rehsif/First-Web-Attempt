/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Tyrese Fisher
 */
public class Applicant implements Serializable {
    //String name, email, iq, beverage, and ArrayList superpower.
    //regular insert code protocol
    //getScore() method

    private String name, email,iq,beverage;
    
    //array list <datatype> name = new arraylist<datatype>();
    private ArrayList<String> superpower;

    public Applicant() {
    }

    public Applicant(String name, String email, String iq, String beverage, ArrayList<String> superpower) {
        this.name = name;
        this.email = email;
        this.iq = iq;
        this.beverage = beverage;
        this.superpower = superpower;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIq() {
        return iq;
    }

    public void setIq(String iq) {
        this.iq = iq;
    }

    public String getBeverage() {
        return beverage;
    }

    public void setBeverage(String beverage) {
        this.beverage = beverage;
    }

    public ArrayList<String> getSuperpower() {
        return superpower;
    }

    public void setSuperpower(ArrayList<String> superpower) {
        this.superpower = superpower;
    }
    public int getScore(){
    //iq = For IQ less than 120 / 121 to 150 / 151 to 180 / greater than 180, 
    //the corresponding points are 15/30/45/60
    //adding to score based on the iq amount
        int score = iq.equals("Less Than 120")? 15 : iq.equals("121 To 150")? 30: 
                iq.equals("151 To 180")? 45: iq.equals("Greater Than 180")? 60: 0;
        
    //adding to score based on beverage selection
    //Water/Juice/Cola/Beer/Wine
    //the corresponding points are 25/20/15/10/5
        score = ((beverage.equals("Water"))? score + 25 : beverage.equals("Juice")? score + 20: 
                beverage.equals("Cola")? score + 15: beverage.equals("Beer")? score + 10: 
                beverage.equals("Wine")? score + 5: score);

    //each super power = +5
    //using the # of superpowers x 5 to add points
    //also checking to see if no powers were selected
        if (!superpower.contains("Having No Power Is A Power")){
            score += (superpower.size()*5);
            }
        return score;
    }
}
