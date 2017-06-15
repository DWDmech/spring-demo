package org.home.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	private Client client;
	private EventLogger log;
	private static ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
//	private static ConfigurableApplicationContext ctx0 = new ClassPathXmlApplicationContext("logger.xml");
//	private static ConfigurableApplicationContext ctx1 = new ClassPathXmlApplicationContext(new String[]{"other.xml"}, ctx0);
	
    public static void main( String[] args ) {
//    	@SuppressWarnings("resource")
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    	
    	
    	
    	App app = (App) ctx.getBean("app");
    	
    	app.logEvent("asdasd asd 1");
    	app.logEvent("asdasd asd 2");
    	
    	ctx.close();
    }
    
    public App() {
	}
    
    public App(Client client, EventLogger log) {
		this.client = client;
		this.log = log;
	}

	public void logEvent(String msg) {
    	String mss = msg.replaceAll(client.getId(), client.getFillName());
    	log.logEvent((Event) ctx.getBean("event"));
    }
}
