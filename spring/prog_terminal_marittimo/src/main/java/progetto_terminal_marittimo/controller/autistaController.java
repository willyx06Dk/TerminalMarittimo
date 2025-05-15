package progetto_terminal_marittimo.controller;

import org.springframework.web.bind.annotation.*;

import progetto_terminal_marittimo.Dao.autistaDao;
import progetto_terminal_marittimo.modal.autista;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/autista")
public class autistaController {

    @Autowired
    private autistaDao autistaDao;

    
    @GetMapping("/ottieni")
    public List<autista> ottieniAutisti() {
        return autistaDao.ottieniAutisti();
    }
}
