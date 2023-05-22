public class Main {

    public static void main(String[] args) {
        /*
            A -> B(12) D(87)
            B -> E(11)
            C -> A(19)
            D -> B(23) C(10)
            E -> D(43)
        * */
        GrapheListe graphe = new GrapheListe();
        graphe.ajouterArc("A","B",12);
        graphe.ajouterArc("A","D",87);
        graphe.ajouterArc("B","E",11);
        graphe.ajouterArc("C","A",19);
        graphe.ajouterArc("D","B",23);
        graphe.ajouterArc("D","C",10);
        graphe.ajouterArc("E","D",43);
        System.out.println(graphe.toString());

    }
}