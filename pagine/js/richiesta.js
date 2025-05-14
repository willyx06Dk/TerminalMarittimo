class Richiesta {
  constructor(id, id_cliente, id_merce, quantita) {
    this.ID = id;
    this.id_cliente = id_cliente;
    this.id_merce = id_merce;
    this.quantita = quantita;
  }

  getID() {
    return this.ID;
  }

  getId_cliente() {
    return this.id_cliente;
  }

  getId_merce() {
    return this.id_merce;
  }

  getQuantita() {
    return this.quantita;
  }
}
