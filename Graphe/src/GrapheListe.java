import java.util.ArrayList;

public class GrapheListe implements Graphe{
    /*
    liste des nom des objets noeuds
     */
    private ArrayList<String> ensNom;
    /*
    liste des objets noeuds
     */
    private ArrayList<Noeud> ensNoeuds;

    public GrapheListe(){
        this.ensNom =  new ArrayList<String>();
        this.ensNoeuds = new ArrayList<Noeud>();
    }
    public ArrayList<String> listeNoeuds() {

        for(int i=0;i < this.ensNoeuds.size();i++){
            Noeud nod = this.ensNoeuds.get(i);
            nod.

        }

        return null;
    }

    public ArrayList<Arc> suivants(String n) {
        return null;
    }

    public void ajouterArc(String depart, String destination, double cout){

    }
}
