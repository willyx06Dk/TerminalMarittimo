package progetto_terminal_marittimo;

import java.sql.Date;

public class viaggiRegistrati {
    private String nomeNave;
    private Date data_partenza;
    private Date data_arrivo;
    private int porto_partenza;
    private int porto_arrivo;
    private String direttrice;
    private int addetto;


    public viaggiRegistrati(Date dp, Date da, int pp, int pa, String d, int add, String n){
        this.nomeNave=n;
        this.data_partenza=dp;
        this.data_arrivo=da;
        this.porto_partenza=pp;
        this.porto_arrivo=pa;
        this.direttrice=d;
        this.addetto=add;
    }

    public String getNome(){
        return this.nomeNave;
    }
    
    public Date getDataPartenza(){
        return this.data_partenza;
    }
    
    public Date getDataArrivo(){
        return this.data_arrivo;
    }
    
    public int getPortoPartenza(){
        return this.porto_partenza;
    }
    
    public int getPortoArrivo(){
        return this.porto_arrivo;
    }
    
    public String getDirettrice(){
        return this.direttrice;
    }
    
    public int getAddetto(){
        return this.addetto;
    }
}

