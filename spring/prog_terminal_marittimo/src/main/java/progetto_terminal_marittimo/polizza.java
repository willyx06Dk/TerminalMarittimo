package progetto_terminal_marittimo;


public class polizza {
    private int ID;
    private int quantita_merce;
    private int id_viaggio;
    private int id_fornitore;
    private int id_merce;


    public polizza(int id, int q, int v, int m, int f){
        this.ID=id;
        this.quantita_merce=q;
        this.id_merce=m;
        this.id_viaggio=v;
        this.id_fornitore=f;
    }

    public int getID(){
        return this.ID;
    }

    public int getQuantita(){
        return this.quantita_merce;
    }

    public int getMerce(){
        return this.id_merce;
    }

    public int getViaggio(){
        return this.id_viaggio;
    }

    public int getFornitore(){
        return this.id_fornitore;
    }
}
