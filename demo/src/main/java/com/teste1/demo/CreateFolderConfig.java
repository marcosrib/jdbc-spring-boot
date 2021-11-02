package com.teste1.demo;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CreateFolderConfig {
	
  
    
    @Bean
	public void createFolder() {
    	File newDirectory = new File(System.getProperty("user.home"), "/logs");
		if (!newDirectory.exists()) {
			newDirectory.mkdir();
		}
	}
    
}