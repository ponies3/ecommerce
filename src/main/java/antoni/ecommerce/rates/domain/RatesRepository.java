package antoni.ecommerce.rates.domain;

import java.time.LocalDateTime;
import java.util.Optional;

public interface RatesRepository  {
    Optional<Rate> getRateByBrandAndProductAndApplicationDate(Integer brand, Integer product, LocalDateTime date);
}
