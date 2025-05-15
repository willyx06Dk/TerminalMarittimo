package progetto_terminal_marittimo.controller;

import org.springframework.web.bind.annotation.*;

import progetto_terminal_marittimo.Dao.portoDao;
import progetto_terminal_marittimo.modal.porto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/porto")
public class portoController {

    @Autowired
    private portoDao portoDao;

    
    @GetMapping("/registra")
    public String registraPorto(@RequestParam String nome, @RequestParam String nazionalita) {
     
        if (portoDao.trovaPorto(nome, nazionalita).size()!=0) {
            return "errore";
        }
        
        
        String result = portoDao.inserisci(nome, nazionalita);
        return result;
    }


    
    @GetMapping("/ottieni")
    public List<porto> ottieniPorti() {
        return portoDao.ottieniporti();
    }
}
