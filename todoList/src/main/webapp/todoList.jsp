<%@page import="java.util.List"%>
<%@page import="com.todoList.dao.todoListDao"%>
<%@page import="com.todoList.dto.todoList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo-List | Abhishek Dwiveid</title>
<style>
    
    h1{
    background-color: blue;
    justify-content: space-around;
    }
    p{
    	background-color: blue;
    justify-content: space-around;
    }
    table {
        border-collapse: collapse;
        width: 100%;
    }
    th, td {
        border: 1px solid black;
        padding: 8px;
        text-align: left;
    }
    th {
        background-color: #f2f2f2;
        
    }
    
</style>
</head>
<body>
	<div>
    <h1>ToDo App</h1>
    <p>Advanced version with filters</p>
    
    </div>
    
    
    <!-- Example form for adding a task -->
    <form action="addTaskServlet" method="post">

        <textarea rows="5" cols="204" name="taskname" placeholder="Task"></textarea><br>
        <input type="number" name="index" placeholder="Enter task-index">
        <input type="date" name="duedate" style="width: 250px">
        <input type="text" name="tags" placeholder="Enter comma separated tags" style="width: 250px;margin:5px">
      	<button style="background-color: green; color: white" ><a href = "addTaskServlet" style="text-decoration: none;color: white">Add</a></button>
    </form>

    <%
        todoListDao listDao = new todoListDao();
        List<todoList> tasks = listDao.displayAllTasks();
    %>
    
    <table>
        <tr>
            <th>Index</th>
            <th>TaskName</th>
            <th>DueDate</th>
            <th>Tags</th>
            <th>Action</th>
        </tr>
        <% for (todoList task : tasks) { %>
        <tr>
        	
            <td><%= task.getIndex() %></td>
            <td><%= task.getTask() %></td>
            <td><%= task.getDuedate() %></td>
            <td><%= task.getTags() %></td>
            <td><a href="deleteTask?id=<%= task.getIndex() %>" style="background-color:blue; color: white; text-decoration: none">Completed</a></td>
            
        </tr>
        <% } %>
    </table>

</body>
</html>
