package co.edu.udea.basededatos.service;

import co.edu.udea.basededatos.entity.Usuario;
import co.edu.udea.basededatos.exception.BusinessException;
import co.edu.udea.basededatos.repository.UsuarioRepository;
import co.edu.udea.basededatos.util.Messages;
import co.edu.udea.basededatos.util.enums.TipoUsuario;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final Messages messages;

    public UsuarioService(UsuarioRepository usuarioRepository, Messages messages) {
        this.usuarioRepository = usuarioRepository;
        this.messages = messages;
    }

    public Usuario guardarUsuario(Usuario usuario) {
        Optional<Usuario> usuarioConsulta = usuarioRepository.findByCorreo(usuario.getCorreo());
        if(usuarioConsulta.isPresent()){
            throw new BusinessException(messages.get("usuario.correo.duplicado"));
        }
        validarTipo(usuario);
        return usuarioRepository.save(usuario);
    }

    public Usuario actualizarUsuario(Usuario usuario) {
        if (Objects.isNull(usuario.getId())) {
            throw new BusinessException(messages.get("usuario.id.vacio"));
        }
        consultarPorId(usuario.getId());
        validarTipo(usuario);
        return usuarioRepository.save(usuario);
    }

    public void validarTipo(Usuario usuario) {
        if (usuario.getTipo().equals(TipoUsuario.ADMINISTRADOR)) {
            if (Objects.isNull(usuario.getNombreEmpresa()) ||
                    Objects.isNull(usuario.getFkCiudadAdministrador())) {
                throw new BusinessException(messages.get("usuario.informacion.incompleta"));
            }
        } else {
            if (Objects.isNull(usuario.getFechaIngreso()) ||
                    Objects.isNull(usuario.getFkCiudadCliente()) || Objects.isNull(usuario.getFkAdministrador())) {
                throw new BusinessException(messages.get("usuario.informacion.incompleta"));
            }
        }
    }

    public void eliminarUsuario(Long id) {
        consultarPorId(id);
        usuarioRepository.deleteById(id);
    }

    public Usuario consultarPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(
                () -> new BusinessException(messages.get("usuario.id.no_encontrado")));
    }
}
