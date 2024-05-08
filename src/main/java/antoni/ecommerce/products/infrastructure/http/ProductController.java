package antoni.ecommerce.products.infrastructure.http;

import antoni.ecommerce.rates.domain.Rate;
import antoni.ecommerce.rates.domain.RatesRepository;
import antoni.ecommerce.rates.infrastructure.jpa.RateEntity;
import antoni.ecommerce.rates.infrastructure.jpa.RatesJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private RatesRepository ratesService;

    @GetMapping()
    public Rate getProducts() {
        Rate rates = ratesService.getRateByBrandAndProductAndApplicationDate(1,35455, LocalDateTime.of(2020, 6, 14, 10, 0, 0));
        return rates;
    }
}
