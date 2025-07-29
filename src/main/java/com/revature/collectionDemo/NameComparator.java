package com.revature.collectionDemo;

import java.util.Comparator;

public class NameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getEmp_name().compareTo(e2.getEmp_name() );
    }
}
