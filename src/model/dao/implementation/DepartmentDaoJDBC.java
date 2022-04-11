package model.dao.implementation;

import model.dao.DepartmentDao;
import model.entities.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {
    private final Connection CONNECTION;

    public DepartmentDaoJDBC(Connection CONNECTION) {
        this.CONNECTION = CONNECTION;
    }

    @Override
    public void insert(Department department) {

    }

    @Override
    public void update(Department department) {

    }

    @Override
    public void deleteById(Integer id) {
        try (PreparedStatement preparedStatement = CONNECTION.prepareStatement("""
                DELETE FROM department
                WHERE Id = ?""")){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Department findById(Integer id) {
        return null;
    }

    @Override
    public List<Department> findAll() {
        return null;
    }
}
