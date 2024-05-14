package antoni.ecommerce.rates.application.infraestructure.repository;

import antoni.ecommerce.rates.domain.Rate;
import antoni.ecommerce.rates.infrastructure.jpa.RateEntity;
import antoni.ecommerce.rates.infrastructure.jpa.RatesJpaRepository;
import antoni.ecommerce.rates.infrastructure.repository.RatesRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class RatesRepositoryImplTest {

    private RatesJpaRepository ratesJpaRepository;
    private RatesRepositoryImpl ratesRepositoryImpl;

    @BeforeEach
    public void setUp() {
        ratesJpaRepository = Mockito.mock(RatesJpaRepository.class);
        ratesRepositoryImpl = new RatesRepositoryImpl(ratesJpaRepository);
    }

    @Test
    public void testGetRateByBrandAndProductAndApplicationDate() {
        RateEntity rateEntity = new RateEntity();
        rateEntity.setId(77);
        rateEntity.setPrice(new BigDecimal("100.00"));
        rateEntity.setStartDate(LocalDateTime.now());
        rateEntity.setEndDate(LocalDateTime.now().plusDays(2));
        rateEntity.setProductId(856436);
        rateEntity.setCurrency("EUR");
        rateEntity.setPriority(0);
        rateEntity.setBrandId(1);

        when(ratesJpaRepository.findByBrandAndProductAndApplicationDate(any(), any(), any()))
                .thenReturn(Collections.singletonList(rateEntity));

        List<Rate> rates = ratesRepositoryImpl.getRateByBrandAndProductAndApplicationDate(1, 856436, LocalDateTime.now().plusDays(1));

        assertEquals(rateEntity.getId(), rates.getFirst().getId());
        assertEquals(rateEntity.getPrice(),rates.getFirst().getPrice());
        assertEquals(rateEntity.getStartDate(), rates.getFirst().getStartDate());
        assertEquals(rateEntity.getEndDate(), rates.getFirst().getEndDate());
        assertEquals(rateEntity.getProductId(), rates.getFirst().getProductId());
        assertEquals(rateEntity.getCurrency(), rates.getFirst().getCurrency());
        assertEquals(rateEntity.getPriority(), rates.getFirst().getPriority());
        assertEquals(rateEntity.getBrandId(), rates.getFirst().getBrandId());
    }

    @Test
    public void testGetRateByBrandAndProductAndApplicationDateEmpty() {
        when(ratesJpaRepository.findByBrandAndProductAndApplicationDate(any(), any(), any()))
                .thenReturn(Collections.emptyList());

        List<Rate> rates = ratesRepositoryImpl.getRateByBrandAndProductAndApplicationDate(1, 856436, LocalDateTime.now().plusDays(1));

        assertEquals(Collections.emptyList(), rates);
    }
}