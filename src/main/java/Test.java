import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ml.test.config.DatabaseConfiguration;
import com.ml.test.entities.User;

public class Test {

	public static void main(String[] args) {
		User u = new User();
		u.setName("Himanshu");
		u.setEmail("email");
		u.setPhone("123456");
		System.out.println(u);
		SessionFactory sf = DatabaseConfiguration.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(u);
		tx.commit();
		session.close();
	}

}
