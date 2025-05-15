class Cliente {
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
      return "Username: "+this.username;
    }

    Parse(str){
      let vett=str.split(",");
      this.id=vett[0];
      this.username=vett[1];
      this.password=vett[2];
    }
  }
  