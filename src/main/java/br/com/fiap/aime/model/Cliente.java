package br.com.fiap.aime.model;

import java.util.Collection;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
public class Cliente implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotBlank
    @Size(min = 3, message = "Precisa conter um nome de no minimo 3 caracteres")
	private String nome;

    @NotBlank
    // @Email(message="Por favor forneça um endereço de email valido")
    // @Pattern(regexp=".+@.+\\..+", message="Por favor forneça um endereço de email valido")
	private String email;
	
    @NotBlank
    @Size(max = 11, message = "O CPF do usuario deve conter todos os 11 digitos completos")
	private String cpf;
	
    @NotBlank
    @Size(max = 11, message = "O RG do usuario deve conter todos os 9 digitos completos")
	private String rg;
	
    @NotBlank
    // @Size(min = 6, max = 12, message = "A senha deve conter entre 6 a 12 caracteres")
	private String senha;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
	private String dtNascimento;
	
	@Enumerated(EnumType.STRING)
	private Status status;
    
    @NotBlank
    @Size(min = 3, message = "Precisa conter um nome de no minimo 3 caracteres")
	private String nomeSocial;

    //Implementando user details

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_CLIENTE"));
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    // //RELACIONAMENTOS

    // @OneToMany //(mappedBy = "cliente", cascade = CascadeType.MERGE)
	// private List<TelefoneCliente> telefoneCliente = new ArrayList<TelefoneCliente>();

	// @OneToMany //(mappedBy = "cliente", cascade = CascadeType.MERGE)
	// private List<EnderecoCliente> enderecoCliente = new ArrayList<EnderecoCliente>();

	// @OneToMany //(mappedBy = "cliente", cascade = CascadeType.MERGE)
	// private List<Compra> compras = new ArrayList<Compra>();
}
