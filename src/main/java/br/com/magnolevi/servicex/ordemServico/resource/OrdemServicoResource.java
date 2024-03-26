//package br.com.magnolevi.servicex.ordemServico.resource;
//
//import br.com.magnolevi.servicex.ordemServico.domain.OrdemServico;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import java.net.URI;
//
//@RestController
//@RequestMapping(value = "/orderm_servico")
//public class OrdemServicoResource {

//    @Autowired
//    private OrdemServicoService ordemServicoService;
//
//    PostMapping
//    public ResponseEntity<OrdemServico> store(@ResponseBody OrdemServico ordermServico){
//        ordermServico.store(ordermServico);
//        URI url = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ordemServicoService.getId);
//    }
//}
