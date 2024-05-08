package antoni.ecommerce.products.application;

import antoni.ecommerce.core.exceptions.BusinessException;
import antoni.ecommerce.core.exceptions.ErrorsConstants;
import antoni.ecommerce.products.domain.Product;
import antoni.ecommerce.products.domain.ProductRate;
import antoni.ecommerce.rates.application.GetRateUseCase;
import antoni.ecommerce.rates.domain.Rate;
import antoni.ecommerce.rates.domain.RateQuery;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetProductRateUseCase {
    private final GetRateUseCase getRateUseCase;

    public GetProductRateUseCase(GetRateUseCase getRateUseCase) {
        this.getRateUseCase = getRateUseCase;
    }

    public Product getProductRate(RateQuery rateQuery) throws BusinessException {
        Optional<Rate> rateOptional = getRateUseCase.getRateByBrandAndProductAndApplicationDate( rateQuery);
        Rate rate = rateOptional.orElseThrow(() -> new BusinessException(ErrorsConstants.PRODUCT_RATE_NOT_FOUND,
                ErrorsConstants.PRODUCT_RATE_NOT_FOUND_CODE, HttpStatus.NOT_FOUND.value()));
        return new Product(rateQuery.getProductId(), rateQuery.getBrandId(), new ProductRate(rate, rateQuery.getApplicationDate()));
    }
}
