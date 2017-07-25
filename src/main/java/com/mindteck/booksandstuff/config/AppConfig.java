package com.mindteck.booksandstuff.config;

import com.mindteck.booksandstuff.enitities.Category;
import com.mindteck.booksandstuff.enitities.Item;
import com.mindteck.booksandstuff.enitities.book.Author;
import com.mindteck.booksandstuff.enitities.book.Book;
import com.mindteck.booksandstuff.enitities.book.Genre;
import com.mindteck.booksandstuff.enitities.book.Publisher;
import com.mindteck.booksandstuff.enitities.cd.Artist;
import com.mindteck.booksandstuff.enitities.cd.CD;
import com.mindteck.booksandstuff.enitities.cd.MusicGenre;
import com.mindteck.booksandstuff.enitities.cd.Producer;
import com.mindteck.booksandstuff.enitities.user.Role;
import com.mindteck.booksandstuff.enitities.user.User;
import com.mindteck.booksandstuff.enitities.user.Wish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

import static org.hibernate.cfg.AvailableSettings.*;
import static org.hibernate.cfg.AvailableSettings.C3P0_MAX_STATEMENTS;

/**
 * Created by Philip Lozada on 7/24/2017.
 */
@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("com.mindteck.booksandstuff.dao"),
		@ComponentScan("com.mindteck.booksandstuff.dao.impl"),
		@ComponentScan("com.mindteck.booksandstuff.service"),
		@ComponentScan("com.mindteck.booksandstuff.service.impl") })
public class AppConfig {
	@Autowired
	private Environment env;

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

		Properties props = new Properties();
		// Setting JDBC properties
		props.put(DRIVER, env.getProperty("mysql.driver"));
		props.put(URL, env.getProperty("mysql.url"));
		props.put(USER, env.getProperty("mysql.user"));
		props.put(PASS, env.getProperty("mysql.password"));

		// Setting Hibernate properties
		props.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
		props.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));

		// Setting C3P0 properties
		props.put(C3P0_MIN_SIZE,
				env.getProperty("hibernate.c3p0.min_size"));
		props.put(C3P0_MAX_SIZE,
				env.getProperty("hibernate.c3p0.max_size"));
		props.put(C3P0_ACQUIRE_INCREMENT,
				env.getProperty("hibernate.c3p0.acquire_increment"));
		props.put(C3P0_TIMEOUT,
				env.getProperty("hibernate.c3p0.timeout"));
		props.put(C3P0_MAX_STATEMENTS,
				env.getProperty("hibernate.c3p0.max_statements"));

		factoryBean.setHibernateProperties(props);
		factoryBean.setAnnotatedClasses(
				 User.class, Role.class, Wish.class, Item.class, Category.class,
				Book.class, Author.class, Genre.class, Publisher.class,
				CD.class, Artist.class, MusicGenre.class, Producer.class);
		// factoryBean.setAnnotatedClasses(Role.class);
		return factoryBean;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}


}