class Fornitore {
    id;
    username;
    password;
    nome;
  
    constructor(id, username, password, n) {
      this.id = id;
      this.username = username;
      this.password = password;
      this.nome=n;
    }
  
    getID() {
      return this.id;
    }
  
    getUsername() {
      return this.username;
    }
  
    getPassword() {
      return this.password;
    }

    getNome() {
      return this.nome;
    }
  
    toString() {
      return "ID: "+this.id+", Username: "+this.username;
    }

    Parse(str){
      let vett=str.split(",");
      this.id=vett[0];
      this.username=vett[1];
      this.password=vett[2];
    }
  }
  