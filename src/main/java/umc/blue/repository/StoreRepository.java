package umc.blue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.blue.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
