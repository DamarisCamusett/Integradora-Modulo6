package repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import modelEntity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    UserEntity findByUsername(String username);
    UserEntity findByNameAndEmail(String name,String email);
    UserEntity findByEmail(String email);
}
