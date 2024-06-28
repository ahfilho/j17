package br.com;


import lombok.Data;

import java.time.LocalDate;

public record TaskDto(

        String id,
        String name,
        LocalDate dayOfTask,
        String subject,
        String priority,
        String status) {
}



