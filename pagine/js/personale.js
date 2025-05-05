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

    Parse(str){
        let vett=str.split(",");
        this.id=vett[0];
        this.username=vett[1];
        this.password=vett[2];
        this.ruolo=vett[3];
    }
  }
  