package progetto_terminal_marittimo;

import org.springframework.web.bind.annotation.*;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/magazzino")
public class magazzinoController {

    @Autowired
    private magazzinoDao magazzinoDao;

    
    @GetMapping("/inserisci")
    public String inserisciMagazzino(@RequestParam int q, @RequestParam int m, @RequestParam int a, @RequestParam Date d) {      
        String result = magazzinoDao.inserisci(q, m, a, d);
        return result;
    }

    @GetMapping("/svuota")
    public String rimuoviMerce(@RequestParam int q, @RequestParam int m, @RequestParam int a, @RequestParam Date d, @RequestParam int rimossa) {
        int id= magazzinoDao.trovaIDmagazzino(q, m, a, d);
        return magazzinoDao.modificaQ(q-rimossa, id);
    }
}
