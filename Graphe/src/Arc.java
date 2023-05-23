public class Arc {
    private String dest;
    private double cout;

    /**
     * @param destination
     * @param dist
     */
    public Arc(String destination, double dist){
        if(dist>0){
            this.dest = destination;
            this.cout = dist;
        }else{
            throw new Error("il ne peut y avoir en aucun cas une valeur autre que strictement positive");
        }
    }

    /**
     * getter de l attribut cout
     * @return un double correpondant au prix de l arc
     */
    public double getCout() {
        return cout;
    }

    /**
     * getter de l attrobut dest
     * @return un String correspondant a la destination de l arc
     */
    public String getDest() {
        return dest;
    }
}
