/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author Tyrese Fisher
 */
public class ApplicantFileIO {
    
    public static void writeToFile(Applicant applicant, String file){
        try{
            FileOutputStream fileOut = new FileOutputStream(file, true);
            ObjectOutputStream obOut = new ObjectOutputStream(fileOut);
                obOut.writeObject(applicant);
                obOut.close();
                System.out.println("Serialize completed");
            
            }catch(IOException e){
                log(e);
            }
    }

    private static void log(IOException e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

