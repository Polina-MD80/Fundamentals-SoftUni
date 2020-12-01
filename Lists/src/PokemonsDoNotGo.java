import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public
class PokemonsDoNotGo {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        List<Integer> pokemonList = new ArrayList<> ();
        String[] numbers = scanner.nextLine ().split (" ");

        for (int i = 0; i < numbers.length; i++) {
            int pokemon = Integer.parseInt (numbers[i]);
            pokemonList.add (pokemon);
        }

        int sum = 0;

        while (pokemonList.size ()>0){
            int index = Integer.parseInt (scanner.nextLine ());
            if (index<0){
                int constant = pokemonList.get (0);
                sum+=constant;
                pokemonList.set (0, pokemonList.get(pokemonList.size ()-1));
                setWithConstant (pokemonList, constant);

            }else if (index>pokemonList.size ()-1){
                int constant = pokemonList.get (pokemonList.size ()-1);
                sum+=constant;
                pokemonList.set (pokemonList.size ()-1, pokemonList.get (0));
                setWithConstant (pokemonList, constant);

            }else {
                int constant = pokemonList.get (index);
                sum+=constant;
                pokemonList.remove (index);
                setWithConstant (pokemonList, constant);
            }
        }
        System.out.println (sum);

    }

    private static
    void setWithConstant (List<Integer> pokemonList, int constant) {
        for (int i = 0; i < pokemonList.size (); i++) {
            if (pokemonList.get (i) <= constant) {
                pokemonList.set (i, pokemonList.get (i) + constant);
            } else {
                pokemonList.set (i, pokemonList.get (i) - constant);
            }
        }
    }
}
