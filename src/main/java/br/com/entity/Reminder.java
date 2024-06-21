package br.com.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "TB_REMINDER")
public class Reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    LocalDate dayOfReminder;

    @NotBlank
    String subject;

    @NotBlank
    String category;

    @NotBlank
    String priority;

    String notification;

}
