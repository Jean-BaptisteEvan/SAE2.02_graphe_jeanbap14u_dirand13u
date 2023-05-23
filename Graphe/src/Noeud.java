import java.util.*;

public class Noeud {

    private String nom;
    private ArrayList<Arc> adj;

    /**
     * contrusteur de noeud
     * @param name nom du noeud
     */
    public Noeud(String name){
        this.nom = name;
        this.adj = new ArrayList<Arc>();
    }

    /**
     * methode de verification d egalite entre deux noeud
     * @param o Noeud sur le quel on veut verifier l egalite
     * @return booleen qui si le noeud est le meme renvoie true
     */
    public boolean equals(Noeud o) {
        boolean bRetour;
        if(o.nom.equals(this.nom)){
            bRetour = true;
        }else {
            bRetour = false;
        }
        return bRetour;
    }

    /**
     * methode d ajout d un arc a la liste adj du noeud
     * @param destination nom du noeud d arrivee
     * @param cout cout de l arc
     */
    public void ajouterArc(String destination, double cout){
        Arc arc = new Arc(destination,cout);
        this.adj.add(arc);
    }

    /**
     * getter de adj
     * @return la liste des arc relie a ce noeud
     */
    public ArrayList<Arc> getAdj() {
        return adj;
    }

    /**
     * getter de nom
     * @return un string correspondant au nom du noeud
     */
    public String getNom() {
        return nom;
    }
}
