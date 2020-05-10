package com.example.nz_telegram_bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
@EnableScheduling
public class NzTelegramBotApplication {

	public static void main(String[] args) {
		System.getProperties().put( "proxySet", "true" );
		System.getProperties().put( "socksProxyHost", "127.0.0.1" );
		System.getProperties().put( "socksProxyPort", "9150" );
		ApiContextInitializer.init();
		SpringApplication.run(NzTelegramBotApplication.class, args);
	}
}
