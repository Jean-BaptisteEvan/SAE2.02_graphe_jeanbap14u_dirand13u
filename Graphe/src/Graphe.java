import java.util.ArrayList;

/**
 * interface graphe
 */
public interface Graphe {

    public ArrayList<String> listeNoeuds();
    public ArrayList<Arc> suivants(String n);

}
