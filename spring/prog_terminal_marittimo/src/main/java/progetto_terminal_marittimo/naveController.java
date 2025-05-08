package progetto_terminal_marittimo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/nave")
public class naveController {

    @Autowired
    private naveDao naveDao;

    
    @GetMapping("/registra")
    public String registraMerce(@RequestParam String nome) {
     
        if (naveDao.trovaNave(nome).size()!=0) {
            return "errore";
        }
        
        
        String result = naveDao.inserisci(nome);
        return result;
    }


    
    @GetMapping("/ottieni")
    public List<nave> ottieniMerce() {
        return naveDao.ottieninavi();
    }
}
