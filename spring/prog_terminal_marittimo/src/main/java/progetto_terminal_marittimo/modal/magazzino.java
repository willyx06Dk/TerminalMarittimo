package progetto_terminal_marittimo.modal;

import java.sql.Date;

public class magazzino {
    private int ID;
    private int quantita_merce;
    private int id_merce;
    private int id_addetto;
    private Date ultima_modifica;


    public magazzino(int id, int q, int m, int a, Date d){
        this.ID=id;
        this.quantita_merce=q;
        this.id_merce=m;
        this.id_addetto=a;
        this.ultima_modifica=d;
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

    public int getAddetto(){
        return this.id_addetto;
    }

    public Date getUltimaModifica(){
        return this.ultima_modifica;
    }
}
