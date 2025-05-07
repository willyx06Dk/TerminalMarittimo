class PersonaleTerminal {
    id;
    username;
    password;
    ruolo;
  
    constructor(id, username, password, ruolo) {
      this.id = id;
      this.username = username;
      this.password = password;
      this.ruolo = ruolo;
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
  
    getRuolo() {
      return this.ruolo;
    }
  
    toString() {
        return "ID: "+this.id+", Username: "+this.username + "Ruolo: "+this.ruolo;
    }
  }
  