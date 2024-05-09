package antoni.ecommerce.products.application;

import antoni.ecommerce.core.exceptions.BusinessException;
import antoni.ecommerce.products.domain.ProductRate;
import antoni.ecommerce.rates.application.GetRateUseCase;
import antoni.ecommerce.rates.domain.Rate;
import antoni.ecommerce.rates.domain.RateQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class GetProductRateUseCaseTest {
    private GetRateUseCase getRateUseCase;
    private GetProductRateUseCase getProductRateUseCase;

    @BeforeEach
    void setUp() {
        getRateUseCase = Mockito.mock(GetRateUseCase.class);
        getProductRateUseCase = new GetProductRateUseCase(getRateUseCase);
    }

    @Test
    void getProductRate_returnsProductRate_whenRateExists() throws BusinessException {
        RateQuery rateQuery = new RateQuery(1, 1, LocalDateTime.now());
        Rate rate = new Rate(1, new BigDecimal("100.00"), LocalDateTime.now(), LocalDateTime.now().plusDays(1), 1, "USD", 1, 1);
        when(getRateUseCase.getRateByBrandAndProductAndApplicationDate(rateQuery)).thenReturn(Optional.of(rate));

        ProductRate expectedProductRate = new ProductRate(rate, rateQuery.getApplicationDate());
        ProductRate actualProductRate = getProductRateUseCase.getProductRate(rateQuery);

        assertEquals(expectedProductRate, actualProductRate);
    }

    @Test
    void getProductRate_throwsBusinessException_whenRateDoesNotExist() throws BusinessException {
        RateQuery rateQuery = new RateQuery(1, 1, LocalDateTime.now());
        when(getRateUseCase.getRateByBrandAndProductAndApplicationDate(rateQuery)).thenReturn(Optional.empty());
        assertThrows(BusinessException.class, () -> getProductRateUseCase.getProductRate(rateQuery));
    }

    @Test
    void getProductRate_throwsBusinessException_whenProductIdIsNull() throws BusinessException {
        RateQuery rateQuery = new RateQuery(null, 1, LocalDateTime.now());
        assertThrows(BusinessException.class, () -> getProductRateUseCase.getProductRate(rateQuery));
    }

    @Test
    void getProductRate_throwsBusinessException_whenBrandIdIsNull() throws BusinessException {
        RateQuery rateQuery = new RateQuery(234, null, LocalDateTime.now());
        assertThrows(BusinessException.class, () -> getProductRateUseCase.getProductRate(rateQuery));
    }

    @Test
    void getProductRate_throwsBusinessException_whenApplicationDateIsNull() throws BusinessException {
        RateQuery rateQuery = new RateQuery(6544, 1, null);
        assertThrows(BusinessException.class, () -> getProductRateUseCase.getProductRate(rateQuery));
    }
}