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
public class TelefoneEmpresa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
    @NotBlank
    // @Pattern(regexp = "\\s\\d{5}-\\d{4}")
	private String telefone;
	
    @NotBlank
    // @Pattern(regexp = "\\(\\d{2}\\)")
	private String ddd;
	
    @NotBlank
    // @Pattern(regexp = "\\(\\d{2}\\)")
	private String ddi;
	
	@Enumerated(EnumType.STRING)
	private Status status;

    //RELACIONAMENTOS

    @ManyToOne //(cascade = CascadeType.MERGE)
	@JoinColumn //(name = "ID_EMPRESA", nullable = false)
	private Empresa empresa;
}
