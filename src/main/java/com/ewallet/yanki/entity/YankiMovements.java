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
@Document(value = "YANKI-MOVEMENTS")
public class YankiMovements {
     
	@Id
    private String  id;            // identificador del movimiento
	private String documentNumber; // identificador del cliente
	private String status;         // recibido(+) - entregado(-)
	private Double amount;         // monto de la transferencia
	@JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dateStar;    // Fecha de la transaccion
	private String nameClient;     // Nombre de persona de transferencia recibido o entregado
	
}
