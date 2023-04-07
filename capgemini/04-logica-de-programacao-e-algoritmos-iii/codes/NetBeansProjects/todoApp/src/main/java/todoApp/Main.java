/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todoApp;

import controller.ProjectController;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.Project;

/**
 *
 * @author luciano
 */
public class Main {

    public static void main(String[] args) 
            throws ParseException, SQLException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        Date createdAt = sdf.parse("01/03/2023");
        Date updatedAt = sdf.parse("01/03/2023");
        
        Project p = new Project(5, "Teste2", "Teste2", createdAt, updatedAt);;
        
        ProjectController pc = new ProjectController();
        pc.update(p);
        
        for (Project prj: pc.getAll()){
            System.out.printf("%s\n", prj);
        }
    }
    
}

// Ultima aula assistida: 12.A