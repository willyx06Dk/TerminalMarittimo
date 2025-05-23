package progetto_terminal_marittimo.controller;

import org.springframework.web.bind.annotation.*;

import progetto_terminal_marittimo.Dao.utenteDao;
import progetto_terminal_marittimo.modal.utente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/cliente")
public class utenteController {

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
    public utente loginCliente(@RequestParam String username,  @RequestParam String password) {
        return clienteDao.login(username, password);
    }

    @GetMapping("/ottieniNome")
    public String ottieniNome(@RequestParam int id) {
        return clienteDao.ottieniNome(id);
    }

    @GetMapping("/ottieni")
    public List<utente> getClienti() {
        return clienteDao.getClienti();
    }

}
