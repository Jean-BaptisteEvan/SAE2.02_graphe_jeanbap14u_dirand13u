
import java.util.List;


public class BellmanFord {

    public static Valeur resoudre(Graphe g, String depart) {
        Valeur valeur = new Valeur();

        // Step 1: Initialization
        List<String> noeuds = g.listeNoeuds();
        for (String noeud : noeuds) {
            if (noeud.equals(depart)) {
                valeur.setValeur(noeud, 0.0);
            } else {
                valeur.setValeur(noeud, Double.POSITIVE_INFINITY);
            }
            valeur.setParent(noeud, null);
        }


        int n = noeuds.size();
        for (int i = 1; i < n; i++) {
            for (String noeud : noeuds) {
                List<Arc> arcs = g.suivants(noeud);
                for (Arc arc : arcs) {
                    String destination = arc.getDest();
                    double cout = arc.getCout();
                    double distanceNoeud = valeur.getValeur(noeud);
                    double distanceDestination = valeur.getValeur(destination);
                    if (distanceNoeud + cout < distanceDestination) {
                        valeur.setValeur(destination, distanceNoeud + cout);
                        valeur.setParent(destination, noeud);
                    }
                }
            }
        }


        for (String noeud : noeuds) {
            List<Arc> arcs = g.suivants(noeud);
            for (Arc arc : arcs) {
                String destination = arc.getDest();
                double cout = arc.getCout();
                double distanceNoeud = valeur.getValeur(noeud);
                double distanceDestination = valeur.getValeur(destination);
                if (distanceNoeud + cout < distanceDestination) {
                    throw new RuntimeException("Negative cycle detected. The graph contains a negative cycle.");
                }
            }
        }

        return valeur;
    }
}