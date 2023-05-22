import java.util.*;

public class Noeud {

    private String nom;
    private ArrayList<Arc> adj;

    public Noeud(String name){
        this.nom = name;
        this.adj = new ArrayList<Arc>();
    }

    public boolean equals(Noeud o) {
        boolean bRetour;
        if(o.nom.equals(this.nom)){
            bRetour = true;
        }else {
            bRetour = false;
        }
        return bRetour;
    }

    public void ajouterArc(String destination, double cout){
        Arc arc = new Arc(destination,cout);
        this.adj.add(arc);
    }

    public ArrayList<Arc> getAdj() {
        return adj;
    }

    public String getNom() {
        return nom;
    }
}
