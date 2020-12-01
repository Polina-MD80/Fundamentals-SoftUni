import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public
class StudentMain {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String line = scanner.nextLine ();

        List<Student>students = new ArrayList<> ();

        while (!line.equals ("end")){
            String[] parts= line.split (" ");
            String firstName = parts[0];
            String secondName = parts[1];
            int ade = Integer.parseInt (parts[2]);
            String city = parts[3];
            Student student = new Student(firstName, secondName, ade, city);

            students.add (student);

            line = scanner.nextLine ();
        }
        //students.sort(Comparator.comparing(Student::getFirstName));

        String city = scanner.nextLine ();
        for (Student student : students) {
            if (city.equals (student.getCity())){
                System.out.printf ("%s %s is %d years old%n", student.getFirstName (),
                        student.getSecondName (),student.getAge ());
            }

        }

    }
}
