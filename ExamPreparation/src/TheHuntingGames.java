import java.util.Scanner;

public
class TheHuntingGames {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
 /*       •	On the 1st line, you are going to receive a number N - the days of the adventure – an integer in the range [1…100]
•	On the 2nd line – the count of players – an integer in the range [0 – 1000]
•	On the 3rd line - the group’s energy – a real number in the range [1 - 50000]
•	On the 4th line – water per day for one person – a real number [0.00 – 1000.00]
•	On the 5th line – food per day for one person – a real number [0.00 – 1000.00]
•	On the next N lines – one for each of the days – the amount of energy loss– a real number in the range [0.00 - 1000]
•	You will always have enough food and water.
*/
        int days = Integer.parseInt (scanner.nextLine ());
        int players = Integer.parseInt (scanner.nextLine ());
        double energy = Double.parseDouble (scanner.nextLine ());
        double waterPerDayPerPerson = Double.parseDouble (scanner.nextLine ());
        double foodPerDayPerPerson = Double.parseDouble (scanner.nextLine ());
            double water = waterPerDayPerPerson*players*days;
            double food = foodPerDayPerPerson*players*days;
        for (int i = 1; i <= days; i++) {
            double energyLossPerDay = Double.parseDouble (scanner.nextLine ());
            energy = energy - energyLossPerDay;
            if (energy<=0){
                System.out.printf ("You will run out of energy. You will be left with %.2f food and %.2f water.", food,water);return;
            }
            if (i%2==0){
                water = water*0.7;
                energy=energy*1.05;
            }if (i%3==0){
                food = food- food/players;
                    energy = energy*1.1;
            }
            if (energy<=0){
                System.out.printf ("You will run out of energy. You will be left with %.2f food and %.2f water.", food,water);
                return;
            }


        }
        System.out.printf ("You are ready for the quest. You will be left with - %.2f energy!",energy);
    }
}
