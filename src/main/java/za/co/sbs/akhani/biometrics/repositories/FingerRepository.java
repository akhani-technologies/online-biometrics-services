package za.co.sbs.akhani.biometrics.repositories;

import za.co.sbs.akhani.biometrics.domain.Finger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import java.util.Optional;

@RepositoryRestResource
public interface FingerRepository extends CrudRepository<Finger, Integer> {
    Optional<Finger> findByIdNumber(String username);
}
