package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RequestMapping("pacientes")
@RestController
public class PacienteController {
    @Autowired
    PacienteRepository pacienteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPaciente dados
            , UriComponentsBuilder uriComponentsBuilder) {
        var paciente = new Paciente(dados);
        pacienteRepository.save(paciente);

        var uri = uriComponentsBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoPaciente(paciente));

    }

    @GetMapping
    public ResponseEntity<Page<DadosListaPaciente>> listarPaciente(@PageableDefault(page = 0, size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = pacienteRepository.findAllByAtivoTrue(paginacao).map(DadosListaPaciente::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var paciente = pacienteRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dados) {
        var paciente = pacienteRepository.getReferenceById(dados.id());
        paciente.atualizarInformacao(dados);

        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id) {
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.excluir();

        return ResponseEntity.noContent().build();
    }


}
