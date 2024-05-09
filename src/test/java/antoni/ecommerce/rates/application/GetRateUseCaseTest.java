package antoni.ecommerce.rates.application;

import antoni.ecommerce.core.exceptions.BusinessException;
import antoni.ecommerce.rates.domain.Rate;
import antoni.ecommerce.rates.domain.RateQuery;
import antoni.ecommerce.rates.domain.RatesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class GetRateUseCaseTest {
    private GetRateUseCase getRateUseCase;

    private RatesRepository ratesRepository;

    @BeforeEach
    void setUp() {
        ratesRepository = Mockito.mock(RatesRepository.class);
        getRateUseCase = new GetRateUseCase(ratesRepository);
    }

    @Test
    void getRateByBrandAndProductAndApplicationDate_returnsRate_whenRateExists() throws BusinessException {
        RateQuery rateQuery = new RateQuery(1, 1, LocalDateTime.now());
        Rate expectedRate = new Rate(1, new BigDecimal("100.00"), LocalDateTime.now(), LocalDateTime.now().plusDays(1), 1, "EUR", 1, 1);
        when(ratesRepository.getRateByBrandAndProductAndApplicationDate(rateQuery.getBrandId(), rateQuery.getProductId(), rateQuery.getApplicationDate())).thenReturn(Optional.of(expectedRate));

        Optional<Rate> actualRate = getRateUseCase.getRateByBrandAndProductAndApplicationDate(rateQuery);

        assertEquals(expectedRate, actualRate.get());
    }

    @Test
    void getRateByBrandAndProductAndApplicationDate_returnEmptyOptional_whenRateDoesNotExist() throws BusinessException {
        RateQuery rateQuery = new RateQuery(1, 1, LocalDateTime.now());
        when(ratesRepository.getRateByBrandAndProductAndApplicationDate(rateQuery.getBrandId(), rateQuery.getProductId(), rateQuery.getApplicationDate())).thenReturn(Optional.empty());

        assertEquals(Optional.empty(), getRateUseCase.getRateByBrandAndProductAndApplicationDate(rateQuery));
    }

    @Test
    void getRateByBrandAndProductAndApplicationDate_throwsBusinessException_whenBrandIdRateQueryIsNull() {
        BusinessException businessException = assertThrows(BusinessException.class, () -> getRateUseCase.getRateByBrandAndProductAndApplicationDate(null));
        assertEquals("RATES-001", businessException.getCode());
    }

    @Test
    void getRateByBrandAndProductAndApplicationDate_throwsBusinessException_whenBrandIdIsNull() {
        RateQuery rateQuery = new RateQuery(null, 1, LocalDateTime.now());
        BusinessException businessException = assertThrows(BusinessException.class, () -> getRateUseCase.getRateByBrandAndProductAndApplicationDate(rateQuery));
        assertEquals("RATES-002", businessException.getCode());
    }

    @Test
    void getRateByBrandAndProductAndApplicationDate_throwsBusinessException_whenProductIdIsNull() {
        RateQuery rateQuery = new RateQuery(1, null, LocalDateTime.now());
        BusinessException businessException = assertThrows(BusinessException.class, () -> getRateUseCase.getRateByBrandAndProductAndApplicationDate(rateQuery));
        assertEquals("RATES-001", businessException.getCode());
    }

    @Test
    void getRateByBrandAndProductAndApplicationDate_throwsBusinessException_whenApplicationDateIsNull() {
        RateQuery rateQuery = new RateQuery(1, 1, null);
        BusinessException businessException = assertThrows(BusinessException.class, () -> getRateUseCase.getRateByBrandAndProductAndApplicationDate(rateQuery));
        assertEquals("RATES-003", businessException.getCode());
    }
}