package antoni.ecommerce.rates.domain;

import java.time.LocalDateTime;

public interface RatesRepository  {
    Rate getRateByBrandAndProductAndApplicationDate(Integer brand, Integer product, LocalDateTime date);
}
