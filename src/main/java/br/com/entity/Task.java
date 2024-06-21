package br.com.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;
import java.time.LocalDate;

//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//@Entity
@Document(collection = "TB_TASK")
public class Task {

    @Id
    String id; //mongo usa string por patrão oada ID

    @NotBlank
    String name;

    LocalDate dayOfTask;

    @NotBlank
    String subject;

    @NotBlank
    String priority;

    @NotBlank
    String status;

    boolean notification;
}
