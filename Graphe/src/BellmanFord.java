
import java.util.List;


public class BellmanFord {

    public Valeur resoudre(Graphe g, String depart) {
        Valeur valeur = new Valeur();

        // Step 1: Initialization
        List<Noeud> noeuds = g.getNoeuds();
        for (Noeud noeud : noeuds) {



                valeur.setValeur(noeud.getNom(), Double.POSITIVE_INFINITY);
            }
        valeur.setValeur(depart, 0.0);



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




        return valeur;
    }
}