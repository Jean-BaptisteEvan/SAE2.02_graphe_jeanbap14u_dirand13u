import java.io.IOException;

public class Main {

    public static void main(String[] args) {


        GrapheListe graphe = new GrapheListe("Graphe1.txt");
        System.out.println(graphe.toGraphviz());


    }
}
