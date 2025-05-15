class ViaggiRegistrati {
    constructor(dataPartenza, dataArrivo, portoPartenza, portoArrivo, direttrice, addetto, nomeNave) {
        this.nomeNave = nomeNave;
        this.data_partenza = new Date(dataPartenza);
        this.data_arrivo = new Date(dataArrivo);
        this.porto_partenza = portoPartenza;
        this.porto_arrivo = portoArrivo;
        this.direttrice = direttrice;
        this.addetto = addetto;
    }

    getNome() {
        return this.nomeNave;
    }

    getDataPartenza() {
        return this.data_partenza;
    }

    getDataArrivo() {
        return this.data_arrivo;
    }

    getPortoPartenza() {
        return this.porto_partenza;
    }

    getPortoArrivo() {
        return this.porto_arrivo;
    }

    getDirettrice() {
        return this.direttrice;
    }

    getAddetto() {
        return this.addetto;
    }

    toString() {
        return "Viaggio con nave: " + this.nomeNave +", partenza: " + this.data_partenza.toISOString().split("T")[0] +", arrivo: " + this.data_arrivo.toISOString().split("T")[0] +", porto partenza: " + this.porto_partenza +", porto arrivo: " + this.porto_arrivo +", direttrice: " + this.direttrice +", addetto: " + this.addetto;
    }
}



