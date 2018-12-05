package com.netcracker.travel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan("com.netcracker.travel")
//@EntityScan("com.netcracker.travel.entity")
//@EnableJpaRepositories(basePackages = "com.netcracker.travel.repository", entityManagerFactoryRef = "entityManagerFactory")
public class Main implements CommandLineRunner {
    private static Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    public void run(String... args) throws Exception {
        LOG.info("EXECUTING : command line runner");

        Menu.chooseAction();

        for (int i = 0; i < args.length; ++i) {
            LOG.info("args[{}]: {}", i, args[i]);
        }
    }
}
