package com.todoList.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import com.todoList.dao.todoListDao;
import com.todoList.dto.todoList;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

class ToDoInsertController implements Servlet{

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		todoListDao dao = new todoListDao();
//		PrintWriter pw = res.getWriter();
		
		int id = Integer.parseInt(req.getParameter("index"));
		String task =  req.getParameter("taskname");
		LocalDate duedate = LocalDate.parse(req.getParameter("duedate"));
		String tags = req.getParameter("tags");
		
		todoList dto = new todoList(id, task, duedate, tags);
		dao.addTask(dto);
		
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
