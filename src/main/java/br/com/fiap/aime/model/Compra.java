package br.com.fiap.aime.model;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotBlank
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date data;

    @NotBlank
    private int hora;

    @NotBlank
    private int numeroPedido;

    // RELACIONAMENTOS
    @ManyToOne // (cascade = CascadeType.MERGE)
    @JoinColumn // (name = "ID_CLIENTE", nullable = false)
    private Cliente cliente;

    @ManyToOne // (cascade = CascadeType.MERGE)
    @JoinColumn // (name = "ID_PRODUTO", nullable = false)
    private Produto produto;

}
