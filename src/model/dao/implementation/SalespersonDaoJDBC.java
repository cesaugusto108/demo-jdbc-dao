package model.dao.implementation;

import db.DBException;
import model.dao.SalespersonDao;
import model.entities.Department;
import model.entities.Salesperson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SalespersonDaoJDBC implements SalespersonDao {

    private final Connection CONNECTION;

    public SalespersonDaoJDBC(Connection CONNECTION) {
        this.CONNECTION = CONNECTION;
    }

    @Override
    public void insert(Salesperson salesperson) {

    }

    @Override
    public void update(Salesperson salesperson) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Salesperson findById(Integer id) {
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = CONNECTION
                .prepareStatement("SELECT salesperson.*, department.Name as DepName\n" +
                        "FROM salesperson INNER JOIN department\n" +
                        "ON salesperson.DepartmentId = department.Id\n" +
                        "WHERE salesperson.Id = ?")) {

            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                Department department = new Department();
                department.setId(resultSet.getInt("DepartmentId"));
                department.setName(resultSet.getString("DepName"));

                Salesperson salesperson = new Salesperson();
                salesperson.setId(resultSet.getInt("Id"));
                salesperson.setName(resultSet.getString("Name"));
                salesperson.setEmail(resultSet.getString("Email"));
                salesperson.setBirthDate(resultSet.getDate("BirthDate"));
                salesperson.setBaseSalary(resultSet.getDouble("BaseSalary"));
                salesperson.setDepartment(department);

                return salesperson;
            }
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    @Override
    public List<Salesperson> findAll() {
        return null;
    }
}
