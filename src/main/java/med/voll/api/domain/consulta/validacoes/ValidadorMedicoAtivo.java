package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.infra.exception.ValidacaoException;
import org.springframework.stereotype.Service;

@Service
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsulta {

    private MedicoRepository medicoRepository;

    public void validar(DadosAgendamentoConsulta dados){
        if(dados.idMedico() == null){
            return;
        }

        var medicoEstaAtivo = medicoRepository.findAtivoByid(dados.idMedico());
        if (!medicoEstaAtivo){
            throw new ValidacaoException("Consulta não pode ser agendada com medico");
        }
    }
}
