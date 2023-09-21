package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.infra.exception.ValidacaoException;
import org.springframework.stereotype.Service;

@Service
public class ValidadorPacienteSemOutraConsultaNoDia implements ValidadorAgendamentoDeConsulta {

    private ConsultaRepository consultaRepository;

    public void validar(DadosAgendamentoConsulta dados) {
        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);
        var pacientePossuiOutraConsaultaNoDia = consultaRepository.existyByPacienteIdAndDataBetween(dados.idPaciente()
                , primeiroHorario, ultimoHorario);
    if (pacientePossuiOutraConsaultaNoDia){
        throw new ValidacaoException("Paciente já possui uma consulta agendada nesse dia");
    }

    }
}
