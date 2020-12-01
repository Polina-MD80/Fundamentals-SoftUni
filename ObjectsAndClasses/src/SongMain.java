import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public
class SongMain {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int n = Integer.parseInt (scanner.nextLine ());
        List<Songs> songs = new ArrayList<> ();

        for (int i = 1; i <= n ; i++) {
            String[] tokens = scanner.nextLine ().split ("_");
            String typeList = tokens[0];
            String songName = tokens[1];
            String time = tokens[2];

            Songs song = new Songs (typeList,songName,time);
            songs.add (song);

        }

        String command = scanner.nextLine ();
        if (command.equals ("all")){
            for (Songs song : songs) {
                System.out.println (song.getSongName ());
            }

        }else {
            for (Songs song : songs) {
                if (song.getTypeList ().equals (command)){
                    System.out.println (song.getSongName ());
                }
            }
        }

    }
}
