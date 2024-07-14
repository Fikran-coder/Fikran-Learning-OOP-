package fikranBelajar.fikranBelajarOOP.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Integer customerId;
    @Column(
            length = 25,
            nullable = false
    )
    private String firstName;
    private String middleName;

    @Column(
            length = 25,
            nullable = false
    )
    private String lastName;
    private Integer amount;
    private LocalDateTime createdDate;
}
