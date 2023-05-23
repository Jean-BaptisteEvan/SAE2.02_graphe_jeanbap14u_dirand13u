import java.io.*;
import java.util.ArrayList;

public class GrapheListe implements Graphe{
    /*
    liste des noms des objets Nœuds
     */
    private ArrayList<String> ensNom;
    /*
    liste des objets nœuds
     */
    private ArrayList<Noeud> ensNoeuds;

    /**
     *contructeur sans parametre de grapheListe
     */
    public GrapheListe(){
        this.ensNom =  new ArrayList<>();
        this.ensNoeuds = new ArrayList<>();
    }

    /**
     * méthode qui retourne tout les noms des noeuds connus du graphe
     * @return ArrayList<String> liste des noms de noeuds
     */
    public ArrayList<String> listeNoeuds() {
        ArrayList<String> str = null;
        for (Noeud nod : this.ensNoeuds) {
            str.add(nod.getNom());


        }
        return str;
    }

    /**
     * @param n nom d un noeud
     * @return liste des arc du noeyd demande
     */
    public ArrayList<Arc> suivants(String n) {
        int i = 0;
        while (n.compareTo(this.ensNoeuds.get(i).getNom())==0) {
            i = i + 1;
        }
        return this.ensNoeuds.get(i).getAdj();
    }

    /**
     * methode qui permet d ajouter un arc à un graphe
     * @param depart nom du noeud de depart
     * @param destination nom du noeud d arrivee
     * @param cout prix du passage par cet arc
     */
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
        while (!stop && i<this.ensNoeuds.size()) {

            if (depart.compareTo(this.ensNoeuds.get(i).getNom()) == 0) {

                this.ensNoeuds.get(i).ajouterArc(destination, cout);
                stop = true;
            }
            i = i + 1;

        }
    }

    /**
     * @return String qui contient tout les informations du graphe
     */
    public String toString(){
        //initalisation des variables
        boolean bTrouv;

        int j = 0;

        StringBuffer output = new StringBuffer();
        ArrayList<Arc> listArc;
        // boucles sur tous les noeuds
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

    /**
     * methode qui retourne en texte pour Graphviz le graphe sur le quel elle est appele
     * @return String
     */
    public String toGraphviz(){
        //initalisation des variables
        boolean bTrouv;

        int j = 0;

        StringBuilder output = new StringBuilder();
        output.append("digraph G {\n");
        ArrayList<Arc> listArc;
        // boucles sur tout les noeuds
        for (int i = 0;i<this.ensNom.size();i++){

            //boucle de recherche du noeud actuel de ensNom dans ensNoeuds
            String nom = this.ensNom.get(i);
            bTrouv = false;//D -> C [label = 10]
            //A -> B(12)
            while(j < this.ensNoeuds.size() && !bTrouv){
                String nomNoe = this.ensNoeuds.get(j).getNom();
                //si il existe un noeud avec le même nom que dans ensNom on append tout de suite les arcs a l output
                if(nomNoe.compareTo(nom) == 0){
                    bTrouv = true;
                    listArc = this.ensNoeuds.get(j).getAdj();
                    for(int k = 0;k<listArc.size();k++){
                        output.append(this.ensNom.get(i)+" -> "+listArc.get(k).getDest() + " [label = " +listArc.get(k).getCout() +"]"+"\n");
                    }

                }else{
                    j++;
                }

            }
            j = 0;
        }
        output.append("}\n");
        return output.toString();
    }

    /**
     * methode qui génere un objet graphe a partir d un fichier
     * @param destFich emplacement d un fichier contenant une liste d'arcs
     */
    public GrapheListe(String destFich) {
        this.ensNom =  new ArrayList<>();
        this.ensNoeuds = new ArrayList<>();
       try{
           BufferedReader bReader = new BufferedReader(new FileReader(destFich));
           String ligne = bReader.readLine();

           while (ligne != null) {
               String[] splitLigne = ligne.split("\t");

               this.ajouterArc(splitLigne[0], splitLigne[1], Double.parseDouble(splitLigne[2]));
               ligne = bReader.readLine();

           }
       }catch(FileNotFoundException e){
           System.out.println("IOEXCEPTION");
       }catch(IOException e){
        System.out.println("no fichier");
    }
    }
}
