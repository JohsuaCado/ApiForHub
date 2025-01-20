package forohub.api.topico;


import forohub.api.curso.Curso;
import forohub.api.dto.DatosActualizarTopico;
import forohub.api.dto.DatosRegistroTopicos;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion = LocalDateTime.now();
    private String titulo;
    private String mensaje;
    @Enumerated(EnumType.STRING)
    private Curso curso;

    public Topico(){}


    public Topico(DatosRegistroTopicos datosRegistroTopicos) {
        this.titulo=datosRegistroTopicos.titulo();
        this.mensaje=datosRegistroTopicos.mensaje();
        this.curso=datosRegistroTopicos.curso();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void actualizarTopico(DatosActualizarTopico datosActualizarTopico) {
        this.mensaje=datosActualizarTopico.mensaje();
        this.curso= Curso.valueOf(datosActualizarTopico.curso());
    }
}
