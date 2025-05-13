package progetto_terminal_marittimo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/fornitore")
public class fornitoreController {

    @Autowired
    private fornitoreDao fornitoreDao;

    
    @GetMapping("/registra")
    public String registrafornitore(@RequestParam String nome, @RequestParam String username, @RequestParam String password, @RequestParam String email) {
     
        if (fornitoreDao.trovaFornitore(username, password).size()!=0) {
            return "errore";
        }
        
        
        String result = fornitoreDao.inserisci(nome, username, password, email);
        return result;
    }


    
    @GetMapping("/login")
    public Object loginFornitore(@RequestParam String username,  @RequestParam String password) {
        return fornitoreDao.login(username, password);
    }


    @GetMapping("/ottieni")
    public List<fornitore> getFornitori() {
        return fornitoreDao.getFornitori();
    }
}
