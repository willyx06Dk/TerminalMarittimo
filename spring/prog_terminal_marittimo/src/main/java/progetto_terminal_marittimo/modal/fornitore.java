package progetto_terminal_marittimo.modal;

public class fornitore {
    private int ID;
    private String username;
    private String password;
    private String nome;


    public fornitore(int id, String u, String p, String n){
        this.ID=id;
        this.username=u;
        this.password=p;
        this.nome=n;
    }

    public int getID(){
        return this.ID;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public String getNome(){
        return this.nome;
    }
}
