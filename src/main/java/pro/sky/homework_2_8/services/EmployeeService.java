package pro.sky.homework_2_8.services;

import pro.sky.homework_2_8.models.Employee;

import java.util.Collections;

public interface EmployeeService {

    String add(String firstName, String lastName);

    String find(String firstName, String lastName);

    String findAll();

    String remove(String firstName, String lastName);

}