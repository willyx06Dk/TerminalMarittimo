class Buono {
    constructor(ID, quantita_merce, data_rilascio, id_emittente, id_cliente, id_merce) {
        this.ID = ID;
        this.quantita_merce = quantita_merce;
        this.data_rilascio = data_rilascio;
        this.id_emittente = id_emittente;
        this.id_cliente = id_cliente;
        this.id_merce = id_merce;
    }

    getID() {
        return this.ID;
    }

    getQuantita_merce() {
        return this.quantita_merce;
    }

    getData_rilascio() {
        return this.data_rilascio;
    }

    getId_emittente() {
        return this.id_emittente;
    }

    getId_cliente() {
        return this.id_cliente;
    }

    getId_merce() {
        return this.id_merce;
    }
}
