package antoni.ecommerce.products.infrastructure.http;

import antoni.ecommerce.products.domain.ProductRate;
import antoni.ecommerce.rates.domain.Rate;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getProductRate_test1() throws Exception {
        String responseSpected = "{\"id\":1,\"brandId\":1,\"productId\":35455,\"applicationDate\":\"2020-06-14T10:00:00\",\"price\":35.50,\"currency\":\"EUR\"}";
        testGetProductRateEndpoint(35455, 1, "2020-06-14 10:00:00", responseSpected);
    }

    @Test
    public void getProductRate_test2() throws Exception {
        String responseSpected = "{\"id\":2,\"brandId\":1,\"productId\":35455,\"applicationDate\":\"2020-06-14T16:00:00\",\"price\":25.45,\"currency\":\"EUR\"}";
        testGetProductRateEndpoint(35455, 1, "2020-06-14 16:00:00", responseSpected);
    }

    @Test
    public void getProductRate_test3() throws Exception {
        String responseSpected = "{\"id\":1,\"brandId\":1,\"productId\":35455,\"applicationDate\":\"2020-06-14T21:00:00\",\"price\":35.50,\"currency\":\"EUR\"}";
        testGetProductRateEndpoint(35455, 1, "2020-06-14 21:00:00", responseSpected);
    }

    @Test
    public void getProductRate_test4() throws Exception {
        String responseSpected = "{\"id\":3,\"brandId\":1,\"productId\":35455,\"applicationDate\":\"2020-06-15T10:00:00\",\"price\":30.50,\"currency\":\"EUR\"}";
        testGetProductRateEndpoint(35455, 1, "2020-06-15 10:00:00", responseSpected);
    }

    @Test
    public void getProductRate_test5() throws Exception {
        String responseSpected = "{\"id\":4,\"brandId\":1,\"productId\":35455,\"applicationDate\":\"2020-06-16T21:00:00\",\"price\":38.95,\"currency\":\"EUR\"}";
        testGetProductRateEndpoint(35455, 1, "2020-06-16 21:00:00", responseSpected);
    }

    private void testGetProductRateEndpoint(Integer id, Integer brandId, String applicationDate, String responseSpected) throws Exception {
        mockMvc.perform(get("/products/{id}/rates?brandId={brandId}&applicationDate={applicationDate}",
                        id, brandId, applicationDate))
                .andExpect(status().isOk())
                .andExpect(content().json(responseSpected));
    }
}