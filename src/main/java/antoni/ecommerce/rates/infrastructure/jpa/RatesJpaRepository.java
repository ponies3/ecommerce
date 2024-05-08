package antoni.ecommerce.rates.infrastructure.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface RatesJpaRepository extends ListCrudRepository<RateEntity, Integer> {
    @Query("SELECT r FROM RateEntity r WHERE r.brandId = ?1 AND r.productId = ?2 and ?3 >= r.startDate AND ?3 < r.endDate ORDER BY r.priority DESC")
    List<RateEntity> findByBrandAndProductAndApplicationDate(Integer brandId, Integer productId, LocalDateTime date);

}
