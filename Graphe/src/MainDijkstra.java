import java.util.ArrayList;

public class MainDijkstra {

    public static void main(String[] args) {
        double db = System.currentTimeMillis();
        String fich = "Graphe905.txt";
        String dep = "1";
        String dest = "899";

        GrapheListe graphe = new GrapheListe(fich);
        Dijkstra dij = new Dijkstra();
        Valeur res = dij.resoudre(graphe,dep);

        System.out.println("Le chemin le plus court entre " + dep + " et " + dest + " est : ");


        ArrayList<String> chemin = res.calculerChemin(dest);
        for (int i = 0; i < chemin.size(); i++) {
            String s = chemin.get(i);
            System.out.print(s + " -> ");
        }
        System.out.println("fin");
        System.out.println("ce chemin a pour valeur : " + res.getValeur(dest));
        double fn = System.currentTimeMillis();
        System.out.println(fn-db);


    }
}

