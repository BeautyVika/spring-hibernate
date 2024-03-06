package hibernate_one_to_many_bi;

import hibernate_one_to_many_bi.entity.Department;
import hibernate_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();

            session.beginTransaction();
            Employee emp = session.get(Employee.class, 1);
            session.delete(emp);

            session.getTransaction().commit();

//            session = factory.getCurrentSession();
//
//            Department dep = new Department("IT", 300, 1200);
//            Employee emp1 = new Employee("Helena", "Smornova", 600);
//            Employee emp2 = new Employee("Vika", "Ivanova", 800);
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//
//            session.beginTransaction();
//            session.persist(dep);
//
//            session.getTransaction().commit();



//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//            Department dep = session.get(Department.class, 1);
//            System.out.println(dep);
//            System.out.println(dep.getListEmployee()); //получение работника по id
//
//            session.getTransaction().commit();

        }finally {
            session.close();
            factory.close();
        }
    }
}

