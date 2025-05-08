package progetto_terminal_marittimo;

public class nave {
    private int ID;
    private String nome;


    public nave(int id, String n){
        this.ID=id;
        this.nome=n;
    }

    public int getID(){
        return this.ID;
    }

    public String getnome(){
        return this.nome;
    }
}
