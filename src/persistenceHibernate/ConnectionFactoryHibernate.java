package persistenceHibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class ConnectionFactoryHibernate {
	
	private SessionFactory sessionFactory;
	private static ConnectionFactoryHibernate instance;
	
	private ConnectionFactoryHibernate() {
		
	}
	
	public static ConnectionFactoryHibernate getInstance() {
		if(instance == null) {
			instance = new ConnectionFactoryHibernate();
		}
		return instance;
	}
	
	public void setup() {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
										.configure()
										.loadProperties("hibernate.cfg.xml")
										.build();
		sessionFactory = new Configuration().buildSessionFactory(registry);
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void shutdown() {
		sessionFactory.close();
	}
}
