package med.voll.api.domain.paciente;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.domain.endereco.Endereco;
@Entity(name = "Pacientes")
@Table(name = "pacientes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String telefone;

    private String cpf;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Paciente(DadosCadastroPaciente dados){
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.ativo = true;
        this.endereco = new Endereco(dados.endereco());
    }


    public void atualizarInformacao(DadosAtualizacaoPaciente dados) {
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if (dados.endereco() != null){
            endereco.atualizarInformacao(dados.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
