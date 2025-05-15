package progetto_terminal_marittimo.modal;

public class merce {
    private int ID;
    private String nome;
    private String categoria;


    public merce(int id, String n, String c){
        this.ID=id;
        this.nome=n;
        this.categoria=c;
    }

    public int getID(){
        return this.ID;
    }

    public String getnome(){
        return this.nome;
    }

    public String getCategoria(){
        return this.categoria;
    }
}
