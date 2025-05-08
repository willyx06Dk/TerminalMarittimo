package progetto_terminal_marittimo;

public class porto {
    private int ID;
    private String nome;
    private String nazionalità;


    public porto(int id, String n, String naz){
        this.ID=id;
        this.nome=n;
        this.nazionalità=naz;
    }

    public int getID(){
        return this.ID;
    }

    public String getnome(){
        return this.nome;
    }

    public String getNazionalità(){
        return this.nazionalità;
    }
}
