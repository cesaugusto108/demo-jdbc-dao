package model.dao.implementation;

import db.DBException;
import model.dao.SalespersonDao;
import model.entities.Department;
import model.entities.Salesperson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                .prepareStatement("""
                        SELECT salesperson.*, department.Name as DepName
                        FROM salesperson INNER JOIN department
                        ON salesperson.DepartmentId = department.Id
                        WHERE salesperson.Id = ?""")) {

            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                Department department = instantiateDepartment(resultSet);

                return instantiateSalesperson(resultSet, department);
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
    public List<Salesperson> findByDepartment(Department department) {
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = CONNECTION
                .prepareStatement("""
                        SELECT salesperson.*, department.name as DepName
                        FROM salesperson INNER JOIN department
                        ON salesperson.DepartmentId = department.Id
                        WHERE departmentId = ?
                        ORDER by name""")){

            preparedStatement.setInt(1, department.getId());
            resultSet = preparedStatement.executeQuery();

            List<Salesperson> salespersonList = new ArrayList<>();
            Map<Integer, Department> departmentMap = new HashMap<>();

            while (resultSet.next()) {
                Department dep = departmentMap.get(resultSet.getInt("DepartmentId"));
                if (dep == null) {
                    dep = instantiateDepartment(resultSet);
                    departmentMap.put(resultSet.getInt("DepartmentId"), dep);
                }

                Salesperson salesperson = instantiateSalesperson(resultSet, dep);
                salespersonList.add(salesperson);
            }
            return salespersonList;

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
    }

    private Salesperson instantiateSalesperson(ResultSet resultSet, Department department) throws SQLException {
        Salesperson salesperson = new Salesperson();
        salesperson.setId(resultSet.getInt("Id"));
        salesperson.setName(resultSet.getString("Name"));
        salesperson.setEmail(resultSet.getString("Email"));
        salesperson.setBirthDate(resultSet.getDate("BirthDate"));
        salesperson.setBaseSalary(resultSet.getDouble("BaseSalary"));
        salesperson.setDepartment(department);

        return salesperson;
    }

    private Department instantiateDepartment(ResultSet resultSet) throws SQLException {
        Department department = new Department();
        department.setId(resultSet.getInt("DepartmentId"));
        department.setName(resultSet.getString("DepName"));

        return department;
    }

    @Override
    public List<Salesperson> findAll() {
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = CONNECTION
                .prepareStatement("""
                        SELECT salesperson.*, department.name as DepName
                        FROM salesperson INNER JOIN department
                        ON salesperson.DepartmentId = department.Id
                        ORDER by name""")){

            resultSet = preparedStatement.executeQuery();

            List<Salesperson> salespersonList = new ArrayList<>();
            Map<Integer, Department> departmentMap = new HashMap<>();

            while (resultSet.next()) {
                Department dep = departmentMap.get(resultSet.getInt("DepartmentId"));
                if (dep == null) {
                    dep = instantiateDepartment(resultSet);
                    departmentMap.put(resultSet.getInt("DepartmentId"), dep);
                }

                Salesperson salesperson = instantiateSalesperson(resultSet, dep);
                salespersonList.add(salesperson);
            }
            return salespersonList;

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

    }
}
