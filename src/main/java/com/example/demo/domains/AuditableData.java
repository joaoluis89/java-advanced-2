package com.example.demo.domains;

import jakarta.persistence.Embeddable;
import java.time.LocalDate;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Embeddable
@Data
public class AuditableData {

    @CreatedDate
    private LocalDate createdAt;

    @LastModifiedDate
    private LocalDate updateAt;

}
