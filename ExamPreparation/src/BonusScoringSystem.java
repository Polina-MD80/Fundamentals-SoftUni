import java.util.Scanner;

public
class BonusScoringSystem {
    public static
    void main (String[] args) {
        Scanner scanner         = new Scanner (System.in);
        int     students        = Integer.parseInt (scanner.nextLine ());
        int     courseLectures  = Integer.parseInt (scanner.nextLine ());
        int     additionalBonus = Integer.parseInt (scanner.nextLine ());

        double maxBonusPoints         = 0;
        int    bestStudentAttendances = 0;

        for (int i = 0; i < students; i++) {
            int    attendances             = Integer.parseInt (scanner.nextLine ());
            double pointsForCurrantStudent = attendances / (double) courseLectures * (5 + additionalBonus);
            if (pointsForCurrantStudent > maxBonusPoints) {
                maxBonusPoints = pointsForCurrantStudent;
                bestStudentAttendances = attendances;
            }

        }
        System.out.printf ("Max Bonus: %.0f.%n", Math.ceil (maxBonusPoints));
        System.out.printf ("The student has attended %d lectures.", bestStudentAttendances);
    }
}
