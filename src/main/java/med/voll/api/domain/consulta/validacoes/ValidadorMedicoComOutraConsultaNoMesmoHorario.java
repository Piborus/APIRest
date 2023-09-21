package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.infra.exception.ValidacaoException;
import org.springframework.stereotype.Service;

@Service
public class ValidadorMedicoComOutraConsultaNoMesmoHorario implements ValidadorAgendamentoDeConsulta{


    private ConsultaRepository consultaRepository;

    public void validar(DadosAgendamentoConsulta dados){
        var medicoPossuiOutraConsultaNoMesmoHorario = consultaRepository.existsByMedicoIdAndData(dados.idMedico()
                , dados.data());
        if (medicoPossuiOutraConsultaNoMesmoHorario){
            throw new ValidacaoException("Medico ja possui outra consulta agendada nesse mesmo horario");
        }
    }
}
