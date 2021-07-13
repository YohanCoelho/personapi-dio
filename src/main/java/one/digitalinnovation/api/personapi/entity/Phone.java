package one.digitalinnovation.api.personapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import one.digitalinnovation.api.personapi.enums.PhoneType;

import javax.persistence.*;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
@Entity(name = "tb_phone")
public class Phone {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PhoneType type;

    @Column(nullable = false)
    private String number;
}
