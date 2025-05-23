package progetto_terminal_marittimo.controller;

import org.springframework.web.bind.annotation.*;

import progetto_terminal_marittimo.Dao.personaleDao;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/personale")
public class personaleController {

    @Autowired
    private personaleDao personaleDao;

    
    @GetMapping("/addPersonale")
    public String addPersonale(@RequestParam String username,  @RequestParam String password, @RequestParam String ruolo, @RequestParam String nome, @RequestParam String passwordAddetto, @RequestParam String ruoloAddetto) {
     
        if (personaleDao.trovaAddetto(username, password).size()==0 || !ruolo.equals("Admin")) {
            return "errore";
        }
        
        
        String result = personaleDao.inserisci(nome, passwordAddetto, ruoloAddetto);
        return result;
    }


    
    @GetMapping("/login")
    public Object loginAddetto(@RequestParam String username,  @RequestParam String password) {
        return personaleDao.login(username, password);
    }

    @GetMapping("/ottieniNome")
    public String ottieniNome(@RequestParam int id) {
        return personaleDao.ottieniNome(id);
    }
}
