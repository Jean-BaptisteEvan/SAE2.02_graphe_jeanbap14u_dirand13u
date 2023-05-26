import java.util.ArrayList;

public class MainBellmanFord {

    public static void main(String[] args) {

        double db = System.currentTimeMillis();
        GrapheListe graphe = new GrapheListe("Graphe905.txt");
        BellmanFord bellford = new BellmanFord();
        String dep = "1";
        Valeur res = bellford.resoudre(graphe, dep);

        for (Noeud n : graphe.getNoeuds()) {
            System.out.println("noeud : " + n.getNom());
            System.out.println("distance depuis " + dep + " " + res.getValeur(n.getNom()));
            System.out.println("parent de ce noeud : " + res.getParent(n.getNom()));
            System.out.println("|_________________________|");
        }

        ArrayList<String> chemin = res.calculerChemin("C");
        for (String s : chemin) {
            System.out.print(s + " ");
        }
        double fn = System.currentTimeMillis();
        System.out.println(fn-db);
    }
}

