package com.agustincollueque.portfolio.service;

import com.agustincollueque.portfolio.dto.UserDto;
import com.agustincollueque.portfolio.model.Usuario;
import java.util.List;
import org.springframework.stereotype.Service;
import com.agustincollueque.portfolio.repository.UsuarioRepository;
import java.time.LocalDate;
import java.time.Period;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsuarioService implements IUsuarioService {

    private final UsuarioRepository usuRepo;
    private final TrabajoService trabService;
    private final HabilidadService habService;
    private final FormacionService formService;
    private final ProyectoService proyService;

    @Transactional
    @Override
    public Usuario crearUsuario(Usuario user) {
        return usuRepo.save(user);
    }

    @Transactional
    @Override
    public void eliminarUsuario(Usuario admin, Long id) {
        if (!esSuperAdmin(admin)) {
            throw new RuntimeException("Unauthorized user");
        }
        usuRepo.deleteById(id);
    }

    @Transactional
    @Override
    public void modificarUsuario(Long userId, Usuario usu) {
        if (!usuRepo.existsById(userId)) {
            throw new EntityNotFoundException("User with " + userId + " not found.");
        }
        usuRepo.save(usu);
    }

    @Override
    public UserDto obtenerInfoUsuario(Long id) {
        Usuario user = usuRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with ID " + id + " not found"));
        LocalDate fechaNacimiento = LocalDate.parse(user.getBirdDate());
        int edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
        UserDto userAux = new UserDto();
        userAux.setId(id);
        userAux.setName(user.getName());
        userAux.setLastName(user.getLastName());
        userAux.setDescription(user.getDescription());
        userAux.setEmail(user.getEmail());
        userAux.setMainPhrase(user.getMainPhrase());
        userAux.setNumberPhone(user.getNumberPhone());
        userAux.setSecondaryPhrase(user.getSecondaryPhrase());
        userAux.setTitle(user.getTitle());
        userAux.setYearsXP(user.getYearsXP());
        userAux.setAge(edad);
        userAux.setUrlImg(user.getUrlImg());
        userAux.setUrlCV(user.getUrlCV());
        userAux.setJobs(trabService.obtenerTrabajos(id));
        userAux.setFormations(formService.obtenerFormaciones(id));
        userAux.setSkills(habService.obtenerHabilidades(id));
        userAux.setProjects(proyService.obtenerProyectos(id));
        return userAux;
    }

    @Override
    public Usuario obtenerUsuario(Long id) {
        return usuRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with ID " + id + " not found."));
    }

    @Override
    public List<Usuario> obtenerUsuarios(Usuario admin) {
        if (!esSuperAdmin(admin)) {
            throw new RuntimeException("Unauthorized user");
        }
        return usuRepo.findAll();
    }

    private boolean esSuperAdmin(Usuario admin) {
        return admin.getRoles().stream().anyMatch(r -> r.getNombre().equals("ADMIN"));
    }
}
