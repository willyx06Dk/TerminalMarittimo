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
        let f = new Fornitore(data.id, data.username, data.password);
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

