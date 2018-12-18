package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("api")
@Controller
@CrossOrigin
public class ApiController {

	@Autowired
    WordCount wordCount;
    
    @RequestMapping(path="dados", method = RequestMethod.POST)
    public ResponseEntity<List<MemoriaEquipRede>> aplicaFiltro(@RequestBody Filtro filtro) {
        return new ResponseEntity<>(wordCount.aplicaFiltro(filtro), HttpStatus.OK);
    }
    
    @RequestMapping(path="buscaQuantidadeEquipamentoPorEstado", method = RequestMethod.GET)
    public ResponseEntity<List<MemoriaDTO>> buscaQuantidadeEquipamentoPorEstado() {
        return new ResponseEntity<>(wordCount.buscaQuantidadeEquipamentoPorEstado(), HttpStatus.OK);
    }
    
    @RequestMapping(path="buscaMEdiaDeUsoPorEstado", method = RequestMethod.GET)
    public ResponseEntity<List<MemoriaDTO>> buscaMEdiaDeUsoPorEstado() {
        return new ResponseEntity<>(wordCount.buscaMEdiaDeUsoPorEstado(), HttpStatus.OK);
    }
    
	
}
