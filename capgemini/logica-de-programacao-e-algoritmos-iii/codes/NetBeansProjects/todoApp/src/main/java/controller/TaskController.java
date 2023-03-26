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
import model.Task;
import util.ConnectionFactory;

/**
 *
 * @author luciano
 */
public class TaskController {
    
    public void save(Task task){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        String sql = 
                "INSERT INTO TASKS (idProject, name, description, completed, " +
                "notes, deadline, createdAt, updatedAt) " +
                "VALUES (?,?,?,?,?,?,?,?)";
        
        Connection conn = null;
        PreparedStatement st = null;
        
        try {

            conn = ConnectionFactory.getConnection();
            st = conn.prepareStatement(sql);
            st.setInt(1, task.getIdProject());
            st.setString(2, task.getName());
            st.setString(3, task.getDescription());
            st.setBoolean(4, task.isIsCompleted());
            st.setString(5, task.getNotes());
            String dealineStr = sdf.format(task.getDeadline());
            st.setString(6, dealineStr);
            String createdAtStr = sdf.format(task.getCreatedAt());
            st.setString(7, createdAtStr);
            String updatedAtStr = sdf.format(task.getUpdatedAt());
            st.setString(8, updatedAtStr);
            st.execute();
            
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar a tarefa " +
                    e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(conn, st);
            
        }       
    }
    
    public void update(Task task){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        String sql = 
                "UPDATE tasks SET idProject = ?, name = ?, description = ?, " +
                "notes = ?, completed = ?, deadline = ?, createdAt = ?, " +
                "updatedAt = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement st = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            st = conn.prepareStatement(sql);
            st.setInt(1, task.getIdProject());
            st.setString(2, task.getName());
            st.setString(3, task.getDescription());
            st.setString(4, task.getNotes());
            st.setBoolean(5, task.isIsCompleted());
            String deadLineStr = sdf.format(task.getDeadline());
            st.setString(6, deadLineStr);
            String createdAtStr = sdf.format(task.getCreatedAt());
            st.setString(7, createdAtStr);
            String updatedAt = sdf.format(task.getUpdatedAt());
            st.setString(8, updatedAt);
            st.setInt(9, task.getId());
            st.execute();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar a tarefa");
        } finally {
            ConnectionFactory.closeConnection(conn, st);        
        }
        
    }
    
    // Aula 11.b
    public void removeById(int taskId) {
        String sql = "DELETE FROM TASKS WHERE id = ?";
        
        Connection conn = null;
        PreparedStatement st = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            st = conn.prepareStatement(sql);
            st.setInt(1, taskId);
            st.execute();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar a tarefa");
        } finally {
            ConnectionFactory.closeConnection(conn, st);        
        }
        
    }
    
    public List<Task> getAll(int idProject){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        String sql = "SELECT * FROM tasks WHERE idProject = ?";
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        
        List<Task> tasks = new ArrayList<Task>();
        
        try {
            conn = ConnectionFactory.getConnection();
            st = conn.prepareStatement(sql);
            st.setInt(1, idProject);
            rs = st.executeQuery();
            
            while(rs.next()){
                Task task = new Task();
                task.setId(rs.getInt("id"));
                task.setIdProject(rs.getInt("idProject"));
                task.setName(rs.getString("name"));
                task.setDescription(rs.getString("description"));
                task.setNotes(rs.getString("notes"));
                task.setIsCompleted(rs.getBoolean("completed"));
                task.setDeadline(sdf.parse(rs.getString("deadline")));
                task.setCreatedAt(sdf.parse(rs.getString("createdAt")));
                task.setUpdatedAt(sdf.parse(rs.getString("updatedAt")));   
                
                tasks.add(task);
            }
            
        } catch (Exception e) {
            throw new RuntimeException("Erro ao consultar ", e);
        } finally {
            ConnectionFactory.closeConnection(conn, st);
        }        
           
        return tasks;
    }
    
}

