package br.com.fiap.aime.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Digits;
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
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotBlank
    @Size(min = 3, message = "Precisa conter um nome com no minimo 3 caracteres")
    private String nome;

    @NotBlank
    @Size(min = 2, message = "precisa conter no minimo 2 caracteres")
    private String descricao;

    @NotBlank
    @Size(max = 5)
    private int estrelas;

    @NotBlank
    @PositiveOrZero
    private int numeroAvaliacoes;

    @NotBlank
    @Digits(integer = 10, fraction = 2)
    private int preco;

    @NotBlank
    @Digits(integer = 10, fraction = 2)
    private int precoFrete;

    // RELACIONAMENTOS

    @ManyToOne // (cascade = CascadeType.MERGE)
    @JoinColumn // (name = "ID_CATEGORIA", nullable = false)
    private Categoria categoria;

    @ManyToOne // (cascade = CascadeType.MERGE)
    @JoinColumn // (name = "ID_EMPRESA", nullable = false)
    private Empresa empresa;

    @ManyToOne // (cascade = CascadeType.MERGE)
    @JoinColumn // (name = "ID_TRANSPORTADORA", nullable = false)
    private Transportadora transportadora;

    @ManyToOne // (cascade = CascadeType.MERGE)
    @JoinColumn // (name = "ID_MARCA", nullable = false)
    private Marca marca;
    
    @OneToMany // (mappedBy = "produto", cascade = CascadeType.MERGE)
    private List<Compra> compras = new ArrayList<Compra>();
}