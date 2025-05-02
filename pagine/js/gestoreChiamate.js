function loginPersonale(user, pass) {
    let url="/personale/login?username="+user+"&password="+pass;
    fetch(url)
        .then(response => response.json())
        .then(data => {
            if (data === null) {
                console.log("Errore");
                return "errore";
            }
            let p = new PersonaleTerminal(data.ID, data.username, data.password, data.ruolo);
            sessionStorage.setItem("personale", JSON.stringify({
                id: p.getID(),
                username: p.getUsername(),
                password: p.getPassword(),
                ruolo: p.getRuolo()
            }));
            
            return "ok";
        })
        .catch(error => {
            console.log("Errore nella fetch:", error);
            return "errore";
        });
}

function loginCliente(user, pass) {
    let url="/cliente/login?username="+user+"&password="+pass;
    fetch(url)
        .then(response => response.json())
        .then(data => {
            if (data === null) {
                console.log("Errore");
                return "errore";
            }
            let c = new cliente(data.ID, data.username, data.password);
            sessionStorage.setItem("cliente", JSON.stringify({
                id: c.getID(),
                username: c.getUsername(),
                password: c.getPassword(),
            }));
            
            return "ok";
        })
        .catch(error => {
            console.log("Errore nella fetch:", error);
            return "errore";
        });
}

function loginFornitore(user, pass) {
    let url="/fornitore/login?username="+user+"&password="+pass;
    fetch(url)
        .then(response => response.json())
        .then(data => {
            if (data === null) {
                console.log("Errore");
                return "errore";
            }
            let f = new Fornitore(data.ID, data.username, data.password);
            sessionStorage.setItem("fornitore", JSON.stringify({
                id: f.getID(),
                username: f.getUsername(),
                password: f.getPassword(),
            }));
            
            return "ok";
        })
        .catch(error => {
            console.log("Errore nella fetch:", error);
            return "errore";
        });
}
