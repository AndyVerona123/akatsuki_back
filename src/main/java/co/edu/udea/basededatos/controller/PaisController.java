package co.edu.udea.basededatos.controller;

import co.edu.udea.basededatos.facade.PaisFacade;
import co.edu.udea.basededatos.modelo.PaisDTO;
import co.edu.udea.basededatos.util.Messages;
import co.edu.udea.basededatos.util.StandardResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/pais")
public class PaisController {

    private final PaisFacade paisFacade;
    private final Messages messages;

    public PaisController(PaisFacade paisFacade, Messages messages) {
        this.paisFacade = paisFacade;
        this.messages = messages;
    }

    @PostMapping
    @ApiOperation(value = "Permite crear un país", response = PaisDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se guardó exitosamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<PaisDTO>> guardarPais(@Valid @RequestBody PaisDTO pais) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, messages.get("pais.guardar.exito"), paisFacade.guardarPais(pais)));

    }

}
