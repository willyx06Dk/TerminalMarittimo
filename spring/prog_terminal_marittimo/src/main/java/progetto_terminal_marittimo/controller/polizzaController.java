package progetto_terminal_marittimo.controller;

import org.springframework.web.bind.annotation.*;

import progetto_terminal_marittimo.Dao.polizzaDao;
import progetto_terminal_marittimo.modal.polizza;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/polizza")
public class polizzaController {

    @Autowired
    private polizzaDao polizzaDao;

    
    @GetMapping("/aggiungi")
    public String registraPolizza(@RequestParam int q, @RequestParam int v, @RequestParam int m, @RequestParam int f) {
     
        if (polizzaDao.trovaPolizza(q, v, m, f).size()!=0) {
            return "errore";
        }
        
        
        String result = polizzaDao.inserisci(q, v, m, f);
        return result;
    }


    
    @GetMapping("/ottieni")
    public List<polizza> ottieniPolizzeFornitore(@RequestParam int f) {
        return polizzaDao.ottieniPolizzaFornitore(f);
    }
}
