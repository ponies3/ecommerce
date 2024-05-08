package antoni.ecommerce.rates.application;

import antoni.ecommerce.core.exceptions.BusinessException;
import antoni.ecommerce.core.exceptions.ErrorsConstants;
import antoni.ecommerce.rates.domain.Rate;
import antoni.ecommerce.rates.domain.RateQuery;
import antoni.ecommerce.rates.domain.RatesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class GetRateUseCase {
    private final RatesRepository ratesRepository;

    public GetRateUseCase(RatesRepository rateRepository) {
        this.ratesRepository = rateRepository;
    }

    public Optional<Rate> getRateByBrandAndProductAndApplicationDate(RateQuery rateQuery) throws BusinessException {
        if (Objects.isNull(rateQuery.getBrandId())) {
            throw new BusinessException(ErrorsConstants.BRAND_ID_IS_REQUIRED,
                    ErrorsConstants.BRAND_ID_IS_REQUIRED_CODE, HttpStatus.BAD_REQUEST.value());
        }
        if (Objects.isNull(rateQuery.getProductId())) {
            throw new BusinessException(ErrorsConstants.PRODUCT_ID_IS_REQUIRED ,
                    ErrorsConstants.PRODUCT_ID_IS_REQUIRED_CODE, HttpStatus.BAD_REQUEST.value());
        }
        if (Objects.isNull(rateQuery.getApplicationDate())) {
            throw new BusinessException(ErrorsConstants.APPLICATION_DATE_IS_REQUIRED,
                    ErrorsConstants.APPLICATION_DATE_IS_REQUIRED_CODE, HttpStatus.BAD_REQUEST.value());
        }
        return ratesRepository.getRateByBrandAndProductAndApplicationDate( rateQuery.getBrandId(),
                rateQuery.getProductId(),
                rateQuery.getApplicationDate());
    }
}
