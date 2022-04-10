package application;

import model.dao.DaoFactory;
import model.dao.SalespersonDao;
import model.entities.Department;
import model.entities.Salesperson;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParseException {
        SalespersonDao salespersonDao = DaoFactory.createSalespersonDao();

//        Salesperson salesperson = salespersonDao.findById(2);
//        System.out.println(salesperson + "\n");
//
//        List<Salesperson> list = salespersonDao.findByDepartment(new Department(2, null));
//        list.forEach(x -> System.out.println(x + "\n"));

//        List<Salesperson> listAll = salespersonDao.findAll();
//        listAll.forEach(x -> System.out.println(x + "\n"));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Department department = new Department(3, "Fashion");
        Salesperson salesperson = new Salesperson(null,
                "Lisa Yellow",
                "lisa@email.com",
                new Date(simpleDateFormat.parse("21/09/2001").getTime()),
                1150.00, department.getId(),
                department);

        salespersonDao.insert(salesperson);
    }
}
