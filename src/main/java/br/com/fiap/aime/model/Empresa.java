package br.com.fiap.aime.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotBlank
    @Size(min = 3, message = "O nome deve conter no minimo 3 caracteres")
    private String nome;

    @Size(min = 3, message = "Deve conter no minimo 3 caracteres")
    private String nomeRazaoSocial;

    @NotBlank
    @Size(min = 3, message = "A descrição deve conter no minimo 3 caracteres")
    private String descricao;

    @NotNull
    private int numeroVendas;

    @NotNull
    private int numeroAvaliacao;

    // RELACIONAMENTOS
    @OneToMany // (mappedBy = "empresa", cascade = CascadeType.MERGE)
    private List<EnderecoEmpresa> enderecoEmpresa = new ArrayList<EnderecoEmpresa>();

    @OneToMany // (mappedBy = "empresa", cascade = CascadeType.MERGE)
    private List<Produto> produto = new ArrayList<Produto>();
    
    @OneToMany // (mappedBy = "empresa", cascade = CascadeType.MERGE)
    private List<TelefoneEmpresa> telefoneEmpresa = new ArrayList<TelefoneEmpresa>();
}
