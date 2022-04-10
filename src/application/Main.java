package application;

import model.dao.DaoFactory;
import model.dao.SalespersonDao;
import model.entities.Salesperson;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        SalespersonDao salespersonDao = DaoFactory.createSalespersonDao();

        Salesperson salesperson = salespersonDao.findById(2);
        System.out.println(salesperson + "\n");

        List<Salesperson> list = salespersonDao.findByDepartment(4);
        list.forEach(x -> System.out.println(x + "\n"));
    }
}
