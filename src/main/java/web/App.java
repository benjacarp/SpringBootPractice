package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) throws Exception {
        initRepo();
        SpringApplication.run(App.class, args);
    }

    private static void initRepo() {

    }
}
