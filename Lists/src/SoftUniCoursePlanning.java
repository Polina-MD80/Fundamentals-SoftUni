import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public
class SoftUniCoursePlanning {
    public static
    void main (String[] args) {
        Scanner      scanner = new Scanner (System.in);
        String[]     input   = scanner.nextLine ().split (", ");
        List<String> program = new ArrayList<> (Arrays.asList (input));

        String command = scanner.nextLine ();

        while (!"course start".equals (command)) {
            String[] tokens      = command.split (":");
            String   lessonTitle = tokens[1];
            switch (tokens[0]) {
                case "Add":
                    if (!program.contains (lessonTitle)) {
                        program.add (lessonTitle);
                    }
                    break;
                case "Insert":
                    if (!program.contains (lessonTitle)) {
                        int index = Integer.parseInt (tokens[2]);
                        if (index >= 0 && index <= program.size ()) {
                            program.add (index, lessonTitle);
                        }
                    }
                    break;
                case "Remove":
                    program.remove (lessonTitle);
                    program.remove (lessonTitle + "-Exercise");
                    break;
                case "Swap":
                    String secondLessonTitle = tokens[2];
                    if (program.contains (lessonTitle) && program.contains (secondLessonTitle)) {
                        int indexOfLesson1 = program.indexOf (lessonTitle);
                        int indexOfLesson2 = program.indexOf (secondLessonTitle);
                        program.set (indexOfLesson1, secondLessonTitle);
                        program.set (indexOfLesson2, lessonTitle);
                        if (program.contains (lessonTitle + "-Exercise")) {
                            program.remove (lessonTitle + "-Exercise");
                            program.add (program.indexOf (lessonTitle) + 1, lessonTitle + "-Exercise");
                        }
                        if (program.contains (secondLessonTitle + "-Exercise")) {
                            program.remove (secondLessonTitle + "-Exercise");
                            program.add (program.indexOf (secondLessonTitle) + 1, secondLessonTitle + "-Exercise");
                        }
                    }
                    break;
                case "Exercise":
                    if (!program.contains (lessonTitle)) {
                        program.add (lessonTitle);
                    }
                    int indexForExercise = program.indexOf (lessonTitle) + 1;
                    String exerciseInput = String.format ("%s-Exercise", lessonTitle);
                    if (!program.contains (exerciseInput)) {
                        program.add (indexForExercise, exerciseInput);
                    }
                    break;
            }

            command = scanner.nextLine ();
        }
        for (int i = 0; i < program.size (); i++) {
            System.out.println (i + 1 + "." + program.get (i));
        }
    }
}
