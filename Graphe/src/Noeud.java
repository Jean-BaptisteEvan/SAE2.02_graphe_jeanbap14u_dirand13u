import java.util.*;

public class Noeud {

    private String nom;
    private List<Arc> adj;

    public Noeud(String name){
        this.nom = name;
        this.adj = new List<Arc>();
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
}
