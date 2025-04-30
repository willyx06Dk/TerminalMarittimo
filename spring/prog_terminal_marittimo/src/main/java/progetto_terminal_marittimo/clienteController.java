package progetto_terminal_marittimo;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/cliente")
public class clienteController {

    @Autowired
    private utenteDao clienteDao;

    
    @GetMapping("/registra")
    public String registraCliente(@RequestParam String nome, @RequestParam String cognome, @RequestParam String username, @RequestParam String password, @RequestParam String email, @RequestParam String codice_identificativo_carta) {
     
        if (clienteDao.trovaUtente(username, password).size()!=0) {
            return "errore";
        }
        
        
        String result = clienteDao.inserisci(nome, cognome, username, password, email, codice_identificativo_carta);
        return result;
    }


    
    @GetMapping("/login")
    public Object loginCliente(@RequestParam String username,  @RequestParam String password) {
        return clienteDao.login(username, password);
    }
}
