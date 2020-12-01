import java.util.Scanner;

public
class EasterGifts {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String[] gifts = scanner.nextLine ().split ("\\s+");

        String command = scanner.nextLine ();

        while (!"No Money".equals (command)){
            String[] tokens = command.split ("\\s+");
            switch (tokens[0]){
                case "OutOfStock":
                    outOfStock (gifts, tokens);
                    break;
                case "Required":
                    required (gifts, tokens);
                    break;
                case "JustInCase":
                    justInCase (gifts, tokens);
                    break;
            }
            command = scanner.nextLine ();
        }

        for (String gift : gifts) {
            if (!"None".equals (gift)){
                System.out.print (gift+" ");
            }

        }

    }

    private static
    void justInCase (String[] gifts, String[] tokens) {
        gifts[gifts.length-1]=tokens[1];
    }

    private static
    void required (String[] gifts, String[] tokens) {
        int index = Integer.parseInt (tokens[2]);
        if (index>=0&& index < gifts.length){
            gifts[index] = tokens[1];
        }
    }

    private static
    void outOfStock (String[] gifts, String[] tokens) {
        for (int i = 0; i < gifts.length; i++) {
            if (gifts[i].equals (tokens[1])){
                gifts[i]="None";
            }
        }
    }
}
