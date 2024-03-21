package pro.sky.homework_2_8.services;

import org.springframework.stereotype.Service;
import pro.sky.homework_2_8.exceptions.EmployeeAlreadyAddedException;
import pro.sky.homework_2_8.exceptions.EmployeeNotFoundException;
import pro.sky.homework_2_8.models.Employee;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    //                                                      Домашнее задание 2-8. Коллекции: многообразие реализаций
    Map<String, Employee> employeeBook = new HashMap<>();

    public String add(String firstName, String lastName) {

        Employee e = new Employee(firstName, lastName);

        if (employeeBook.containsKey(e.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        } else {
            employeeBook.put(e.getFullName(), e);
            return "Сотрудник " + firstName + " " + lastName + " добавлен";
        }
    }

    public String remove(String firstName, String lastName) {

        Employee e = new Employee(firstName, lastName);

        if (!employeeBook.containsKey(e.getFullName())) {
            throw new EmployeeNotFoundException();
        } else {
            employeeBook.remove(e.getFullName(), e);
            return "Сотрудник " + firstName + " " + lastName + " удален";
        }
    }

    public String find(String firstName, String lastName) {

        Employee e = new Employee(firstName, lastName);

        if (!employeeBook.containsKey(e.getFullName())) {
            throw new EmployeeNotFoundException();
        } else {
            return "Сотрудник " + firstName + " " + lastName + " найден";
        }
    }

    public String findAll() {

        if (employeeBook.values().isEmpty()) {
            throw new EmployeeNotFoundException();
        } else {
            return Arrays.toString(employeeBook.keySet().toArray());
        }
    }

}