package com.ml.test.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.ml.test.entities.User;

public class DatabaseConfiguration {

    private static SessionFactory factory;

    private DatabaseConfiguration() {
        // private constructor.
    }

    static {
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
        properties.put(Environment.URL, "jdbc:mysql://localhost:3305/newdb");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "Him@1992");
        properties.put(Environment.HBM2DDL_AUTO, "create");
        properties.put(Environment.SHOW_SQL, true);
        properties.put(Environment.POOL_SIZE, "100");
        properties.put(Environment.FORMAT_SQL, true);

        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .applySettings(properties)
                .build();

        Configuration cfg = new Configuration()
        		.addAnnotatedClass(User.class);

        try {
            factory = cfg.buildSessionFactory(standardRegistry);
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(standardRegistry);
        }
    }

    public static SessionFactory getSessionFactory() {
        return factory;
    }
}