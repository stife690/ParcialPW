package com.login.tarea.pw.SringbootLogin.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.login.tarea.pw.SringbootLogin.dto.UsuarioRegistroDTO;
import com.login.tarea.pw.SringbootLogin.model.Rol;
import com.login.tarea.pw.SringbootLogin.model.Usuario;
import com.login.tarea.pw.SringbootLogin.repository.RolRepository;
import com.login.tarea.pw.SringbootLogin.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
    private UsuarioRepository usuarioRepositorio;

    @Autowired
    private RolRepository rolRepositorio;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepositorio, RolRepository rolRepositorio) {
        super();
        this.usuarioRepositorio = usuarioRepositorio;
        this.rolRepositorio = rolRepositorio;
    }

	public List<Usuario> getAllUsuarios() {
		return usuarioRepositorio.findAll();
	}

	public Usuario guardar(UsuarioRegistroDTO usuarioRegistroDTO) throws UsuarioExistenteException {
		//Verificar si el usuario ya existe
		if (usuarioRepositorio.findByUsername(usuarioRegistroDTO.getUsername()) != null) {
			throw new UsuarioExistenteException("El nombre de usuario ya existe");
		}
		
		//Verificar si role_docente existe
		Rol userRole = rolRepositorio.findByName("ROLE_DOCENTE");
		if (userRole == null) {
			throw new RuntimeException("El rol ROLE_DOCENTE no se encuentra en la base de datos");
		}
		
		//creacion el usuario rol y contraseña
		Usuario usuario = new Usuario(usuarioRegistroDTO.getUsername(),
				passwordEncoder.encode(usuarioRegistroDTO.getPassword()),
				Arrays.asList(userRole));
		
		
		//guardar el usuario en bsd
		try {
			Usuario savedUser = usuarioRepositorio.save(usuario);
			System.out.println("Usuario guardado: " + savedUser);
			return savedUser;
		} catch (Exception e) {
			System.out.println("Error al guardar el usuario: " + e.getMessage());
			return null;
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepositorio.findByUsername(username);
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuario o password inválidos");
		}
		return new User(usuario.getUsername(), usuario.getUsu_password(), mapearAutoridadesRoles(usuario.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRol_nombre()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Usuario> listarUsuarios() {
		return usuarioRepositorio.findAll();
	}

	@Override
	public Usuario findByUsername(String username) {
		return usuarioRepositorio.findByUsername(username);
	}

	public List<Usuario> findAllByRole(String role) {
		return usuarioRepositorio.findAllByRole(role);
	}

}