import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Comparator;

import static java.util.Comparator.*;

//created by J.M.
public class TeamworkProjects {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countOfTeams = Integer.parseInt(scan.nextLine());
        List<Team> teamsList = new ArrayList<>();
        while (countOfTeams-- > 0) {
            String[] input = scan.nextLine().split("-");
            if (teamsList.stream().anyMatch(e -> e.getName().equals(input[1]))) {
                System.out.printf("Team %s was already created!%n", input[1]);
            } else if (teamsList.stream().anyMatch(e -> e.getCreator().equals(input[0]))) {
                System.out.printf("%s cannot create another team!%n", input[0]);
            } else {
                Team newData = new Team();
                newData.setCreator(input[0]); newData.setName(input[1]); teamsList.add(newData);
                System.out.printf("Team %s has been created by %s!%n", input[1], input[0]);
            }
        }
        String input;
        while (!"end of assignment".equals(input = scan.nextLine())) {
            String[] command = input.split("->");
            if (teamsList.stream().noneMatch((e -> e.getName().equals(command[1])))) {
                System.out.printf("Team %s does not exist!%n", command[1]);
            } else if ((teamsList.stream().anyMatch(e -> e.getCreator().equals(command[0])))
                       || (teamsList.stream().anyMatch(e -> e.getMembers().equals(command[0])))) {
                System.out.printf("Member %s cannot join team %s!%n", command[0], command[1]);
            } else {
                IntStream.range(0, teamsList.size()).filter(i -> teamsList.get(i).getName().equals(command[1]))
                        .forEach(i -> teamsList.get(i).getMembers().add(command[0]));
            }
        }

        /*teamsList.sort (Comparator.comparing (Team::getName));
        teamsList.sort (Comparator.comparingInt (Team::getMembersSize).reversed ());*/
        teamsList.stream ().sorted((t1,t2)->{
            int result =Integer.compare (t2.getMembersSize (), t1.getMembersSize ());
            if (result==0){
                result = t1.getName ().compareTo (t2.getName ());

            }
            return result;
        });

        for (Team currentTeam : teamsList) {
            if (!currentTeam.getMembers().isEmpty()) {
                System.out.printf("%s%n",currentTeam.getName());
                System.out.printf("- %s%n", currentTeam.getCreator());
                teamsList.stream ().forEach (t->t.getMembers ().sort ((m1,m2)->m1.compareTo (m2)));

                for (String currentUser : currentTeam.getMembers()) {
                    System.out.printf("-- %s%n", currentUser);
                }
            }
        }

        System.out.println("Teams to disband:");
        teamsList.sort (Comparator.comparing (Team::getName));
        for (Team currentTeam : teamsList) {
            if (currentTeam.getMembers().isEmpty()) {
                System.out.printf("%s%n", currentTeam.getName());
            }
        }

    }

    static class Team {
        String name;
        String creator;
        List<String> members;

        public Team() {
            setMembers(new ArrayList<>());
        }
        public List<String> getMembers() {
            return members;
        }
        public int getMembersSize(){
            return getMembers ().size ();
        }
        public String getName() {
            return name;
        }
        public String getCreator() {
            return creator;
        }
        public void setName(String value) {
            name = value;
        }
        public void setCreator(String value) {
            creator = value;
        }
        public void setMembers(List<String> value) {
            members = value;
        }

    }
}