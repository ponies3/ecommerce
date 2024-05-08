package antoni.ecommerce.products.domain;

import antoni.ecommerce.rates.domain.Rate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductRate {
    private final Integer id;
    private final LocalDateTime applicationDate;
    private final BigDecimal price;
    private final String currency;

    public ProductRate(Rate rate, LocalDateTime applicationDate) {
        this.id = rate.getId();
        this.applicationDate = applicationDate;
        this.price = rate.getPrice();
        this.currency = rate.getCurrency();
    }

    public Integer getId() {
        return id;
    }

    public LocalDateTime getApplicationDate() {
        return applicationDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }
}
