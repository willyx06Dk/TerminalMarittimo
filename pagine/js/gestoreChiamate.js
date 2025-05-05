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
            sessionStorage.setItem("personale", JSON.stringify(p));    
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
            sessionStorage.setItem("cliente", JSON.stringify(c)); 
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
            sessionStorage.setItem("fornitore", JSON.stringify(f));
            return "ok";
        })
        .catch(error => {
            console.log("Errore nella fetch:", error);
            return "errore";
        });
}

function registraCliente(nome, cognome, email, codice, user, pass) {
    let url="/cliente/registra?nome"=nome+"&cognome="+cognome+"&username="+user+"&password="+pass+"&email="+email+"&codice_identificativo_carta="+codice;
    fetch(url)
        .then(response => response.json())
        .then(data => {
            if (data != "ok") {
                console.log(data);
                return data;
            }
            return "ok";
        })
        .catch(error => {
            console.log("Errore nella fetch:", error);
            return "errore";
        });
}

function registraFornitore(nome, email, user, pass) {
    let url="/fornitore/registra?nome"=nome+"&username="+user+"&password="+pass+"&email="+email;
    fetch(url)
        .then(response => response.json())
        .then(data => {
            if (data != "ok") {
                console.log(data);
                return data;
            }
            return "ok";
        })
        .catch(error => {
            console.log("Errore nella fetch:", error);
            return "errore";
        });
}
