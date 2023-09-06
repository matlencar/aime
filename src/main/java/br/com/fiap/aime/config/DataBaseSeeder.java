package br.com.fiap.aime.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.aime.model.Cliente;
import br.com.fiap.aime.model.Status;
import br.com.fiap.aime.model.TelefoneCliente;
import br.com.fiap.aime.repository.CategoriaRepository;
import br.com.fiap.aime.repository.ClienteRepository;
import br.com.fiap.aime.repository.CompraRepository;
import br.com.fiap.aime.repository.EmpresaRepository;
import br.com.fiap.aime.repository.EnderecoClienteRepository;
import br.com.fiap.aime.repository.EnderecoEmpresaRepository;
import br.com.fiap.aime.repository.EnderecoTransportadoraRepository;
import br.com.fiap.aime.repository.MarcaRepository;
import br.com.fiap.aime.repository.ProdutoRepository;
import br.com.fiap.aime.repository.TelefoneClienteRepository;
import br.com.fiap.aime.repository.TelefoneEmpresaRepository;
import br.com.fiap.aime.repository.TelefoneTransportadoraRepository;
import br.com.fiap.aime.repository.TransportadoraRepository;

@Configuration
public class DataBaseSeeder implements CommandLineRunner {

    TelefoneCliente telCliente;
    
    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    CompraRepository compraRepository;
    
    @Autowired
    EmpresaRepository empresaRepository;
    
    @Autowired
    EnderecoClienteRepository enderecoClienteRepository;
    
    @Autowired
    EnderecoEmpresaRepository enderecoEmpresaRepository;
    
    @Autowired
    EnderecoTransportadoraRepository enderecoTransportadoraRepository;
    
    @Autowired
    MarcaRepository marcaRepository;
    
    @Autowired
    ProdutoRepository produtoRepository;
    
    @Autowired
    TelefoneClienteRepository telefoneClienteRepository;
    
    @Autowired
    TelefoneEmpresaRepository telefoneEmpresaRepository;

    @Autowired
    TelefoneTransportadoraRepository telefoneTransportadoraRepository;

    @Autowired
    TransportadoraRepository transportadoraRepository;

    @Override
    public void run(String... args) throws Exception{

        Cliente cleinte1 = new Cliente(1, "Caio", "caio2132@gmail.com", "4446668881", "445556667", "@ola123", "20/09/1998",Status.I , "N/A", null, null, null);

        Cliente cleinte2 = new Cliente(2, "Sheila", "sheila1132@gmail.com", "4446668881", "445556667", "@ola123", "20/09/1998",Status.A , "N/A", null, null, null);
    
        Cliente cleinte3 = new Cliente(3, "Rubinho", "rubinho1132@gmail.com", "4446668881", "445556667", "@ola123", "20/09/1998",Status.A , "Aninha", null, null, null);
    }
}
