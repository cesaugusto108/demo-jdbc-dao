package application;

import model.dao.DaoFactory;
import model.dao.SalespersonDao;
import model.entities.Department;
import model.entities.Salesperson;

import java.text.ParseException;
import java.util.Scanner;

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

//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        Department department = new Department(3, "Fashion");
//        Salesperson salesperson = new Salesperson(null,
//                "Lisa Yellow",
//                "lisa@email.com",
//                new Date(simpleDateFormat.parse("21/09/2001").getTime()),
//                1150.00, department.getId(),
//                department);
//
//        salespersonDao.insert(salesperson);
//        Salesperson salesperson = salespersonDao.findById(7);
//        salesperson.setDepartment(new Department(3, "Fashion"));
//        salesperson.setBaseSalary(3200.00);
//        salespersonDao.update(salesperson);

        try (Scanner scn = new Scanner(System.in)){
            System.out.print("Enter Id: ");
            int id = scn.nextInt();

            salespersonDao.deleteById(id);
        }
    }
}
