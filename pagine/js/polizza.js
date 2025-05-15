class Polizza {
  constructor(id, quantita, viaggio, merce, fornitore) {
    this.ID = id;
    this.quantita_merce = quantita;
    this.id_viaggio = viaggio;
    this.id_merce = merce;
    this.id_fornitore = fornitore;
  }

  getID() {
    return this.ID;
  }

  getQuantita() {
    return this.quantita_merce;
  }

  getMerce() {
    return this.id_merce;
  }

  getViaggio() {
    return this.id_viaggio;
  }

  getFornitore() {
    return this.id_fornitore;
  }
}
