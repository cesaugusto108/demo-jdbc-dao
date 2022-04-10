package application;

import model.entities.Department;
import model.entities.Salesperson;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Department department = new Department(7, "Auto");
        System.out.println(department);

        Salesperson salesperson = new Salesperson(
                1,
                "Joseph Smith",
                "joseph@email.com",
                new Date(simpleDateFormat.parse("01/01/1988").getTime()),
                3000.00,
                7,
                department);
        System.out.println(salesperson);
    }
}
