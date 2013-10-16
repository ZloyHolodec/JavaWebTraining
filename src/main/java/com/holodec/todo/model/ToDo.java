package com.holodec.todo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class ToDo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer toDoId;
	
	private String text;
	
	public ToDo() {
	
	}
	
	public ToDo(String text) {
		this.text = text;
	}
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TODO_ID", unique=true, nullable=false)
	public Integer getToDoId() {
		return toDoId;
	}

	public void setToDoId(Integer toDoId) {
		this.toDoId = toDoId;
	}

	@Column(name = "TODO_TEXT", nullable=false)
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
