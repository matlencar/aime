package br.com.fiap.aime.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Transportadora {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

    @NotBlank
    @Size(min = 3,  message = "Precisa conter um nome com no minimo 3 caracteres")
	private String nome;

    @NotBlank
    @Size(min = 2, message = "precisa conter no minimo 2 caracteres")
	private String descricao;

    @NotBlank
    @PositiveOrZero
    private int numeroNota;

    //RELACIONAMENTOS

    @OneToMany //(mappedBy = "transportadora", cascade = CascadeType.MERGE)
	private List<TelefoneTransportadora> telefoneTransportadora = new ArrayList<TelefoneTransportadora>();
	
	@OneToMany //(mappedBy = "transportadora", cascade = CascadeType.MERGE)
	private List<EnderecoTransportadora> enderecoTransportadora = new ArrayList<EnderecoTransportadora>();
	
	@OneToMany //(mappedBy = "transportadora", cascade = CascadeType.MERGE)
	private List<Produto> produtos = new ArrayList<Produto>();
}
