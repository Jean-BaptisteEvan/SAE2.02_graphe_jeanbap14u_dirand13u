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
        for (Noeud nod : this.ensNoeuds) {
            str.add(nod.getNom());


        }
        return str;
    }

    public ArrayList<Arc> suivants(String n) {
        int i = 0;
        while (n==this.ensNoeuds.get(i).getNom()) {
            i = i + 1;
        }
        return this.ensNoeuds.get(i).getAdj();
    }

    public void ajouterArc(String depart, String destination, double cout) {
        if (!this.ensNom.contains(depart)) {
            ensNoeuds.add(new Noeud(depart));
            ensNom.add(depart);
        }
        if (!this.ensNom.contains(destination)) {
            ensNoeuds.add(new Noeud(destination));
            ensNom.add(destination);
        }
        int i = 0;
        boolean stop = false;
        while (stop == false) {

            if (depart == this.ensNoeuds.get(i).getNom()) {

                this.ensNoeuds.get(i).ajouterArc(destination, cout);
                stop = true;
            }
            i = i + 1;

        }
    }

    public String toString(){
        //initalisation des variables
        boolean bTrouv = false;

        int j = 0;

        StringBuffer output = new StringBuffer();
        ArrayList<Arc> listArc = new ArrayList<Arc>();
        // boucles sur tout les noeuds
        for (int i = 0;i<this.ensNom.size();i++){

            output.append( this.ensNom.get(i) + " ->" );
             //boucle de recherche du noeud actuel de ensNom dans ensNoeuds
            String nom = this.ensNom.get(i);
            bTrouv = false;
            while(j < this.ensNoeuds.size() && !bTrouv){
                String nomNoe = this.ensNoeuds.get(j).getNom();
                //si il existe un noeud avec le même nom que dans ensNom on append tout de suite les arcs a l output
                if(nomNoe.compareTo(nom) == 0){
                    bTrouv = true;
                    listArc = this.ensNoeuds.get(j).getAdj();
                    for(int k = 0;k<listArc.size();k++){
                        output.append(" "+listArc.get(k).getDest() + "("+listArc.get(k).getCout() +")");
                    }

                }else{
                    j++;
                }

            }
            j = 0;
            output.append("\n");
        }
        return output.toString();
    }
}
