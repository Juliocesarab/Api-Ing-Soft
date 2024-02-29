package com.api.model.payload;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@Builder
public class MensajesResponse implements Serializable {
    private String mensaje;
    private Object objeto;

}
