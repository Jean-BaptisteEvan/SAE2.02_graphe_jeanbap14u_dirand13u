import static org.junit.jupiter.api.Assertions.*;

class GrapheListeTest {

    @org.junit.jupiter.api.Test
    void test_ConstructeurGraphe() {
        GrapheListe graphe = new GrapheListe("Graphe_exemple1.txt");
        String res = "digraph G {\n" +
                "D -> C [label = 10.0]\n" +
                "D -> B [label = 23.0]\n" +
                "C -> A [label = 19.0]\n" +
                "A -> B [label = 12.0]\n" +
                "A -> D [label = 87.0]\n" +
                "B -> E [label = 11.0]\n" +
                "E -> D [label = 43.0]\n" +
                "}\n";
        String graphviz = graphe.toGraphviz();
        assertTrue(graphviz.equals(res), "hmmm");

    }
}