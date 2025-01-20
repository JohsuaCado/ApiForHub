package forohub.api.controller;


import forohub.api.dto.DatosActualizarTopico;
import forohub.api.dto.DatosListadoTopico;
import forohub.api.dto.DatosRegistroTopicos;
import forohub.api.dto.DatosRespuestaTopico;
import forohub.api.repository.TopicoRepository;
import forohub.api.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registraTopico(@RequestBody @Valid DatosRegistroTopicos datosRegistroTopicos,
                                         UriComponentsBuilder uriComponentsBuilder){
        Topico topico=topicoRepository.save(new Topico(datosRegistroTopicos));
        DatosRespuestaTopico datosRespuestaTopico=new DatosRespuestaTopico(topico.getTitulo(),topico.getMensaje(),topico.getFechaCreacion(),
                topico.getCurso().toString());
        URI url=uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>>listadoTopicos(Pageable paginacion){
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosListadoTopico::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> retornaDatosTopico(@PathVariable Long id){
        Topico topico=topicoRepository.getReferenceById(id);
        var datosTopico = new DatosRespuestaTopico(topico.getTitulo(),topico.getMensaje(),topico.getFechaCreacion(),
                topico.getCurso().toString());
        return ResponseEntity.ok(datosTopico);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Topico topico=topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarTopico(datosActualizarTopico);
        return ResponseEntity.ok(new DatosRespuestaTopico(topico.getTitulo(),topico.getMensaje(),
                topico.getFechaCreacion(),topico.getCurso().toString()));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        Topico topico=topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
        return ResponseEntity.noContent().build();
    }

}
