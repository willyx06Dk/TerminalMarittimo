package progetto_terminal_marittimo.controller;

import org.springframework.web.bind.annotation.*;

import progetto_terminal_marittimo.Dao.camionDao;
import progetto_terminal_marittimo.modal.camion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/camion")
public class camionController {

    @Autowired
    private camionDao camionDao;

    
    @GetMapping("/ottieni")
    public List<camion> ottieniCamion() {
        return camionDao.ottienicamion();
    }
}
