package co.edu.udea.basededatos.facade;

import co.edu.udea.basededatos.mapper.UsuarioMapper;
import co.edu.udea.basededatos.modelo.UsuarioDTO;
import co.edu.udea.basededatos.service.UsuarioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioFacade {

    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;

    public UsuarioFacade(UsuarioService usuarioService, UsuarioMapper usuarioMapper) {
        this.usuarioService = usuarioService;
        this.usuarioMapper = usuarioMapper;
    }

    public UsuarioDTO guardarUsuario(UsuarioDTO usuario) {
        return usuarioMapper.toDto(usuarioService.guardarUsuario(usuarioMapper.toEntity(usuario)));
    }

    public UsuarioDTO actualizarUsuario(UsuarioDTO usuario) {
        return usuarioMapper.toDto(usuarioService.actualizarUsuario(usuarioMapper.toEntity(usuario)));
    }

    public void eliminarUsuario(Long id) {
        usuarioService.eliminarUsuario(id);
    }

    public UsuarioDTO consultarPorId(Long id) {
        return usuarioMapper.toDto(usuarioService.consultarPorId(id));
    }

}
