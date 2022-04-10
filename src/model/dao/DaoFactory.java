package model.dao;

import model.dao.implementation.SalespersonDaoJDBC;

public class DaoFactory {
    public static SalespersonDao createSalespersonDao() {
        return new SalespersonDaoJDBC();
    }

}
