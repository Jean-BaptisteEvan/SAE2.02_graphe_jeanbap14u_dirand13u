import java.util.*;

public class Noeud {

    private String nom;
    private List<Arc> adj;
    
    public Noeud(String name){
        this.nom = name;
        this.adj = new List<Arc>();
    }
}
