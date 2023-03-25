/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author luciano
 */
public class Project {
    
    private int id;
    private String name;
    private String description;
    private Date createdAt;
    private Date updatedAt;

    public Project(int id, String name, String description, Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Project(String name, String description, Date createdAt, Date updatedAt) {
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    } 
    
    public Project() {
        this.createdAt = new Date();
    }      
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        return "Project{" + "id=" + id + ", name=" + name + 
                ", description=" + description + ", createdAt=" + 
                sdf.format(createdAt) + ", updatedAt=" + sdf.format(updatedAt) + '}';
    }  
    
}
