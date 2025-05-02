class Fornitore {
    id;
    username;
    password;
  
    constructor(id, username, password) {
      this.id = id;
      this.username = username;
      this.password = password;
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
  
    toString() {
      return "ID: "+this.id+", Username: "+this.username;
    }
  }
  