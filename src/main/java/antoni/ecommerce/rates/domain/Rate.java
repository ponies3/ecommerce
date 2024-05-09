package antoni.ecommerce.rates.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Rate {
    private final Integer id;
    private final BigDecimal price;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final Integer productId;
    private final String currency;
    private final Integer priority;
    private final Integer brandId;

    public Rate(Integer id, BigDecimal price, LocalDateTime startDate, LocalDateTime endDate, Integer productId, String currency, Integer priority, Integer brandId) {
        this.id = id;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.productId = productId;
        this.currency = currency;
        this.priority = priority;
        this.brandId = brandId;
    }

    public Integer getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public Integer getProductId() {
        return productId;
    }

    public String getCurrency() {
        return currency;
    }

    public Integer getPriority() {
        return priority;
    }

    public Integer getBrandId() {
        return brandId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rate rate = (Rate) o;
        return Objects.equals(id, rate.id) && Objects.equals(price, rate.price) && Objects.equals(startDate, rate.startDate) && Objects.equals(endDate, rate.endDate) && Objects.equals(productId, rate.productId) && Objects.equals(currency, rate.currency) && Objects.equals(priority, rate.priority) && Objects.equals(brandId, rate.brandId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, startDate, endDate, productId, currency, priority, brandId);
    }
}