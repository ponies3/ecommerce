package antoni.ecommerce.products.domain;

import antoni.ecommerce.rates.domain.Rate;

public class Product {
    private final Integer id;
    private final Integer brandId;
    private final ProductRate rate;

    public Product(Integer id, Integer brandId, ProductRate rate) {
        this.id = id;
        this.rate = rate;
        this.brandId = brandId;
    }

    public Integer getId() {
        return id;
    }

    public ProductRate getRate() {
        return rate;
    }

    public Integer getBrandId() {
        return brandId;
    }
}
