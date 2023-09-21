package med.voll.api.domain.medico;

import jakarta.validation.constraints.NotNull;

public record DadosListaMedico(
        @NotNull
        Long id,
        String nome,
        String email,
        String crm,
        Especialidade especialidade
) {

    public DadosListaMedico(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
