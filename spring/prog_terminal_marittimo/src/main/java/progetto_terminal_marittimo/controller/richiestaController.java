package progetto_terminal_marittimo.controller;

import org.springframework.web.bind.annotation.*;

import progetto_terminal_marittimo.Dao.richiestaDao;
import progetto_terminal_marittimo.modal.richiesta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/richiesta")
public class richiestaController {

    @Autowired
    private richiestaDao richiestaDao;

    
    @GetMapping("/inserisci")
    public String inserisciRichiesta(@RequestParam int id_c, @RequestParam int id_m, @RequestParam int q) {      
        String result = richiestaDao.inserisci(id_c, id_m, q);
        return result;
    }

    @GetMapping("/rimuovi")
    public String rimuoviRichiesta(@RequestParam int id) {
        return richiestaDao.eliminaRichiesta(id);
    }

    @GetMapping("/ottieni")
    public List<richiesta> ottieniRichieste() {
        return richiestaDao.ottieniRichieste();
    }
}
