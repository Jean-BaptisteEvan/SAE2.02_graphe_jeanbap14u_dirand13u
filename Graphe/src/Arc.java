public class Arc {
    private String dest;
    private double cout;

    public Arc(String destination, double dist){
        if(dist>0){
            this.dest = destination;
            this.cout = dist;
        }else{
            throw new Error("il ne peut y avoir en aucun cas une valeur autre que strictement positive");
        }
    }
}
