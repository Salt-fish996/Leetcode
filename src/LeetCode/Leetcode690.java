package src.LeetCode;

import java.util.List;

public class Leetcode690 {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
    public int getImportance(List<Employee> employees, int id) {
        for (int i = 0; i < employees.size(); i++) {
            int count = employees.get(i).importance;
            if (employees.get(i).id == id) {
                List<Integer> subordinates = employees.get(i).subordinates;
                for (int j = 0; j < subordinates.size(); j++) {
                    count += getImportance(employees,subordinates.get(j));
                }
                return count;
            }
        }
        return 0;
    }
}
