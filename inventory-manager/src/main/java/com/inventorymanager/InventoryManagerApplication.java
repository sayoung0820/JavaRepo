package com.inventorymanager;
import com.inventorymanager.model.InventoryItem;
import com.inventorymanager.repository.InMemoryInventoryRepository;
import com.inventorymanager.repository.InventoryRepository;
import com.inventorymanager.view.Inventory;
import com.inventorymanager.view.Kiosk;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import java.util.List;

@SpringBootApplication
public class InventoryManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryManagerApplication.class, args);
	}

	@Component
	public static class AppRunner implements CommandLineRunner {

		@Value("${app.mode:admin}")
		private String appMode;

		private final Inventory inventoryView;
		private final Kiosk kioskView;

		public AppRunner(Inventory inventoryView, Kiosk kioskView) {
			this.inventoryView = inventoryView;
			this.kioskView = kioskView;
		}

		@Override
		public void run(String... args) {
			if (appMode.equalsIgnoreCase("admin")) {
				inventoryView.run();
			} else if (appMode.equalsIgnoreCase("kiosk")) {
				kioskView.run();
			} else {
				System.out.println("Invalid mode in application.properties. Use 'admin' or 'kiosk'.");
			}
		}
	}
}



