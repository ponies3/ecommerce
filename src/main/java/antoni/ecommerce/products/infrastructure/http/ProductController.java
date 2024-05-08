package antoni.ecommerce.products.infrastructure.http;

import antoni.ecommerce.core.exceptions.BusinessException;
import antoni.ecommerce.products.application.GetProductRateUseCase;
import antoni.ecommerce.products.domain.Product;
import antoni.ecommerce.rates.application.GetRateUseCase;
import antoni.ecommerce.rates.domain.Rate;
import antoni.ecommerce.rates.domain.RateQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private GetProductRateUseCase getProductRateUseCase;

    @GetMapping(value = "/{id}/rate", produces = "application/json")
    public ResponseEntity<Product> getProducts(@PathVariable Integer id,
                                               @RequestParam Integer brandId,
                                               @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") LocalDateTime applicationDate) throws BusinessException {
        Product product = getProductRateUseCase.getProductRate(new RateQuery(id, brandId, applicationDate));
        return ResponseEntity.ok(product);
    }
}
