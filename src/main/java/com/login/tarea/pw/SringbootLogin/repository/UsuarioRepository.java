package com.login.tarea.pw.SringbootLogin.repository;

import com.login.tarea.pw.SringbootLogin.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsuid(Long usuid);

    Usuario findByUsername(String username);

    @Query("SELECT u FROM Usuario u JOIN u.roles r WHERE r.rol_nombre = :role")
    List<Usuario> findAllByRole(String role);
}