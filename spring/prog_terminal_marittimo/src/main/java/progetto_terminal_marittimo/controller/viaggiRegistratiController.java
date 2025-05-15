package progetto_terminal_marittimo.controller;

import org.springframework.web.bind.annotation.*;

import progetto_terminal_marittimo.Dao.viaggiRegistratiDao;
import progetto_terminal_marittimo.modal.viaggiRegistrati;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/viaggiRegistrati")
public class viaggiRegistratiController {

    @Autowired
    private viaggiRegistratiDao viaggiRegistratiDao;

    
    @GetMapping("/aggiungi")
    public String aggiungiViaggi(@RequestParam int id_nave, @RequestParam int id_viaggio) {
        String result = viaggiRegistratiDao.inserisci(id_nave, id_viaggio);
        return result;
    }


    
    @GetMapping("/ottieni")
    public List<viaggiRegistrati> ottieniViaggi() {
        return viaggiRegistratiDao.getViaggi();
    }
}
