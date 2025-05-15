package progetto_terminal_marittimo.controller;

import org.springframework.web.bind.annotation.*;

import progetto_terminal_marittimo.Dao.magazzinoDao;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/magazzino")
public class magazzinoController {

    @Autowired
    private magazzinoDao magazzinoDao;

    
    @GetMapping("/inserisci")
    public String inserisciMagazzino(@RequestParam int q, @RequestParam int m, @RequestParam int a, @RequestParam String d) {      
        String result = magazzinoDao.inserisci(q, m, a, d);
        return result;
    }

    @GetMapping("/svuota")
    public String rimuoviMerce(@RequestParam int m, @RequestParam int rimossa) {
        int id= magazzinoDao.trovaIDmagazzino(m);
        return magazzinoDao.Togli(rimossa, id);
    }
}
