package progetto_terminal_marittimo.modal;

import java.sql.Date;

public class registro {
    private int ID;
    private Date data_ritiro;
    private int peso_ritirato;
    private int id_autista;
    private String id_camion;
    private int id_cliente;

    public registro(int ID, Date data_ritiro, int peso_ritirato, int id_autista, String id_camion, int id_cliente) {
        this.ID = ID;
        this.data_ritiro = data_ritiro;
        this.peso_ritirato = peso_ritirato;
        this.id_autista = id_autista;
        this.id_camion = id_camion;
        this.id_cliente = id_cliente;
    }

    public int getID() {
        return ID;
    }

    public Date getDataRitiro() {
        return data_ritiro;
    }

    public int getPesoRitirato() {
        return peso_ritirato;
    }

    public int getIdAutista() {
        return id_autista;
    }

    public String getIdCamion() {
        return id_camion;
    }

    public int getIdCliente() {
        return id_cliente;
    }
}
