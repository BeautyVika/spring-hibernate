package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

//            List<Employee> employees = session.createQuery("from Employee").getResultList();  //получение всех работников из БД
            // пишем имя класса, не название таблицы

            List<Employee> employees = session.createQuery("from Employee "
                    + "where name='Alexander' AND salary>650").getResultList();
            //получение работников из Бд по имени, HQL, name это название поля в конструкторе

            for(Employee emp: employees) {
                System.out.println(emp);
            }

            session.getTransaction().commit();

        }finally {
            factory.close();
        }
    }
}
