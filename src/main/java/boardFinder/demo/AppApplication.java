package boardFinder.demo;

import boardFinder.demo.service.DBDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppApplication implements ApplicationRunner{
    
            @Autowired
            private DBDataService dBDataService;

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}
        
        @Override
        public void run(ApplicationArguments arg) throws Exception {
           dBDataService.createTestData();         
        }

}
