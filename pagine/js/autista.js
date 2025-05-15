class Autista {
  constructor(id, nome, cognome, email) {
    this.id = id;
    this.nome = nome;
    this.cognome = cognome;
    this.email = email;
  }

  getID() {
    return this.id;
  }

  getNome() {
    return this.nome;
  }

  getCognome() {
    return this.cognome;
  }

  getEmail() {
    return this.email;
  }

  toString(){
    return "nome: "+this.nome+", cognome: "+this.cognome+", email: "+this.email;
  }
}
