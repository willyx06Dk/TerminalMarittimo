package progetto_terminal_marittimo;

import org.springframework.web.bind.annotation.*;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/viaggio")
public class viaggioController {

    @Autowired
    private viaggioDao viaggioDao;

    
    @GetMapping("/aggiungi")
    public String aggiungiViaggio(@RequestParam Date dp, @RequestParam Date da, @RequestParam int pp, @RequestParam int pa, @RequestParam String d, @RequestParam int add) {
        String result = viaggioDao.inserisci(dp, da, pp, pa, d, add);
        return result;
    }


    
    @GetMapping("/ottieni")
    public int ottieniViaggio(@RequestParam Date dp, @RequestParam Date da, @RequestParam int pp, @RequestParam int pa, @RequestParam String d, @RequestParam int add) {
        return viaggioDao.getIdViaggio(dp, da, pp, pa, d, add);
    }
}
