import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public
class CompanyRoster {
    private static class Employee{
        private String name;
        private double salary;
        private String position;
        private String department;
        private String email = "n/a";
        private int age = -1;

        public
        Employee (String name, double salary, String position, String department, String email, int age) {
            this.name = name;
            this.salary = salary;
            this.position = position;
            this.department = department;
            this.email = email;
            this.age = age;
        }

        @Override
        public
        String toString () {
            return String.format ("%s %.2f %s %d",name,salary,email,age);
        }

        public
        String getDepartment () {
            return department;
        }

        public
        double getSalary () {
            return salary;
        }

        public static
        void main (String[] args) {
            Scanner scanner = new Scanner (System.in);
            int n = Integer.parseInt (scanner.nextLine ());
            List<Employee> employees = new ArrayList<> ();
            Map<String,List<Employee>> departments = new HashMap<> ();

            for (int i = 0; i < n; i++) {
                String[] personData = scanner.nextLine ().split (" ");
                String email = "n/a";
                int age = -1;
                if (personData.length>4){
                    if (personData[4].contains ("@")){
                         email = personData[4];
                    }else {
                         age = Integer.parseInt (personData[4]);
                    }if (personData.length==6){
                        age = Integer.parseInt (personData[5]);
                    }
                }
                Employee employee = new Employee (personData[0],Double.parseDouble (personData[1]),
                        personData[2],personData[3],email,age);
                employees.add (employee);

                departments.putIfAbsent (employee.getDepartment (),new ArrayList<> ());
                departments.get (employee.getDepartment ()).add (employee);
            }

        }


    }

/*Highest Average Salary: Sales
    Yovcho 610.13 n/a -1
    Toshko 609.99 toshko@abv.bg 44*/


}
