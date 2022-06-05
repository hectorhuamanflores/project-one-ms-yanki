package com.ewallet.yanki.dto;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class YankiRequest {
   
    private String  id;                // Identificador yanki
    private Integer mobile;            // numero movil
    private Integer documentNumber;    // Dni - Cex - pasaporte
    private Integer imei;              // imei del movil
    private String  email;             // Correo personal
    private Boolean statusAccount;     // true= saldo anexado tarjeta debito - false= saldo cero por defecto
    private String numberAccount;      // numero de cuenta
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate     dateStar;    // Fecha de creacion de la cuenta yanki
}
