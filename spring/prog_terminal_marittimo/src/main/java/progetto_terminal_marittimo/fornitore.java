package progetto_terminal_marittimo;

public class fornitore {
    private int ID;
    private String username;
    private String password;


    public fornitore(int id, String u, String p){
        this.ID=id;
        this.username=u;
        this.password=p;
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
}
