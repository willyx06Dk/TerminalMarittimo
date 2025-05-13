async function loginPersonale(user, pass) {
    let hashedPass = CryptoJS.MD5(pass).toString();
    let url = "http://localhost:8080/personale/login?username="+user+"&password="+hashedPass;
    try {
        let response = await fetch(url);
        let data = await response.json();

        if (data.id === -1 || !data.id) {
            return "errore";
        }

        let p = new PersonaleTerminal(data.id, data.username, data.password, data.ruolo);
        sessionStorage.setItem("personale", JSON.stringify(p));
        return "ok";
    } catch (error) {
        console.log("Errore nella fetch:", error);
        return "errore";
    }
}


async function loginCliente(user, pass) {
    let hashedPass = CryptoJS.MD5(pass).toString();
    let url = "http://localhost:8080/cliente/login?username="+user+"&password="+hashedPass;
    try {
        let response = await fetch(url);
        let data = await response.json();
        if (data.id == -1 || !data.id) {
            console.log("Errore");
            return "errore";
        }
        let c = new Cliente(data.id, data.username, data.password);
        sessionStorage.setItem("cliente", JSON.stringify(c));
        return "ok";
    } catch (error) {
        console.log("Errore nella fetch:", error);
        return "errore";
    }
}


async function loginFornitore(user, pass) {
    let hashedPass = CryptoJS.MD5(pass).toString();
    let url = "http://localhost:8080/fornitore/login?username="+user+"&password="+hashedPass;
    try {
        let response = await fetch(url);
        let data = await response.json();
        if (data.id == -1 || !data.id) {
            console.log("Errore");
            return "errore";
        }
        let f = new Fornitore(data.id, data.username, data.password, data.nome);
        sessionStorage.setItem("fornitore", JSON.stringify(f));
        return "ok";
    } catch (error) {
        console.log("Errore nella fetch:", error);
        return "errore";
    }
}


async function registraCliente(nome, cognome, email, codice, user, pass) {
    let hashedPass = CryptoJS.MD5(pass).toString();
    let url = "http://localhost:8080/cliente/registra?nome="+nome+"&cognome="+cognome+"&username="+user+ "&password="+hashedPass+"&email="+email+"&codice_identificativo_carta="+codice;
    try {
        let response = await fetch(url);
        let testo = await response.text();
        if(testo == "ok"){
            return  "ok";
        }
        return  "errore";
    } catch (error) {
        console.log("Errore nella fetch:", error);
        return "errore";
    }
}


async function registraFornitore(nome, email, user, pass) {
    let hashedPass = CryptoJS.MD5(pass).toString();
    let url = "http://localhost:8080/fornitore/registra?nome="+nome+"&username="+user+"&password="+hashedPass+"&email="+email;
    try {
        let response = await fetch(url);
        let testo = await response.text();
        if(testo == "ok"){
            return  "ok";
        }
        return  "errore";
    } catch (error) {
        console.log("Errore nella fetch:", error);
        return "errore";
    }
}


async function addAddetto(user, pass, ruolo, usernameA, passwordA, ruoloA) {
    let hashedPass = CryptoJS.MD5(pass).toString();
    let url = "http://localhost:8080/personale/addPersonale?username="+usernameA+"&password="+passwordA+"&ruolo="+ruoloA+"&nome="+user+"&passwordAddetto="+hashedPass+"&ruoloAddetto="+ruolo;
    try {
        let response = await fetch(url);
        let testo = await response.text();
        if(testo == "ok"){
            return  "ok";
        }
        return  "errore";
    } catch (error) {
        console.log("Errore nella fetch:", error);
        return "errore";
    }
}

async function addMerce(nome, categoria) {
    let url = "http://localhost:8080/merce/registra?nome="+nome+"&categoria="+categoria;
    try {
        let response = await fetch(url);
        let testo = await response.text();
        if(testo == "ok"){
            return  "ok";
        }
        return  "errore";
    } catch (error) {
        console.log("Errore nella fetch:", error);
        return "errore";
    }
}

async function addNave(nome) {
    let url = "http://localhost:8080/nave/registra?nome="+nome;
    try {
        let response = await fetch(url);
        let testo = await response.text();
        if(testo == "ok"){
            return  "ok";
        }
        return  "errore";
    } catch (error) {
        console.log("Errore nella fetch:", error);
        return "errore";
    }
}

async function addPorto(nome, nazionalita) {
    let url = "http://localhost:8080/porto/registra?nome="+nome+"&nazionalita="+nazionalita;
    try {
        let response = await fetch(url);
        let testo = await response.text();
        if(testo == "ok"){
            return  "ok";
        }
        return  "errore";
    } catch (error) {
        console.log("Errore nella fetch:", error);
        return "errore";
    }
}

async function getPorti() {
    let url = "http://localhost:8080/porto/ottieni";
    try {
        let response = await fetch(url);
        let data = await response.json();
        if (!Array.isArray(data)) {
            console.log("Errore");
            return null;
        }
        let vett=[];
        for (let index = 0; index < data.length; index++) {
            let element = data[index];
            let porto=new Porto(element.id, element.nome, element.nazionalita);
            vett.push(porto);
        }
        return vett;
    } catch (error) {
        console.log("Errore nella fetch:", error);
        return null;
    }
}

async function getMerci() {
    let url = "http://localhost:8080/merce/ottieni";
    try {
        let response = await fetch(url);
        let data = await response.json();
        if (!Array.isArray(data)) {
            console.log("Errore");
            return null;
        }
        let vett=[];
        for (let index = 0; index < data.length; index++) {
            let element = data[index];
            let porto=new Merce(element.id, element.nome, element.categoria);
            vett.push(porto);
        }
        return vett;
    } catch (error) {
        console.log("Errore nella fetch:", error);
        return null;
    }
}

async function getNavi() {
    let url = "http://localhost:8080/nave/ottieni";
    try {
        let response = await fetch(url);
        let data = await response.json();
        if (!Array.isArray(data)) {
            console.log("Errore");
            return null;
        }
        let vett=[];
        for (let index = 0; index < data.length; index++) {
            let element = data[index];
            let porto=new Nave(element.id, element.nome);
            vett.push(porto);
        }
        return vett;
    } catch (error) {
        console.log("Errore nella fetch:", error);
        return null;
    }
}

async function addViaggio(dp, da, pp, pa, d, add, nav) {
    let url = "http://localhost:8080/viaggio/aggiungi?dp="+dp+"&da="+da+"&pp="+pp+"&pa="+pa+"&d="+d+"&add="+add;
    try {
        let response = await fetch(url);
        let testo = await response.text();
        if(testo == "ok"){
            let id_viaggio=getIdViaggio(dp, da, pp, pa, d, add);
            if (id_viaggio==-1) {
                return "errore";
            }
            if(addViaggioRegistrato(nav, id_viaggio)=="ok"){
                return "ok";
            }
            return "errore";
        }
        return  "errore";
    } catch (error) {
        console.log("Errore nella fetch:", error);
        return "errore";
    }
}

async function addViaggioRegistrato(id_nave, id_viaggio) {
    let url = "http://localhost:8080/viaggiRegistrati/aggiung?id_nave?="+id_nave+"&id_viaggio="+id_viaggio;
    try {
        let response = await fetch(url);
        let testo = await response.text();
        if(testo == "ok"){
            return  "ok";
        }
        return  "errore";
    } catch (error) {
        console.log("Errore nella fetch:", error);
        return "errore";
    }
}

async function getIdViaggio(dp, da, pp, pa, d, add) {
    let url = "http://localhost:8080/viaggio/ottieni?dp="+dp+"&da="+da+"&pp="+pp+"&pa="+pa+"&d="+d+"&add="+add;
    try {
        let response = await fetch(url);
        let testo = await response.text();
        if(testo != -1){
            return  testo;
        }
        return -1;
    } catch (error) {
        console.log("Errore nella fetch:", error);
        return -1;
    }
}

async function addPolizza(q, v, m, f, add, d) {
    let url = "http://localhost:8080/polizza/aggiungi?q="+q+"&v="+v+"&m="+m+"&f="+f;
    try {
        let response = await fetch(url);
        let testo = await response.text();
        if(testo == "ok"){
            if(addMagazzino(q, m ,add, d)=="ok"){
                return "ok";
            }
            return "errore";
        }
        return  "errore";
    } catch (error) {
        console.log("Errore nella fetch:", error);
        return "errore";
    }
}

async function addMagazzino(q, m, add, d) {
    let url = "http://localhost:8080/magazzino/inserisci/q?="+q+"&m="+m+"&a="+add+"&d="+d;
    try {
        let response = await fetch(url);
        let testo = await response.text();
        if(testo == "ok"){
            return  "ok";
        }
        return  "errore";
    } catch (error) {
        console.log("Errore nella fetch:", error);
        return "errore";
    }
}


async function getFornitori() {
    let url = "http://localhost:8080/fornitore/ottieni";
    try {
        let response = await fetch(url);
        let data = await response.json();
        if (!Array.isArray(data)) {
            console.log("Errore");
            return null;
        }
        let vett=[];
        for (let index = 0; index < data.length; index++) {
            let element = data[index];
            let fornitore=new Fornitore(element.id, element.username, element.password, element.nome);
            vett.push(fornitore);
        }
        return vett;
    } catch (error) {
        console.log("Errore nella fetch:", error);
        return null;
    }
}

async function getViaggiDati() {
    let url = "http://localhost:8080/viaggiReggistrati/ottieni";
    try {
        let response = await fetch(url);
        let testo = await response.text();
        if(testo != ""){
            let vett=[];
            for (let index = 0; index < data.length; index++) {
                let element = data[index];
                vett.push(element);
            }
            return  vett;
        }
        return "errore";
    } catch (error) {
        console.log("Errore nella fetch:", error);
        return "errore";
    }
}


