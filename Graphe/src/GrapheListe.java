import java.util.ArrayList;

public class GrapheListe implements Graphe{

    private ArrayList<String> ensNom;
    private ArrayList<Noeud> ensNoeuds;

    public GrapheListe(){
        this.ensNom = ;
        this.ensNoeuds = ;
    }
    public ArrayList<String> listeNoeuds() {

        for(int i=0;i < this.ensNoeuds.size();i++){

        }

        return null;
    }

    public ArrayList<Arc> suivants(String n) {
        return null;
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
