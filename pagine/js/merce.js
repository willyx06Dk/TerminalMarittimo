class Merce {
    id;
    nome;
    categoria;
  
    constructor(id, n, cat) {
      this.id = id;
      this.nome = n;
      this.categoria = cat;
    }
  
    getID() {
      return this.id;
    }
  
    getNome() {
      return this.nome;
    }
  
    getCategoria() {
      return this.cat;
    }
  }
  