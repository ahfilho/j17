package br.com.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "TB_TASK")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Task {

    @Id
    private String id; //mongo usa string por patrão oada ID

    @NotBlank
    private String name;

    private LocalDate dayOfTask;

    @NotBlank
    private String subject;

    @NotBlank
    private String priority;

    @NotBlank
    private String status;

    private boolean notification;
}