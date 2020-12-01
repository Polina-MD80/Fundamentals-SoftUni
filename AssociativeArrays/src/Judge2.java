import java.util.*;
//created by J.M.
public class Judge2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String,Map<String,Integer>>contestInfo=new LinkedHashMap<>();
        String input;

        while (!"no more time".equals(input=scan.nextLine())){
            String[]command=input.split(" -> ");
            String user=command[0];
            String contest=command[1];
            int points=Integer.parseInt(command[2]);
            contestInfo.putIfAbsent(contest,new TreeMap<>());
            contestInfo.get(contest).putIfAbsent(user,0);
            if(contestInfo.get(contest).get(user)<points){
                contestInfo.get(contest).put(user,points);
            }
        }
        contestInfo.entrySet().stream().sorted(Map.Entry.<String, Map<String, Integer>>
                comparingByValue(Comparator.comparing(Map::size)).reversed()).forEach(e->{
            var ref = new Object() {
                int count = 1;
            };
            System.out.printf("%s: %d participants%n",e.getKey(),e.getValue().size());
            e.getValue().entrySet().stream().sorted((a,b)->b.getValue().compareTo(a.getValue())).forEach(v-> {
                System.out.printf("%d. %s <::> %d%n", ref.count,v.getKey(),v.getValue()); ref.count++; });
        });
        Map<String,Integer>userInfo=new TreeMap<>();
        for (Map.Entry<String, Map<String, Integer>> entry : contestInfo.entrySet()) {
            for (Map.Entry<String, Integer> integerEntry : entry.getValue().entrySet()) {
                userInfo.put(integerEntry.getKey(),!userInfo.containsKey(integerEntry.getKey())?integerEntry.getValue():
                        userInfo.get(integerEntry.getKey())+integerEntry.getValue());
            }

        }
        var ref = new Object() {
            int count = 1;
        };
        System.out.println("Individual standings:");
        userInfo.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(e -> { System.out.printf("%d. %s -> %d%n", ref.count, e.getKey(), e.getValue()); ref.count++; });
    }
}

