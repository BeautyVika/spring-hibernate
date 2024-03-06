package hibernate_one_to_one;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;
        try {
//            session = factory.getCurrentSession();
//            Employee emp = new Employee("Nikolay", "Smornov", "Sales", 700);
//            Detail det = new Detail("Piter", "4342324378", "nik@gmail.com");
//            emp.setEmpDetail(det); //обязательно в два связанных объекта сетаем
//            det.setEmployee(emp);
//
//            session.beginTransaction();
//            session.persist(det);
//            session.getTransaction().commit();
            session = factory.getCurrentSession();

            session.beginTransaction();
            Detail detail = session.get(Detail.class, 1);
            System.out.println(detail.getEmployee());

            session.getTransaction().commit();

        }finally {
            session.close();
            factory.close();
        }
    }
}
