package one.digitalinnovation.api.personapi.controller.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class StandardError implements Serializable {
    private static final long serialVersionUID = 1L;

    private LocalDateTime timestamp;
    private Integer status;
    private String error;
}
