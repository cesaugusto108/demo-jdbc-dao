package application;

import model.dao.DaoFactory;
import model.dao.SalespersonDao;
import model.entities.Salesperson;

public class Main {

    public static void main(String[] args) {
        SalespersonDao salespersonDao = DaoFactory.createSalespersonDao();

        Salesperson salesperson = salespersonDao.findById(1);

        System.out.println(salesperson);
    }
}
