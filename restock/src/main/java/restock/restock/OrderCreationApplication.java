package completeretail.ordercreation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.binder.BinderHeaders;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.function.Supplier;
import java.util.function.Consumer;

@SpringBootApplication
public class OrderCreationApplication {

	private static final Logger log = LoggerFactory.getLogger(OrderCreationApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OrderCreationApplication.class, args
		);
	}
	/*
	 * Basic Supplier which sends messages every X milliseconds
	 * Configurable using spring.cloud.stream.poller.fixed-delay
	 */
	@Bean
	public Supplier<Message<String>> publishOrder() {
		return () -> {

      
      log.info("Starting a new order");
      
			GenerateOrder order = new GenerateOrder();
      JSONObject payload = new JSONObject(order.getOrder().toString());
			
      String topic = "retail/pos/" + order.getOrder().getStore().toString().toLowerCase().replaceAll(" ", "_") + "/" + order.getOrder().getStoreSize();
      // Publish on dynamic topics
      System.out.println("Publishing on topic: " + topic);
      return MessageBuilder.withPayload(payload.toString(2)).setHeader(BinderHeaders.TARGET_DESTINATION, topic).build();

		};
	}
	@Bean
	public Consumer<String> emitSensorReading() {
		return System.out::println;
	}
}
