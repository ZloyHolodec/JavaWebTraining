package com.holodec.todo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.holodec.models.util.HibernateListener;
import com.holodec.todo.model.ToDo;
import com.opensymphony.xwork2.ActionSupport;

public class ToDoAddAction extends ActionSupport {
	
	private String newDo;
	
	public String execute() {
		SessionFactory factory = HibernateListener.getFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(new ToDo(getNewDo()));
		session.getTransaction().commit();
		
		return SUCCESS;
	}
	
	public void validate() {
		if ("".equals(getNewDo())) {
			addActionError("can't use empty string!");
		} else {
			addActionMessage(getNewDo()+" is added");
		}
	}
	
	public String getNewDo() {
		return newDo;
	}

	public void setNewDo(String newDo) {
		this.newDo = newDo;
	}	
}
