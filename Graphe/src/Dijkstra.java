import java.util.*;

public class Dijkstra {

    public static Valeur resoudre(Graphe g, String depart) {
        Valeur valeur = new Valeur();

        List<String> noeuds = g.listeNoeuds();

        // Initialisation
        for (String v : noeuds) {
            valeur.setValeur(v, Double.POSITIVE_INFINITY);
            valeur.setParent(v, null);
        }
        valeur.setValeur(depart, 0);

        Set<String> traites = new HashSet<>();
        Set<String> nonTraites = new HashSet<>(noeuds);

        while (!nonTraites.isEmpty()) {
            String u = trouverNoeudMinimum(valeur, nonTraites);
            nonTraites.remove(u);
            traites.add(u);

            ArrayList<Arc> voisins = g.suivants(u);
            for (Arc arc : voisins) {
                String v = arc.getDest();
                double poidsUV = arc.getCout();
                double distanceParU = valeur.getValeur(u) + poidsUV;

                if (distanceParU < valeur.getValeur(v)) {
                    valeur.setValeur(v, distanceParU);
                    valeur.setParent(v, u);
                }
            }
        }

        return valeur;
    }

    private static String trouverNoeudMinimum(Valeur valeur, Set<String> noeuds) {
        String minNoeud = null;
        double minDistance = Double.POSITIVE_INFINITY;

        for (String noeud : noeuds) {
            double distance = valeur.getValeur(noeud);
            if (distance < minDistance) {
                minDistance = distance;
                minNoeud = noeud;
            }
        }

        return minNoeud;
    }
}