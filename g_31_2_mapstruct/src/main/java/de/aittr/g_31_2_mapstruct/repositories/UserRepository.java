package de.aittr.g_31_2_mapstruct.repositories;


import de.aittr.g_31_2_mapstruct.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
