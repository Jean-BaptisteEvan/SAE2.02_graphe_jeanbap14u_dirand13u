import java.util.*;

public class Dijkstra {
    /*
        Entrees :
        G un graphe oriente avec une ponderation (poids) positive des arcs
        A un sommet (depart) de G

        Debut
        Q <- {} // utilisation d’une liste de noeuds `a traiter
        Pour chaque sommet v de G faire
            v.distance <- Infini
            v.parent <- Indefini
            Q <- Q U {v} // ajouter le sommet v a la liste Q
        Fin Pour
        A.distance <- 0
        Tant que Q est un ensemble non vide faire
            u <- un sommet de Q telle que u.distance est minimale
            Q <- Q \ {u} // enlever le sommet u de la liste Q
            Pour chaque sommet v de Q tel que l’arc (u,v) existe faire
                D <- u.distance + poids(u,v)
                Si D < v.distance
                    Alors v.distance <- D
                           v.parent <- u
                Fin Si
            Fin Pour
        Fin Tant que
        Fin
    */
    public static Valeur resoudre(Graphe g, String depart) {
        Valeur valeur = new Valeur();

        List<String> noeuds = g.listeNoeuds();

        // Initialisation
        for (String v : noeuds) {
            valeur.setValeur(v, Double.POSITIVE_INFINITY);
            valeur.setParent(v, null);
        }
        valeur.setValeur(depart, 0);


        Set<String> nonTraites = new HashSet<>(noeuds);

        while (!nonTraites.isEmpty()) {
            String u = trouverNoeudMinimum(valeur, nonTraites);
            nonTraites.remove(u);

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