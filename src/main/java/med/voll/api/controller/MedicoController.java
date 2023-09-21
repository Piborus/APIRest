package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("medicos")
public class MedicoController {
    @Autowired
    MedicoRepository medicoRepository;

    @Transactional
    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico dados
            , UriComponentsBuilder uriComponentsBuilder) {
        var medico = new Medico(dados);
        medicoRepository.save(medico);

        var uri = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListaMedico>> listar(@PageableDefault(page = 0, size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = medicoRepository.findAllByAtivoTrue(paginacao).map(DadosListaMedico::new);
        return ResponseEntity.ok(page);
    }
    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var medico = medicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

    /*@GetMapping
    public List<DadosListaMedico> listar(){
        return repository.findAll().stream().map(DadosListaMedico::new).toList();
    }*/

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) {
        var medico = medicoRepository.getReferenceById(dados.id());
        medico.atualizarInformacao(dados);

        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

    //Usando Exclusão Logica
    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id) {
        var medico = medicoRepository.getReferenceById(id);
        medico.excluir();

        return ResponseEntity.noContent().build();
    }

    //Usando Parametro dinamico
    /*@Transactional
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }*/

}
