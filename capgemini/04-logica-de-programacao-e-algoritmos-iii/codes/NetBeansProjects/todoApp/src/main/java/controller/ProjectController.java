/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import model.Task;
import util.ConnectionFactory;

/**
 *
 * @author luciano
 */
public class ProjectController {
    
    public void save(Project project){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        String sql = 
                "INSERT INTO PROJECTS (name, description, " +
                "createdAt, updatedAt) " +
                "VALUES (?,?,?,?)";
        
        Connection conn = null;
        PreparedStatement st = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            st = conn.prepareStatement(sql);
            st.setString(1, project.getName());
            st.setString(2, project.getDescription());
            String createdAtStr = sdf.format(project.getCreatedAt());
            st.setString(3, createdAtStr);
            String updatedAtStr = sdf.format(project.getUpdatedAt());
            st.setString(4, updatedAtStr);
            st.execute();
            
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar um projeto " +
                    e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(conn, st);
            
        }       
    }
    
    public void update(Project project){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        String sql = 
                "UPDATE projects SET name = ?, description = ?, " +
                "createdAt = ?, updatedAt = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement st = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            st = conn.prepareStatement(sql);            
            st.setString(1, project.getName());
            st.setString(2, project.getDescription());
            String createdAtStr = sdf.format(project.getCreatedAt());
            st.setString(3, createdAtStr);
            String updatedAt = sdf.format(project.getUpdatedAt());
            st.setString(4, updatedAt);
            st.setInt(5, project.getId());
            st.execute();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar a projeto");
        } finally {
            ConnectionFactory.closeConnection(conn, st);        
        }
        
    }
    
    // Aula 11.b
    public void removeById(int projectId) throws SQLException{
        String sql = "DELETE FROM PROJECTS WHERE id = ?";
        
        Connection conn = null;
        PreparedStatement st = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            st = conn.prepareStatement(sql);
            st.setInt(1, projectId);
            boolean removido = st.execute();
            
            if (removido)
                System.out.println("Removido com sucesso");
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar um projeto");
        } finally {
            ConnectionFactory.closeConnection(conn, st);        
        }
        
    }
    
    public List<Project> getAll(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        String sql = "SELECT * FROM projects";
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        
        List<Project> projects = new ArrayList<Project>();
        
        try {
            conn = ConnectionFactory.getConnection();
            st = conn.prepareStatement(sql);            
            rs = st.executeQuery();
            
            while(rs.next()){
                Project project = new Project();
                project.setId(rs.getInt("id"));
                project.setName(rs.getString("name"));
                project.setDescription(rs.getString("description"));
                project.setCreatedAt(sdf.parse(rs.getString("createdAt")));
                project.setUpdatedAt(sdf.parse(rs.getString("updatedAt")));   
                
                projects.add(project);
            }
            
        } catch (Exception e) {
            throw new RuntimeException("Erro ao consultar ", e);
        } finally {
            ConnectionFactory.closeConnection(conn, st);
        }        
           
        return projects;
    }    
    
}
