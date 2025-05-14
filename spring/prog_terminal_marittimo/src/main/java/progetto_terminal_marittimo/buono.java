package progetto_terminal_marittimo;

import java.sql.Date;

public class buono {
    private int ID;
    private int quantita_merce;
    private Date data_rilascio;
    private int id_emittente;
    private int id_cliente;
    private int id_merce;

    public buono(int ID, int quantita_merce, Date data_rilascio, int id_emittente, int id_cliente, int id_merce) {
        this.ID = ID;
        this.quantita_merce = quantita_merce;
        this.data_rilascio = data_rilascio;
        this.id_emittente = id_emittente;
        this.id_cliente = id_cliente;
        this.id_merce = id_merce;
    }

    public int getID() {
        return ID;
    }

    public int getQuantita_merce() {
        return quantita_merce;
    }

    public Date getData_rilascio() {
        return data_rilascio;
    }

    public int getId_emittente() {
        return id_emittente;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public int getId_merce() {
        return id_merce;
    }
}
