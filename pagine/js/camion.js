class Camion {
  constructor(targa, modello) {
    this.targa = targa;
    this.modello = modello;
  }

  getID() {
    return this.targa;
  }

  getModello() {
    return this.modello;
  }

  toString(){
    return "targa: "+this.targa+", modello: "+this.modello;
  }
}
