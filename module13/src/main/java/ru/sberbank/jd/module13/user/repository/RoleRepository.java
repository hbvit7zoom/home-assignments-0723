package ru.sberbank.jd.module13.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sberbank.jd.module13.user.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
