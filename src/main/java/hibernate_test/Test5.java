package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test5 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

//            Employee employee = session.get(Employee.class, 1);
//            session.delete(employee);          //удаление объекта из БД по id

            session.createQuery("delete Employee " +
                    "where name= 'Alexander'").executeUpdate();     //удаление из БД по параметрам


            session.getTransaction().commit();

        }finally {
            factory.close();
        }
    }
}
