package antoni.ecommerce.rates.infrastructure.jpa;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatesRepository extends ListCrudRepository<RateEntity, Integer> {

}
