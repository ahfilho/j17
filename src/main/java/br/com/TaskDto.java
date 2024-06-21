package br.com;


import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskDto {

    private Long id;
    private String name;
    private LocalDate dayOfTask;
    private String subject;
    private String priority;
    private String status;


}
