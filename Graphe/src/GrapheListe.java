import java.nio.Buffer;
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
        ArrayList<String> str = null;
        for (int i = 0; i < this.ensNoeuds.size(); i++) {
            Noeud nod = this.ensNoeuds.get(i);


            str.add(nod.getNom());



        }
        return str;
    }

    public ArrayList<Arc> suivants(String n) {
        int i = 0;
        while (n==this.ensNoeuds.get(i).getNom()) {
            i = i + 1;
        }
        ArrayList al=this.ensNoeuds.get(i).getAdj();
        return al;
    }

    public void ajouterArc(String depart, String destination, double cout){

    }

    public String toString(){
        //initalisation des variables
        boolean bTrouv = false;
        int j;
        StringBuffer output = new StringBuffer();
        ArrayList<Arc> listArc = new ArrayList<Arc>();
        // boucles sur tout les noeuds
        for (int i = 0;i<this.ensNom.size();i++){

            output.append( this.ensNom.get(i) + " ->" );
             //boucle de recherche du noeud actuel de ensNom dans ensNoeuds
            while(j < this.ensNoeuds.size() && !bTrouv){

                if(this.ensNoeuds.){

                }else{

                }
                j++;
            }
            j = 0;
        }
        return null;
    }
}
