import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        GrapheListe graphe = new GrapheListe("Graphe_exemple1.txt");
        System.out.println(graphe.toGraphviz());
        //graphe.randomGraph(50);
        //System.out.println(graphe.toGraphviz());


    }
}
