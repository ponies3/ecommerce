package antoni.ecommerce.rates.domain;

import java.time.LocalDateTime;

public class RateQuery {
    private final Integer brandId;
    private final Integer productId;
    private final LocalDateTime applicationDate;

    public RateQuery(Integer productId, Integer brandId, LocalDateTime applicationDate) {
        this.brandId = brandId;
        this.productId = productId;
        this.applicationDate = applicationDate;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public Integer getProductId() {
        return productId;
    }

    public LocalDateTime getApplicationDate() {
        return applicationDate;
    }
}
