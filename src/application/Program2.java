package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;

public class Program2 {

    public static void main(String[] args) {
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

//        Department department = new Department(6, "Science and Arts");
//        departmentDao.insert(department);
//        departmentDao.deleteById(8);
//        departmentDao.update(department);

//        Department d = departmentDao.findById(3);
//        System.out.println(d);

        List<Department> list = departmentDao.findAll();
        list.forEach(x -> System.out.println(x));
    }
}
