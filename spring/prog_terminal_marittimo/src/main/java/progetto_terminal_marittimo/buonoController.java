package progetto_terminal_marittimo;

import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/buono")
public class buonoController {

    @Autowired
    private buonoDao buonoDao;

    @GetMapping("/inserisci")
    public String inserisciBuono(@RequestParam int quantita, @RequestParam Date data,@RequestParam int id_emittente, @RequestParam int id_cliente,@RequestParam int id_merce) {  
        return buonoDao.inserisci(quantita, data, id_emittente, id_cliente, id_merce);
    }

    @GetMapping("/rimuovi")
    public String rimuoviBuono(@RequestParam int id) {
        return buonoDao.eliminaBuono(id);
    }

    @GetMapping("/ottieni")
    public List<buono> ottieniBuoni(@RequestParam int id) {
        return buonoDao.ottieniBuoni(id);
    }
}
