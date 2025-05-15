package progetto_terminal_marittimo.controller;

import org.springframework.web.bind.annotation.*;

import progetto_terminal_marittimo.Dao.registroDao;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/registro")
public class registroController {

    @Autowired
    private registroDao registroDao;

    
    @GetMapping("/inserisci")
    public String inserisciMagazzino(@RequestParam String data_ritiro, @RequestParam int peso_ritirato, @RequestParam int id_autista, @RequestParam String id_camion, @RequestParam int id_cliente) {      
        String result = registroDao.inserisci(data_ritiro, peso_ritirato, id_autista, id_camion, id_cliente);
        return result;
    }
}
