package cfg;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
//https://www.baeldung.com/the-persistence-layer-with-spring-and-jpa
@Configuration
@EnableJpaRepositories(basePackages= {"modelo.persistencia"})
@ComponentScan(basePackages = { "modelo" })
@EnableTransactionManagement
public class Configuracion {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/jpa?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		ds.setUsername("root");
		ds.setPassword("password");
		return ds;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean 
		entityManagerFactory(DataSource dataSource, Environment env) {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = 
			new LocalContainerEntityManagerFactoryBean();
		// Metemos el dataSource
		entityManagerFactoryBean.setDataSource(dataSource);
		// Decimos al entity manager que vamos a usar hibernate
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		// Le decimos donde tenemos que ir a buscar las entidades
		entityManagerFactoryBean.setPackagesToScan("modelo.entidades");

		// Configuramos jpa con unas propiedades, que dependen del fabricante
		// en este caso hibernate
		Properties jpaProperties = new Properties();
		// El dialecto son las distintas versiones de los fabricantes al sql estandar
		jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		// IMPORTANTE. Genera automaticamente todo el esquema relacional de datos
		// en nuestra base de datos.
		jpaProperties.put("hibernate.hbm2ddl.auto", "create-drop"); //create-drop update
		// Si queremos mostrar las consultas sql que va a realizar hibernate por nosotros en la consola
		jpaProperties.put("hibernate.show_sql", "true");
		// Si las consultas queremos que tengan formato "pretty"
		jpaProperties.put("hibernate.format_sql", "false");
		entityManagerFactoryBean.setJpaProperties(jpaProperties);

		return entityManagerFactoryBean;
	}
	
	// El objeto que va a gestionar las transacciones por nosotros
	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}
	
}
