package antoni.ecommerce.products.infrastructure.http;

import antoni.ecommerce.core.exceptions.BusinessException;
import antoni.ecommerce.products.application.GetProductRateUseCase;
import antoni.ecommerce.products.domain.ProductRate;
import antoni.ecommerce.rates.domain.RateQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private GetProductRateUseCase getProductRateUseCase;

    @GetMapping(value = "/{id}/rates", produces = "application/json")
    public ResponseEntity<ProductRate> getProducts(@PathVariable Integer id,
                                                   @RequestParam Integer brandId,
                                                   @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime applicationDate) throws BusinessException {
        ProductRate product = getProductRateUseCase.getProductRate(new RateQuery(id, brandId, applicationDate));
        return ResponseEntity.ok(product);
    }
}
