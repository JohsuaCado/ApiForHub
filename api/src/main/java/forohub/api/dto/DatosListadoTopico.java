package forohub.api.dto;

import forohub.api.topico.Topico;

import java.time.LocalDateTime;

public record DatosListadoTopico(String titulo, String mensaje, LocalDateTime fechaCreacion, String curso) {
    public DatosListadoTopico(Topico topico){
        this(topico.getTitulo(), topico.getMensaje(),topico.getFechaCreacion(), String.valueOf(topico.getCurso()));
    }
}
