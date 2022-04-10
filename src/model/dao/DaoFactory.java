package model.dao;

import db.DB;
import model.dao.implementation.SalespersonDaoJDBC;

public class DaoFactory {
    public static SalespersonDao createSalespersonDao() {
        return new SalespersonDaoJDBC(DB.getConnection());
    }

}
