package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test4 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

//            Employee employee = session.get(Employee.class, 1); //изменение данных по id
//            employee.setSalary(1500);

            session.createQuery("update Employee set salary=1000 " +
                    "where name='Alexander'").executeUpdate();
            //изменение данных в БД по условию

            session.getTransaction().commit();

        }finally {
            factory.close();
        }
    }
}
