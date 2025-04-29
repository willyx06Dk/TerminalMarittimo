package progetto_terminal_marittimo;

public class personaleTerminal {
    private int ID;
    private String username;
    private String password;
    private String ruolo;


    public personaleTerminal(int id, String u, String p, String r){
        this.ID=id;
        this.username=u;
        this.password=p;
        this.ruolo=r;
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

    public String getRuolo(){
        return this.ruolo;
    }
}
