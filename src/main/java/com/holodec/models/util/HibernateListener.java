package com.holodec.models.util;

import java.net.URL;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class HibernateListener implements ServletContextListener {

	private Configuration configuration;
	private SessionFactory factory;
	private ServiceRegistry registry;
	private String path = "/hibernate.cfg.xml";
	
	private static Class<HibernateListener> clazz = HibernateListener.class;
	public static final String KEY_NAME = clazz.getName();
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		try {
			URL url = HibernateListener.class.getResource(path);
			configuration = new Configuration().configure(url);
			registry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
			factory = configuration.buildSessionFactory(registry);	
			
			event.getServletContext().setAttribute(KEY_NAME, factory);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static SessionFactory getFactory() {
		return (SessionFactory) ServletActionContext.getServletContext().getAttribute(KEY_NAME);
	}
	
	public static Session openSession() {
		return getFactory().openSession();
	}
}
