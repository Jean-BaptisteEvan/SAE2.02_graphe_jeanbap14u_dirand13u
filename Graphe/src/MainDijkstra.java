import java.util.ArrayList;

public class MainDijkstra {
    public static void main(String[] args) {
        String fich = "Graphe_exemple1.txt";
        String dep = "A";
        String dest = "B";

        GrapheListe graphe = new GrapheListe(fich);
        Dijkstra dij = new Dijkstra();
        System.out.println("im in");
        Valeur res = dij.resoudre(graphe,dep);
        System.out.println("heya");
        for (Noeud n : graphe.getNoeuds()) {
            System.out.println("noeud : " + n.getNom());
            System.out.println("distance depuis " + dep + " " + res.getValeur(n.getNom()));
            System.out.println("parent de ce noeud : " + res.getParent(n.getNom()));
            System.out.println("|_________________________|");
        }

        ArrayList<String> chemin = res.calculerChemin(dest);
        for (String s : chemin) {
            System.out.print(s + " ");
        }

    }
}

