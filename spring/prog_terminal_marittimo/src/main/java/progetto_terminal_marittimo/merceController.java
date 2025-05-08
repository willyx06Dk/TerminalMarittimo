package progetto_terminal_marittimo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/merce")
public class merceController {

    @Autowired
    private merceDao merciDao;

    
    @GetMapping("/registra")
    public String registraMerce(@RequestParam String nome, @RequestParam String categoria) {
     
        if (merciDao.trovaMerce(nome, categoria).size()!=0) {
            return "errore";
        }
        
        
        String result = merciDao.inserisci(nome, categoria);
        return result;
    }


    
    @GetMapping("/ottieni")
    public List<merce> ottieniMerce() {
        return merciDao.ottienimerci();
    }
}
