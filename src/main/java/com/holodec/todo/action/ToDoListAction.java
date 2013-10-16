package com.holodec.todo.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.holodec.models.util.HibernateListener;
import com.holodec.todo.model.ToDo;
import com.opensymphony.xwork2.ActionSupport;

public class ToDoListAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	String err;
	
	public ToDoListAction() {
		
	}
	
	public List<ToDo> getSomeItems() {
	 	SessionFactory factory = HibernateListener.getFactory();
	 	Session session = factory.openSession();
	 	session.beginTransaction();
	 	return session.createQuery("from ToDo").list();
	}
	
	public String execute() {		
		return SUCCESS;
	}

	public String getErr() {
		return err;
	}

	public void setErr(String err) {
		this.err = err;
	}
}
