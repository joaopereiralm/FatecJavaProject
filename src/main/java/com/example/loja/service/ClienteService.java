import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    // "Banco de dados" em memória
    private final List<Cliente> clientes = new ArrayList<>();

    // Controle do próximo ID a ser gerado (auto-incremento)
    private Long nextId = 1L;

    public List<Cliente> listar() {
        return clientes;
    }

    public Cliente criar(Cliente c) {
        c.setId(nextId++);
        clientes.add(c);
        return c;
    }

    public Cliente buscarPorId(Long id) {
        for (Cliente c : clientes) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public boolean remover(Long id) {
        return clientes.removeIf(c -> c.getId().equals(id));
    }

    public Cliente atualizar(Long id, Cliente novo) {
        Cliente existente = buscarPorId(id);

        if (existente == null) {
            return null;
        }

        existente.setNome(novo.getNome());
        existente.setEmail(novo.getEmail());
        existente.setIdade(novo.getIdade());
        return existente;
    }
}
