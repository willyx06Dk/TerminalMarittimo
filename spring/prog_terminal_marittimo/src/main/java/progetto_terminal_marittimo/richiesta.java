package progetto_terminal_marittimo;

public class richiesta {
    private int ID;
    private int id_cliente;
    private int id_merce;
    private int quantita;


    public richiesta(int id, int id_c, int id_m, int q){
        this.ID=id;
        this.id_cliente=id_c;
        this.id_merce=id_m;
        this.quantita=q;
    }

    public int getID(){
        return this.ID;
    }

    public int getId_cliente(){
        return this.id_cliente;
    }

    public int getId_merce(){
        return this.id_merce;
    }

    public int getQuantita(){
        return this.quantita;
    }
}
