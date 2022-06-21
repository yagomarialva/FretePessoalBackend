package com.unnt.fretepessoal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacoteDashboardDTO {

    int novos;
    int viajando;
    int entregues;
    int finalizados;

}
