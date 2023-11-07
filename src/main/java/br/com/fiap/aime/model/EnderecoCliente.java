package br.com.fiap.aime.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
public class EnderecoCliente {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	@NotBlank
	@Size(max = 12)
	private String cep;

	@NotBlank
	@Size(max = 100, message = "Deve conter o logradouro")
	private String logradouro;

	// @NotBlank
	@Size(max = 100, message = "Deve conter o nome do bairro onde reside")
	private String bairro;

	@NotBlank
	@Size(max = 8, message = "Pais de origem")
	private String pais;

	@NotBlank
	@Size(max = 50, message = "Numero da residencia")
	private String numero;

	@Enumerated(EnumType.STRING)
	private Status status;

	@NotBlank
	@Size(max = 200, message = "Complemento de onde reside")
	private String complemento;

	// RELACIONAMENTO

	@ManyToOne // (cascade = CascadeType.MERGE)
	@JoinColumn // (name = "ID_CLIENTE", nullable = false)
	private Cliente cliente;

}
