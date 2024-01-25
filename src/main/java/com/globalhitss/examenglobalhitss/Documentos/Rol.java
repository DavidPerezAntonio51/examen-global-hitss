package com.globalhitss.examenglobalhitss.Documentos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("DROLES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rol {
    @Id
    private String id;
    private String rol;
}
