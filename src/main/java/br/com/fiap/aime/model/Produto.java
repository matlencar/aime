package br.com.fiap.aime.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @Size(max = 200, message = "Precisa conter um nome com no minimo 3 caracteres")
    private String nome;

    @NotBlank
    @Size(max = 200, message = "precisa conter no minimo 2 caracteres")
    private String descricao;

    @NotNull
    // @Size(max = 5)
    private int estrelas;

    @NotNull
    @PositiveOrZero
    private int numeroAvaliacoes;

    @NotNull
    @Digits(integer = 10, fraction = 2)
    private int preco;

    @NotNull
    @Digits(integer = 10, fraction = 2)
    private int precoFrete;

    // RELACIONAMENTOS

    // @ManyToOne // (cascade = CascadeType.MERGE)
    // @JoinColumn // (name = "ID_CATEGORIA", nullable = false)
    // private Categoria categoria;

    // @ManyToOne // (cascade = CascadeType.MERGE)
    // @JoinColumn // (name = "ID_EMPRESA", nullable = false)
    // private Empresa empresa;

    // @ManyToOne // (cascade = CascadeType.MERGE)
    // @JoinColumn // (name = "ID_TRANSPORTADORA", nullable = false)
    // private Transportadora transportadora;

    // @ManyToOne // (cascade = CascadeType.MERGE)
    // @JoinColumn // (name = "ID_MARCA", nullable = false)
    // private Marca marca;
    
    // @OneToMany // (mappedBy = "produto", cascade = CascadeType.MERGE)
    // private List<Compra> compras = new ArrayList<Compra>();
}