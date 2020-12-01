import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public
class Student2Main {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String  line    = scanner.nextLine ();

        List<Student> students = new ArrayList<> ();

        while (!line.equals ("end")) {
            String[] parts      = line.split (" ");
            String   firstName  = parts[0];
            String   secondName = parts[1];
            int      age        = Integer.parseInt (parts[2]);
            String   city       = parts[3];

            if (isStudentExisting (students, firstName, secondName)) {
                Student student = getStudent (students, firstName, secondName);
                student.setFirstName (firstName);
                student.setSecondName (secondName);
                student.setAge (age);
                student.setCity (city);

            } else {
                Student student = new Student (firstName, secondName, age, city);
                students.add (student);
            }

            line = scanner.nextLine ();
        }
        String city = scanner.nextLine ();
        for (Student student : students) {
            if (city.equals (student.getCity ())) {
                System.out.printf ("%s %s is %d years old%n", student.getFirstName (),
                        student.getSecondName (), student.getAge ());
            }

        }
    }

    private static
    Student getStudent (List<Student> students, String firstName, String secondName) {
        Student existingStud = null;
        for (Student student : students) {
            if (student.getFirstName ().equals (firstName) && student.getSecondName ().equals (secondName)) {
                existingStud = student;
            }
        }
        return existingStud;
    }

        private static
        boolean isStudentExisting (List < Student > students, String firstName, String secondName){
            for (Student student : students) {
                if (firstName.equals (student.getFirstName ()) && secondName.equals (student.getSecondName ())) {
                    return true;
                }
            }
            return false;
        }
    }


