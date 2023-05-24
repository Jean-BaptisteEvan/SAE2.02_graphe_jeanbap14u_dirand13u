
import java.util.*;

public class Dijkstra {

    public Valeur resoudre(Graphe g, String depart){

        Valeur v =new Valeur();
        ArrayList<String> Q = new ArrayList<>();
        String nom;
        for(int i = 0;i < g.listeNoeuds().size();i++){
            nom = g.listeNoeuds().get(i);
            v.setValeur(nom,Double.POSITIVE_INFINITY);
            v.setParent(nom,null);
            Q.add(nom);
        }
        v.setValeur(depart,0);
        double poids = 0;
        while(!Q.isEmpty()){
            String u = minU(v,Q);
            Q.remove(u);
            for(int j = 0;j < Q.size();j++){
                double minDistance = v.getValeur(u);


                double D = v.getValeur(u) + poids;
                //Si D < v.distance
                if( D < v.getValeur(Q.get(j))){
                    v.setValeur(Q.get(j),D);
                    v.setParent(Q.get(j),u);
                }
                //Alors v.distance <- D
                //v.parent <- u
            }
        }
        return v;
    }

    public String minU(Valeur v,ArrayList<String> Q){
        double min = v.getValeur(Q.get(0));
        String nMin = Q.get(0);
        for(int i = 1; i<Q.size();i++){
            if(v.getValeur(Q.get(i))<min){
                min = v.getValeur(Q.get(i));
                nMin = Q.get(i);
            }
        }
        return nMin;
    }

}

