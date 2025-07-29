package com.revature.collectionDemo;

import java.util.Comparator;

public class EmpIdComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return Integer.compare(e1.getEmp_id(), e2.getEmp_id());
    }
}
