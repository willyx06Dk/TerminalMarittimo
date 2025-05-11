class Porto {
    id;
    nome;
    nazionalita;
  
    constructor(id, n, naz) {
      this.id = id;
      this.nome = n;
      this.nazionalita = naz;
    }
  
    getID() {
      return this.id;
    }
  
    getNome() {
      return this.nome;
    }
  
    getNazionalita() {
      return this.nazionalita;
    }
  }
  