class Viaggio {
    constructor(id, dataPartenza, dataArrivo, portoPartenza, portoArrivo, direttrice, addetto) {
        this.id = id;
        this.dataPartenza = new Date(dataPartenza); // Usa il tipo Date JS
        this.dataArrivo = new Date(dataArrivo);
        this.portoPartenza = portoPartenza;
        this.portoArrivo = portoArrivo;
        this.direttrice = direttrice;
        this.addetto = addetto;
    }

    getID() {
        return this.id;
    }

    getDataPartenza() {
        return this.dataPartenza;
    }

    getDataArrivo() {
        return this.dataArrivo;
    }

    getPortoPartenza() {
        return this.portoPartenza;
    }

    getPortoArrivo() {
        return this.portoArrivo;
    }

    getDirettrice() {
        return this.direttrice;
    }

    getAddetto() {
        return this.addetto;
    }
}
