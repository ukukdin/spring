package database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MemorydbApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(MemorydbApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
