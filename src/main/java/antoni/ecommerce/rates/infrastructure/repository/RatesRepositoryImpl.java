package antoni.ecommerce.rates.infrastructure.repository;

import antoni.ecommerce.rates.domain.Rate;
import antoni.ecommerce.rates.domain.RatesRepository;
import antoni.ecommerce.rates.infrastructure.jpa.RateEntity;
import antoni.ecommerce.rates.infrastructure.jpa.RatesJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class RatesRepositoryImpl implements RatesRepository {

    private RatesJpaRepository ratesJpaRepository;

    public RatesRepositoryImpl(RatesJpaRepository ratesJpaRepository) {
        this.ratesJpaRepository = ratesJpaRepository;
    }

    @Override
    public Optional<Rate> getRateByBrandAndProductAndApplicationDate(Integer brand, Integer product, LocalDateTime date) {
        List<RateEntity> rates = ratesJpaRepository.findByBrandAndProductAndApplicationDate(brand, product, date);
        return rates.stream().map(rate -> new Rate(
                rate.getId(),
                rate.getPrice(),
                rate.getStartDate(),
                rate.getEndDate(),
                rate.getProductId(),
                rate.getCurrency(),
                rate.getPriority(),
                rate.getBrandId()
                )).findFirst();
    }
}
