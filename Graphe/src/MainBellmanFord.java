import java.util.ArrayList;

public class MainBellmanFord {
    public static void main(String[] args) {


        GrapheListe graphe = new GrapheListe("Graphe_exemple1.txt");
        BellmanFord bellford = new BellmanFord();
        String dep = "A";
        Valeur res = bellford.resoudre(graphe, dep);

        for (Noeud n : graphe.getNoeuds()) {
            System.out.println("noeud : " + n.getNom());
            System.out.println("distance depuis " + dep + " " + res.getValeur(n.getNom()));
            System.out.println("parent de ce noeud : " + res.getParent(n.getNom()));
            System.out.println("|_________________________|");
        }

        ArrayList<String> chemin = res.calculerChemin("C");
        for(int i = 0;i<chemin.size();i++){
            System.out.print(chemin.get(i) + " ");
        }

    }
}

