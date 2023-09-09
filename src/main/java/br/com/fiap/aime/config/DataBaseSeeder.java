package br.com.fiap.aime.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.aime.model.Categoria;
import br.com.fiap.aime.model.Cliente;
import br.com.fiap.aime.model.Compra;
import br.com.fiap.aime.model.Empresa;
import br.com.fiap.aime.model.EnderecoCliente;
import br.com.fiap.aime.model.EnderecoEmpresa;
import br.com.fiap.aime.model.EnderecoTransportadora;
import br.com.fiap.aime.model.Marca;
import br.com.fiap.aime.model.Produto;
import br.com.fiap.aime.model.Status;
import br.com.fiap.aime.model.TelefoneCliente;
import br.com.fiap.aime.model.TelefoneEmpresa;
import br.com.fiap.aime.model.TelefoneTransportadora;
import br.com.fiap.aime.model.Transportadora;
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

import java.util.List;

@Configuration
public class DataBaseSeeder implements CommandLineRunner {
    
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

        Cliente cliente1 = new Cliente(1, "Caio", "caio2132@gmail.com", "4446668881", "445556667", "@ola123", "20/09/1998",Status.I , "N/A");
        Cliente cliente2 = new Cliente(2, "Sheila", "sheila1132@gmail.com", "4446668881", "445556667", "@ola123", "20/09/1998",Status.A , "N/A");
        Cliente cliente3 = new Cliente(3, "Rubinho", "rubinho1132@gmail.com", "4446668881", "445556667", "@ola123", "20/09/1998",Status.A , "Aninha");
        clienteRepository.saveAll(List.of(cliente1, cliente2, cliente3));
        
        EnderecoCliente enderecoCliente1 = new EnderecoCliente(1, "056471", "pa nozes", "osascu", "brasil", "2", Status.A, "em frente a tristeza", cliente2);
        EnderecoCliente enderecoCliente2 = new EnderecoCliente(2, "056471", "pa nozes", "osascu", "brasil", "2", Status.A, "em frente a tristeza", cliente2);
        EnderecoCliente enderecoCliente3 = new EnderecoCliente(3, "056471", "pa nozes", "osascu", "brasil", "2", Status.A, "em frente a tristeza", cliente2);
        enderecoClienteRepository.saveAll(List.of(enderecoCliente1, enderecoCliente2, enderecoCliente3));

        TelefoneCliente telefoneCliente1 = new TelefoneCliente(1, "7893405723", "011", "+55", Status.A, cliente1);
        TelefoneCliente telefoneCliente2 = new TelefoneCliente(2, "7893405723", "011", "+55", Status.A, cliente2);
        TelefoneCliente telefoneCliente3 = new TelefoneCliente(3, "7893405723", "011", "+55", Status.A, cliente3);
        telefoneClienteRepository.saveAll(List.of(telefoneCliente1, telefoneCliente2, telefoneCliente3));

        Categoria categoria1 = new Categoria(1, "categoria1", "teste", null);
        Categoria categoria2 = new Categoria(2, "categoria2", "teste2", null);
        Categoria categoria3 = new Categoria(3, "categoria3", "teste3", null);
        categoriaRepository.saveAll(List.of(categoria1, categoria2, categoria3));

        Compra compra1 = new Compra(1, "aaaA", 15, 12937, cliente2, null);
        Compra compra2 = new Compra(2, "aaaA", 15, 12937, cliente2, null);
        Compra compra3 = new Compra(3, "aaaA", 15, 12937, cliente2, null);
        compraRepository.saveAll(List.of(compra1, compra2, compra3));

        Empresa empresa1 = new Empresa(1, "Lksad", "Ltda", "any",4, 5, null, null, null);
        Empresa empresa2 = new Empresa(2, "Lksad", "Ltda", "any",4, 5, null, null, null);
        Empresa empresa3 = new Empresa(3, "Lksad", "Ltda", "any",4, 5, null, null, null);
        empresaRepository.saveAll(List.of(empresa1, empresa2, empresa3));

        EnderecoEmpresa enderEmpresa1 = new EnderecoEmpresa(1, "056471", "pa nozes", "osascu", "brasil", "2", Status.A, "disappointed", empresa1);
        EnderecoEmpresa enderEmpresa2 = new EnderecoEmpresa(2, "056479", "pa mim", "sao berlondres", "brasil", "2", Status.I, "disappointed", empresa2);
        EnderecoEmpresa enderEmpresa3 = new EnderecoEmpresa(3, "056473", "pa eu", "osascu", "brasil", "2", Status.A, "disappointed", empresa3);
        enderecoEmpresaRepository.saveAll(List.of(enderEmpresa1, enderEmpresa2, enderEmpresa3));

        TelefoneEmpresa telEmpresa1 = new TelefoneEmpresa(1, "970704141", "011", "+55",  Status.A, empresa1);
        TelefoneEmpresa telEmpresa2 = new TelefoneEmpresa(2, "970704141", "011", "+55",  Status.A, empresa2);
        TelefoneEmpresa telEmpresa3 = new TelefoneEmpresa(3, "970704141", "011", "+55",  Status.A, empresa3);
        telefoneEmpresaRepository.saveAll(List.of(telEmpresa1, telEmpresa2, telEmpresa3));


        Transportadora transportadora1 = new Transportadora(1, "leva rápido", "dedadão", 5);
        Transportadora transportadora2 = new Transportadora(2, "leva rápido", "dedadão", 5);
        Transportadora transportadora3 = new Transportadora(3, "leva rápido", "dedadão", 5);
        transportadoraRepository.saveAll(List.of(transportadora1, transportadora2, transportadora3));
        
        TelefoneTransportadora telefoneTransportadora1 = new TelefoneTransportadora(1, "6789315243", "011", "+55", Status.A, transportadora1);
        TelefoneTransportadora telefoneTransportadora2 = new TelefoneTransportadora(2, "6789315243", "011", "+55", Status.A, transportadora2);
        TelefoneTransportadora telefoneTransportadora3 = new TelefoneTransportadora(3, "6789315243", "011", "+55", Status.A, transportadora3);
        telefoneTransportadoraRepository.saveAll(List.of(telefoneTransportadora1, telefoneTransportadora2, telefoneTransportadora3));
        
        EnderecoTransportadora enderecoTransportadora1 = new EnderecoTransportadora(1, "728374", "alou", "aslou", "brasil", "123", Status.A, "fjhse", transportadora1);
        EnderecoTransportadora enderecoTransportadora2 = new EnderecoTransportadora(2, "728374", "alou", "aslou", "brasil", "123", Status.A, "fjhse", transportadora2);
        EnderecoTransportadora enderecoTransportadora3 = new EnderecoTransportadora(3, "728374", "alou", "aslou", "brasil", "123", Status.A, "fjhse", transportadora3);
        enderecoTransportadoraRepository.saveAll(List.of(enderecoTransportadora1, enderecoTransportadora2, enderecoTransportadora3));

        Produto produto1 = new Produto(1, "entrega rápida", "butão", 4, 6, 20, 10);
        Produto produto2 = new Produto(2, "entrega rápida", "smartphone", 5, 2, 1150, 10);
        Produto produto3 = new Produto(3, "entrega rápida", "tenis", 3, 11, 70, 10);
        produtoRepository.saveAll(List.of(produto1, produto2, produto3));
        
        Marca marca1 = new Marca(1, "Nike", "Melhor nike do mundo", 5);
        Marca marca2 = new Marca(2, "Aididas", "Melhor nike do mundo", 4);
        Marca marca3 = new Marca(3, "Punas", "Melhor nike do mundo", 4);
        marcaRepository.saveAll(List.of(marca1, marca2, marca3));

    }
}
