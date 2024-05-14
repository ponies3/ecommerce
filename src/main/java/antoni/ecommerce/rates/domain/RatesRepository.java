package antoni.ecommerce.rates.domain;

import java.time.LocalDateTime;
import java.util.List;

public interface RatesRepository  {
    List<Rate> getRateByBrandAndProductAndApplicationDate(Integer brand, Integer product, LocalDateTime date);
}
