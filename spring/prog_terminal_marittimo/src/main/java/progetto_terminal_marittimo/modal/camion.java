package progetto_terminal_marittimo.modal;

public class camion {
    private String targa;
    private String modello;

    public camion(String t, String m) {
        this.targa = t;
        this.modello = m;
    }

    public String getTarga() {
        return this.targa;
    }

    public String getModello() {
        return this.modello;
    }
}
