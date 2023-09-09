package br.com.fiap.aime.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
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
public class Marca {
    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
    @NotBlank
    @Size(min = 3, message = "O nome deve conter no minimo 3 caracteres")
	private String nome;
	
    @NotBlank
    @Size(min = 3, message = "O nome deve conter no minimo 3 caracteres")
	private String descricao;
	
    @PositiveOrZero
	private int nota;

    //RELACIONAMENTOS

    // @OneToMany //(mappedBy = "marca", cascade = CascadeType.MERGE)
	// private List<Produto> produtos = new ArrayList<Produto>();
}
