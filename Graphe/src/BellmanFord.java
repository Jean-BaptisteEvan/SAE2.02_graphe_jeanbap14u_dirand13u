
import java.util.List;


public class BellmanFord {

    public static Valeur resoudre(Graphe g, String depart) {
        Valeur valeur = new Valeur();

        // Step 1: Initialization
        List<Noeud> noeuds = g.getNoeuds();
        for (Noeud noeud : noeuds) {
            if (noeud.equals(depart)) {
                valeur.setValeur(noeud.getNom(), 0.0);
            } else {
                valeur.setValeur(noeud.getNom(), Double.POSITIVE_INFINITY);
            }

        }


        int n = noeuds.size();
        for (int i = 1; i < n; i++) {
            for (Noeud noeud : noeuds) {
                for (Arc arc : noeud.getAdj()) {
                    String destination = arc.getDest();
                    double cout = arc.getCout();
                    double distanceNoeud = valeur.getValeur(noeud.getNom());
                    double distanceDestination = valeur.getValeur(destination);
                    if (distanceNoeud + cout < distanceDestination) {
                        valeur.setValeur(destination, distanceNoeud + cout);
                        valeur.setParent(destination, noeud.getNom());
                    }
                }
            }
        }


        for (Noeud noeud : noeuds) {
            List<Arc> arcs = g.suivants(noeud.getNom());
            for (Arc arc : arcs) {
                String destination = arc.getDest();
                double cout = arc.getCout();
                double distanceNoeud = valeur.getValeur(noeud.getNom());
                double distanceDestination = valeur.getValeur(destination);
                if (distanceNoeud + cout < distanceDestination) {
                    throw new RuntimeException("Negative cycle detected. The graph contains a negative cycle.");
                }
            }
        }

        return valeur;
    }
}