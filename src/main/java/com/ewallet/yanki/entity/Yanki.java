package com.ewallet.yanki.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Document(value = "YANKI")
public class Yanki {

    @Id
    private String  id;                // Identificador yanki
    private Integer mobile;            // numero movil
    private Integer documentNumber;    // Dni - Cex - pasaporte
    private Integer imei;              // imei del movil
    private String  email;             // Correo personal
    private Boolean statusAccount;     // true= saldo anexado tarjeta debito - false= saldo cero por defecto
    private String numberAccount;      // numero de cuenta
    private Double balance;            // Saldo de la cuenta -1 = saldo anexado tarjeta debito
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate     dateStar;    // Fecha de creacion de la cuenta yanki
    
}
