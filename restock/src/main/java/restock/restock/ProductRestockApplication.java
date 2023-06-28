package restock.restock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.binder.BinderHeaders;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.function.Supplier;


@SpringBootApplication
public class ProductRestockApplication {

	private static final Logger log = LoggerFactory.getLogger(ProductRestockApplication.class);
	private static final GenerateProduct availableProducts = new GenerateProduct();

	public static void main(String[] args) {
		SpringApplication.run(ProductRestockApplication.class, args
		);
	}

	/*
	 * Basic Supplier which sends messages every X milliseconds
	 * Configurable using spring.cloud.stream.poller.fixed-delay
	 */
	@Bean
	public Supplier<Message<String>> publishProduct() {
		return () -> {
			log.info("Starting a new product");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			Product product = availableProducts.getProductRestock();
			product.setExpiration_date(availableProducts.generateExpirationDate(product.getCategory()));
			product.setBatch_number(availableProducts.calculateBatch(product.getExpiration_date()));
			String region = availableProducts.assignRegion();
			String location = availableProducts.assignLocation();
			String topic = "acme/instore/instock/stk/restock/created/v1/" + region + "/"  + location + "/" + product.getCategory() +
					"/" + product.getName() + "/" + product.getBatch_number() + "/" + product.getExpiration_date();
			// Publish on dynamic topics
			System.out.println("Publishing on topic: " + topic);
			return MessageBuilder.withPayload(availableProducts.getProduct(product)).setHeader(BinderHeaders.TARGET_DESTINATION, topic).build();
			//return MessageBuilder.withPayload(payload.toString(2)).setHeader(BinderHeaders.TARGET_DESTINATION, topic).build();


		};
	}
}
