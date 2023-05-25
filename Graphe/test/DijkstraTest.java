import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DijkstraTest {

    @Test
    void testResoudre() {
        String fich = "Graphe_exemple1.txt";
        String dep = "A";
        String dest = "C";

        GrapheListe graphe = new GrapheListe(fich);
        Dijkstra dij = new Dijkstra();
        Valeur res = dij.resoudre(graphe,dep);


        ArrayList<String> chemin = res.calculerChemin(dest);
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < chemin.size(); i++) {
            str.append(chemin.get(i) + " -> ");
        }
        str.append("fin");
        String cheminAttendu = "A -> B -> E -> D -> C -> fin";
        assertTrue(str.toString().equals(cheminAttendu),"le chemin trouve n est point le bon");
        //la valeur 76 etant la valeur du chemin la plus court entre A et C calcule a la main
        assertEquals(76.0,res.getValeur(dest),"la valeur recu n est celle attendue");
    }
}