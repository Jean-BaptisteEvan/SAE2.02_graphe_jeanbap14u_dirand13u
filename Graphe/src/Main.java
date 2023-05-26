import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        GrapheListe graphe = new GrapheListe();
        /*System.out.println(graphe.toGraphviz());*/
        graphe.randomGraph(7);
        System.out.println(graphe.toGraphviz());


    }
}
