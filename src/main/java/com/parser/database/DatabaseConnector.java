package com.parser.database;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.File;

public class DatabaseConnector {
    public static SessionFactory sessionFactory;

    public static void connect() {
        if(sessionFactory == null) {
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure(new File("./hibernate.cfg.xml"))
                    .build();

            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
    }
}
