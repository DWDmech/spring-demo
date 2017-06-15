package org.home.core;

import org.springframework.jdbc.core.JdbcTemplate;

public class DBLogger implements EventLogger {
	JdbcTemplate template;

	public void logEvent(Event e) {
		template.queryForObject("", Integer.class);
	}

	public DBLogger(JdbcTemplate template) {
		this.template = template;
	}
	
	
}
