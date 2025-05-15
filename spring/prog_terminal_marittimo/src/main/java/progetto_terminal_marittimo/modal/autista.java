package progetto_terminal_marittimo.modal;

public class autista {
    private int ID;
    private String nome;
    private String cognome;
    private String email;

    public autista(int id, String nome, String cognome, String email) {
        this.ID = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
    }

    public int getID() {
        return this.ID;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCognome() {
        return this.cognome;
    }

    public String getEmail() {
        return this.email;
    }
}
