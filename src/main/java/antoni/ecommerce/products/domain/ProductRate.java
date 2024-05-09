package antoni.ecommerce.products.domain;

import antoni.ecommerce.rates.domain.Rate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class ProductRate {
    private final Integer id;
    private final Integer brandId;
    private final Integer productId;
    private final LocalDateTime applicationDate;
    private final BigDecimal price;
    private final String currency;

    public ProductRate(Rate rate, LocalDateTime applicationDate) {
        this.id = rate.getId();
        this.applicationDate = applicationDate;
        this.price = rate.getPrice();
        this.currency = rate.getCurrency();
        this.brandId = rate.getBrandId();
        this.productId = rate.getProductId();
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

    public Integer getBrandId() {
        return brandId;
    }

    public Integer getProductId() {
        return productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductRate that = (ProductRate) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(brandId, that.brandId) &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(applicationDate, that.applicationDate) &&
                Objects.equals(price, that.price) &&
                Objects.equals(currency, that.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brandId, productId, applicationDate, price, currency);
    }
}
