package com.globalhitss.examenglobalhitss.Documentos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("DUSUARIO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    private String id;
    private String nombre;
    @JsonProperty("aPaterno")
    private String aPaterno;
    @JsonProperty("aMaterno")
    private String aMaterno;
    @DBRef
    private List<Rol> roles;
}
