package model.dao;

import model.entities.Salesperson;

import java.util.List;

public interface SalespersonDao {
    void insert(Salesperson salesperson);

    void update(Salesperson salesperson);

    void deleteById(Integer id);

    Salesperson findById(Integer id);

    List<Salesperson> findAll();
}
