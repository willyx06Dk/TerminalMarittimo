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
        if (testo === "ok") {
            return "ok";
        }
        return "errore";
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
        if (testo === "ok") {
            return "ok";
        }
        return "errore";
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
        if (testo === "ok") {
            return "ok";
        }
        return "errore";
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
        if (testo === "ok") {
            return "ok";
        }
        return "errore";
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
        if (testo === "ok") {
            return "ok";
        }
        return "errore";
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
        if (testo === "ok") {
            return "ok";
        }
        return "errore";
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
        let vett = [];
        for (let index = 0; index < data.length; index++) {
            let element = data[index];
            let porto = new Porto(element.id, element.nome, element.nazionalita);
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
        let vett = [];
        for (let index = 0; index < data.length; index++) {
            let element = data[index];
            let merce = new Merce(element.id, element.nome, element.categoria);
            vett.push(merce);
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
        let vett = [];
        for (let index = 0; index < data.length; index++) {
            let element = data[index];
            let nave = new Nave(element.id, element.nome);
            vett.push(nave);
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
        if (testo == "ok") {
            let id_viaggio = await getIdViaggio(dp, da, pp, pa, d, add);
            if (id_viaggio == -1) 
                return "errore";

            let prosegui = await addViaggioRegistrato(nav, id_viaggio);
            if(prosegui !="ok"){
                return "errore";
            }
            return "ok";
        }
        return "errore";
    } catch (error) {
        console.log("Errore nella fetch:", error);
        return "errore";
    }
}


async function addViaggioRegistrato(id_nave, id_viaggio) {
    let url = "http://localhost:8080/viaggiRegistrati/aggiungi?id_nave="+id_nave+"&id_viaggio="+id_viaggio;
    try {
        let response = await fetch(url);
        let testo = await response.text();
        console.log(testo);
        if(testo !="ok"){
            return "errore";
        }
        return "ok";
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
        if (testo !== "-1") {
            return testo;
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
        if (testo === "ok") {
            let result = await addMagazzino(q, m, add, d);
            if (result === "ok") {
                return "ok";
            }
            return "errore";
        }
        return "errore";
    } catch (error) {
        console.log("Errore nella fetch:", error);
        return "errore";
    }
}

async function addMagazzino(q, m, add, d) {
    let url = "http://localhost:8080/magazzino/inserisci?q="+q+"&m="+m+"&a="+add+"&d="+d;
    try {
        let response = await fetch(url);
        let testo = await response.text();
        return testo === "ok" ? "ok" : "errore";
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
        let vett = [];
        for (let index = 0; index < data.length; index++) {
            let element = data[index];
            let fornitore = new Fornitore(element.id, element.username, element.password, element.nome);
            vett.push(fornitore);
        }
        return vett;
    } catch (error) {
        console.log("Errore nella fetch:", error);
        return null;
    }
}

async function getViaggiDati() {
    let url = "http://localhost:8080/viaggiRegistrati/ottieni";
    try {
        let response = await fetch(url);
        let testo = await response.text();
        if (testo !== "") {
            let data = JSON.parse(testo);
            let vett = [];
            for (let i = 0; i < data.length; i++) {
                let el = data[i];
                let v=new ViaggiRegistrati(el.dataPartenza, el.dataArrivo, el.portoPartenza, el.portoArrivo, el.direttrice, el.addetto, el.nome);
                vett.push(v.toString());
            }
            return vett;
        }
        return "errore";
    } catch (error) {
        console.log("Errore nella fetch:", error);
        return "errore";
    }
}




async function addRichiesta(id_c, id_m, q) {
    let url = "http://localhost:8080/richiesta/inserisci?id_c="+id_c+"&id_m="+id_m+"&q="+q;
    try {
        let response = await fetch(url);
        let testo = await response.text();
        if (testo === "ok") {
            return "ok";
        }
        return "errore";
    } catch (error) {
        console.log("Errore nella fetch:", error);
        return "errore";
    }
}

async function addBuono(quantita, data, id_emittente, id_cliente, id_merce, id_richiesta) {
    let url = "http://localhost:8080/buono/inserisci?quantita="+quantita+"&data="+data+"&id_emittente="+id_emittente+"&id_cliente="+id_cliente+"&id_merce="+id_merce;
    try {
        let response = await fetch(url);
        let testo = await response.text();
        if (testo === "ok") {
            let str=await cancellaRichiesta(id_richiesta);
            if (str === "ok") {
                let prosegui= await svuotaMagazzino(id_merce, quantita);
                if(prosegui=== "ok"){
                    return "ok";
                }
                return "errore";
            }
            return "errore";
        }
        return "errore";
    } catch (error) {
        console.log("Errore nella fetch:", error);
        return "errore";
    }
}

async function getBuoniCliente(id) {
    let url = "http://localhost:8080/buono/ottieni?id="+id;
    try {
        let response = await fetch(url);
        let testo = await response.text();
        if (testo !== "") {
            let data = JSON.parse(testo);
            let vett = [];
            console.log(data)

            for (let element of data) {
                let nomeMerce = await getNomeMerce(element.id_merce);
                let nomeEmittente = await getNomeEmittente(element.id_emittente);
                let buono = new Buono(element.id, element.quantita_merce, element.data_rilascio, nomeEmittente, element.id_cliente, nomeMerce);
                vett.push(buono);
            }

            return vett;
        }
        return "errore";
    } catch (error) {
        console.log("Errore nella fetch:", error);
        return "errore";
    }
}


async function getNomeMerce(id) {
    let url = "http://localhost:8080/merce/ottieniNome?id="+id;
    try {
        let response = await fetch(url);
        let testo = await response.text();
        if (testo !== "") {
            return testo;
        }
        return "";
    } catch (error) {
        console.log("Errore nella fetch:", error);
        return "";
    }
}

async function getNomeEmittente(id) {
    let url = "http://localhost:8080/personale/ottieniNome?id="+id;
    try {
        let response = await fetch(url);
        let testo = await response.text();
        if (testo !== "") {
            return testo;
        }
        return "";
    } catch (error) {
        console.log("Errore nella fetch:", error);
        return "";
    }
}

async function getNomeCliente(id) {
    let url = "http://localhost:8080/cliente/ottieniNome?id="+id;
    try {
        let response = await fetch(url);
        let testo = await response.text();
        if (testo !== "") {
            return testo;
        }
        return "";
    } catch (error) {
        console.log("Errore nella fetch:", error);
        return "";
    }
}

async function getRichieste() {
    let url = "http://localhost:8080/richiesta/ottieni";
    try {
        let response = await fetch(url);
        let testo = await response.text();
        if (testo !== "") {
            let data = JSON.parse(testo);
            let vett = [];
            for (let index = 0; index < data.length; index++) {
                let element = data[index];
                let richiesta = new Richiesta(element.id, element.id_cliente, element.id_merce, element.quantita);
                vett.push(richiesta);
            }
            return vett;
        }
        return "errore";
    } catch (error) {
        console.log("Errore nella fetch:", error);
        return "errore";     
    }
}

async function getViaggi() {
    let url = "http://localhost:8080/viaggio/ottieniViaggi";
    try {
        let response = await fetch(url);
        let data = await response.json();
        if (!Array.isArray(data)) {
            console.log("Errore: la risposta non è un array");
            return null;
        }
        let vett = [];
        for (let index = 0; index < data.length; index++) {
            let element = data[index];
            let viaggio = new Viaggio(element.id,element.dataPartenza,element.dataArrivo,element.portoPartenza,element.portoArrivo,element.direttrice,element.addetto);
            vett.push(viaggio);
        }
        return vett;
    } catch (error) {
        console.error("Errore durante il recupero dei viaggi:", error);
        return null;
    }
}

async function getPolizza(idFornitore) {
    let url = "http://localhost:8080/polizza/ottieni?f=" + idFornitore;
    try {
        let response = await fetch(url);
        let testo = await response.text();
        if (testo !== "") {
            let data = JSON.parse(testo);
            let vett = [];
            console.log(data);

            for (let element of data) {
                let nomeMerce = await getNomeMerce(element.merce);
                let polizza = new Polizza(element.id, element.quantita, element.viaggio, nomeMerce, element.fornitore);
                vett.push(polizza);
            }
            return vett;
        }
        return "errore";
    } catch (error) {
        console.log("Errore nella fetch:", error);
        return "errore";
    }
}

async function cancellaRichiesta(id) {
        console.log(id);
    let url = "http://localhost:8080/richiesta/rimuovi?id="+id;
    try {
        let response = await fetch(url);
        let testo = await response.text();
        if (testo === "ok") {
            return "ok";
        }
        return "errore";
    } catch (error) {
        console.log("Errore nella fetch:", error);
        return "errore";
    }
}

async function svuotaMagazzino(id_merce, q) {
    let url = "http://localhost:8080/magazzino/svuota?m="+id_merce+"&rimossa="+q;
    try {
        let response = await fetch(url);
        let testo = await response.text();
        if (testo === "ok") {
            return "ok";
        }
        return "errore";
    } catch (error) {
        console.log("Errore nella fetch:", error);
        return "errore";
    }
}

async function getAutisti() {
    let url = "http://localhost:8080/autista/ottieni";
    try {
        let response = await fetch(url);
        let testo = await response.text();
        if (testo !== "") {
            let data = JSON.parse(testo);
            let vett = [];

            for (let element of data) {
                let autista = new Autista(element.id, element.nome, element.cognome, element.email);
                vett.push(autista);
            }
            return vett;
        }
        return "errore";
    } catch (error) {
        console.log("Errore nella fetch autisti:", error);
        return "errore";
    }
}

async function getCamion() {
    let url = "http://localhost:8080/camion/ottieni";
    try {
        let response = await fetch(url);
        let testo = await response.text();
        if (testo !== "") {
            let data = JSON.parse(testo);
            let vett = [];
            console.log(data);

            for (let element of data) {
                let camion = new Camion(element.targa, element.modello);
                vett.push(camion);
            }
            return vett;
        }
        return "errore";
    } catch (error) {
        console.log("Errore nella fetch camion:", error);
        return "errore";
    }
}

async function getClienti() {
    let url = "http://localhost:8080/cliente/ottieni";
    try {
        let response = await fetch(url);
        let testo = await response.text();
        if (testo !== "") {
            let data = JSON.parse(testo);
            let vett = [];
            for (let element of data) {
                let cliente = new Cliente(element.id, element.username, element.password);
                vett.push(cliente);
            }
            return vett;
        }
        return "errore";
    } catch (error) {
        console.log("Errore nella fetch clienti:", error);
        return "errore";
    }
}

async function addRegistro(data, peso, idAutista, idCamion, idCliente, id_buono) {
    let url = "http://localhost:8080/registro/inserisci?data_ritiro="+data+"&peso_ritirato="+peso+"&id_autista="+idAutista+"&id_camion="+idCamion+"&id_cliente="+idCliente;
    try {
        let response = await fetch(url);
        let testo = await response.text();
        if (testo === "ok") {
            let str=await cancellaBuono(id_buono);
            if (str === "ok") {
                return "ok";
            }
            return "errore";
        }
        return "errore";
    } catch (error) {
        console.log("Errore nella fetch:", error);
        return "errore";
    }
}


async function cancellaBuono(id) {
    let url = "http://localhost:8080/buono/rimuovi?id="+id;
    try {
        let response = await fetch(url);
        let testo = await response.text();
        if (testo === "ok") {
            return "ok";
        }
        return "errore";
    } catch (error) {
        console.log("Errore nella fetch:", error);
        return "errore";
    }
}


