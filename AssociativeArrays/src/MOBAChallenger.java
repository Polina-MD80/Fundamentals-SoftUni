import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public
class MOBAChallenger {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        //"{player} -> {position} -> {skill}"
        //"{player} vs {player}"
        Pattern                           playerPattern  = Pattern.compile (" -> ");
        Pattern                           gamePattern    = Pattern.compile (" vs ");
        String                            input          = scanner.nextLine ();
        Map<String, Map<String, Integer>> pool           = new TreeMap<> ();
        Map<String, List<String>>         playerPosition = new TreeMap<> ();

        while (!"Season end".equals (input)) {
            Matcher playerInfo = playerPattern.matcher (input);
            Matcher gameTask   = gamePattern.matcher (input);
            if (playerInfo.find ()) {
                String[] playerParts = input.split (" -> ");
                String   player      = playerParts[0];
                String   position    = playerParts[1];
                int      skill       = Integer.parseInt (playerParts[2]);
                //pool
                pool.putIfAbsent (player, new TreeMap<> ());
                pool.get (player).putIfAbsent (position, 0);
                if (skill > pool.get (player).get (position)) {
                    pool.get (player).put (position, skill);
                }
                //playerPosition
                playerPosition.putIfAbsent (player, new ArrayList<> ());
                if (!playerPosition.get (player).contains (position)) {
                    playerPosition.get (player).add (position);
                }

            } else if (gameTask.find ()) {
                String[] gameParts    = input.split (" vs ");
                String   firstPlayer  = gameParts[0];
                String   secondPlayer = gameParts[1];
                if (!(playerPosition.containsKey (firstPlayer) && playerPosition.containsKey (secondPlayer))) {
                    input = scanner.nextLine ();
                    continue;
                }
                boolean samePosition    = false;
                String  currantPosition = "";
                for (String s : playerPosition.get (firstPlayer)) {
                    for (String s1 : playerPosition.get (secondPlayer)) {
                        if (s.equals (s1)) {
                            samePosition = true;
                            currantPosition = s;
                            break;
                        }
                    }
                }
                if (samePosition) {
                    int firstPlayerSkill  = pool.get (firstPlayer).get (currantPosition);
                    int secondPlayerSkill = pool.get (secondPlayer).get (currantPosition);
                    if (firstPlayerSkill > secondPlayerSkill) {
                        pool.remove (secondPlayer);
                        playerPosition.remove (secondPlayer);
                    }
                    if (firstPlayerSkill < secondPlayerSkill) {
                        pool.remove (firstPlayer);
                        playerPosition.remove (firstPlayer);
                    }
                }
            }
            input = scanner.nextLine ();
        }

        Map<String, Integer> ranking = new TreeMap<> ();
        for (Map.Entry<String, Map<String, Integer>> name : pool.entrySet ()) {
            int sum = 0;
            for (Map.Entry<String, Integer> position : name.getValue ().entrySet ()) {
                sum += position.getValue ();
            }
            ranking.put (name.getKey (), sum);
        }

        ranking.entrySet ()
                .stream ()
                .sorted ((n1, n2) -> Integer.compare (n2.getValue (), n1.getValue ()))
                .forEach (n -> {
                    System.out.printf ("%s: %d skill%n", n.getKey (), n.getValue ());
                    printPlayerPositions (n.getKey (), pool);
                });

    }

    private static
    void printPlayerPositions (String name, Map<String, Map<String, Integer>> pool) {
        pool.get (name).entrySet ().stream ().sorted ((s1, s2) -> Integer.compare (s2.getValue (), s1.getValue ()))
                .forEach (s -> System.out.printf ("- %s <::> %d%n", s.getKey (), s.getValue ()));
    }
}



