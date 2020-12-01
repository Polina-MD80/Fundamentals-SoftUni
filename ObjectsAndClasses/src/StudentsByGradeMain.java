import java.util.*;

public
class StudentsByGradeMain {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int n = Integer.parseInt (scanner.nextLine ());
        List<StudentByGrade> students = new ArrayList<> ();

        for (int i = 0; i <n ; i++) {
            String[] tokens = scanner.nextLine ().split (" ");
            String firstName = tokens[0];
            String lastName = tokens[1];
            double grade = Double.parseDouble (tokens[2]);

            StudentByGrade student = new StudentByGrade (firstName,lastName,grade);
            students.add (student);

        }
        students.sort (Comparator.comparingDouble (StudentByGrade::getGrade));
        Collections.reverse (students);

        for (StudentByGrade student : students) {
            System.out.println (student);

        }
    }
}
