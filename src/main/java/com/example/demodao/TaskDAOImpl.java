package com.example.demodao;

import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDAOImpl implements TaskDAO
{
    private Connection conn;

    public TaskDAOImpl()
    {
        try
        {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:~/test", "11", "11");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS TASK (" +
                    "id INTEGER PRIMARY KEY AUTO_INCREMENT," +
                    "name VARCHAR(255)," +
                    "content VARCHAR(255)," +
                    "lvl_education VARCHAR(255)," +
                    "field_of_study VARCHAR(255)," +
                    "gender VARCHAR(255))");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Task> getAllTasks()
    {
        List<Task> tasks = new ArrayList<>();
        try
        {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM TASK");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Task task = new Task(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("content"),
                        rs.getString("lvl_education"),
                        rs.getString("field_of_study"),
                        rs.getString("gender"));
                tasks.add(task);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return tasks;
    }

    @Override
    public Task getTaskById(int id)
    {
        Task task = null;
        try
        {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM task WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                task = new Task(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("content"),
                        rs.getString("lvl_education"),
                        rs.getString("field_of_study"),
                        rs.getString("gender"));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return task;
    }

    @Override
    public void addTask(Task task)
    {
        try
        {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO task (name, content, lvl_education, field_of_study, gender) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, task.getName());
            ps.setString(2, task.getContent());
            ps.setString(3, task.getLvl_education());
            ps.setString(4, task.getField_of_study());
            ps.setString(5, task.getGender());
            ps.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTask(Task task)
    {
        try
        {
            PreparedStatement ps = conn.prepareStatement("UPDATE task SET name=?, content=?, lvl_education=?, field_of_study=?, gender=? WHERE id = ?");
            ps.setString(1, task.getName());
            ps.setString(2, task.getContent());
            ps.setString(3, task.getLvl_education());
            ps.setString(4, task.getField_of_study());
            ps.setString(5, task.getGender());
            ps.setInt(6,task.getId());
            ps.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTask(int id)
    {
        try
        {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM task WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
