package com.todoList.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.todoList.connection.todoListConnection;
import com.todoList.dto.todoList;

import jakarta.servlet.http.HttpServlet;

public class todoListDao{

	private static final String INSERT_TASK = "INSERT INTO todolist (index,taskname, duedate, tags) VALUES (?,?, ?, ?)";
    private static final String DELETE_TASK = "DELETE FROM todolist WHERE id = ?";
    private static final String SELECT_ALL_TASKS = "SELECT * FROM todolist";

    private Connection connection  = todoListConnection.getListItems();
 

    public todoList addTask(todoList task) {
        try (PreparedStatement ps = connection.prepareStatement(INSERT_TASK)) {
            ps.setInt(1, task.getIndex());
            ps.setString(2,task.getTask());
            ps.setObject(3, task.getDuedate());
            ps.setString(4, task.getTags());
            ps.executeUpdate(); // Use executeUpdate for INSERT, not execute
            return task;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<todoList> displayAllTasks() {
        List<todoList> tasks = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SELECT_ALL_TASKS);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int index = rs.getInt("index");
                String task = rs.getString("taskname"); // Ensure column name matches your database schema
                LocalDate dueDate = rs.getDate("duedate").toLocalDate();
                String tags = rs.getString("tags");
                todoList list = new todoList(index, task, dueDate, tags);
                tasks.add(list);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public int deleteTask(int id) {
        try (PreparedStatement ps = connection.prepareStatement(DELETE_TASK)) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
