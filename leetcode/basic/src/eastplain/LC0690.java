package eastplain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author EastPlain
 * @create 2021-4-13 16:41
 */

public class LC0690 {

    public static void main(String[] args) {

        Employee e1 = new Employee();
        e1.id = 1;
        e1.importance = 5;
        List<Integer> l1 = new ArrayList<>();
        l1.add(2);
        l1.add(3);
        e1.subordinates = l1;

        Employee e2 = new Employee();
        e2.id = 2;
        e2.importance = 3;
        e2.subordinates = new ArrayList<>();

        Employee e3 = new Employee();
        e3.id = 3;
        e3.importance = 3;
        e3.subordinates = new ArrayList<>();

        List<Employee> es = new ArrayList<>();
        es.add(e1);
        es.add(e2);
        es.add(e3);

        System.out.println(new GetImportance().getImportance(es, 1));
    }
}


class GetImportance {

    public int getImportance(List<Employee> employees, int id) {

        Map<Integer, Employee> e_map = new HashMap<>();
        for (Employee employee : employees) {
            e_map.put(employee.id, employee);
        }

        Employee employee = e_map.get(id);

        if (employee.subordinates.size() == 0) {
            return employee.importance;
        }

        int im = employee.importance;
        for (int sub_id : e_map.get(id).subordinates) {
            im += getImportance(employees, sub_id);
        }

        return im;
    }


}


class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", importance=" + importance +
                ", subordinates=" + subordinates +
                '}';
    }
}
