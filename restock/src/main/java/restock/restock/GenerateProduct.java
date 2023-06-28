package restock.restock;

import java.io.IOException;
import java.time.Instant;
import java.util.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



// TODO: Move the potential order data to a json file
// TODO: Read the catalog json file and select items from it.
public class GenerateProduct {

    private ArrayList<Product> availableProducts = new ArrayList<>();

    public GenerateProduct() {
        // Default constructor for a new product
        System.out.println("Reading in available products in " + System.getProperty("user.dir"));

        String productsDir = "../samplePayloads";

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            Path dirPath = Paths.get(productsDir);
            Files.walk(dirPath).filter(Files::isRegularFile).forEach(filePath -> {
                try {
                    File jsonFile = filePath.toFile();
                    Product product = objectMapper.readValue(jsonFile, Product.class);
                    availableProducts.add(product);
                    System.out.println("Product name: " + product.getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getProduct(Product product) {

        ObjectMapper objectMapper = new ObjectMapper();

        String json = null;
        try {
            json = objectMapper.writeValueAsString(product);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println("json version of product: " + json);
        return json;
    }

    public Product getProductRestock() {
        Random rand = new Random();
        Product selectedProduct = availableProducts.get(rand.nextInt(availableProducts.size()));
        System.out.println("Selected product: " + selectedProduct);
        return selectedProduct;
    }

    public String assignLocation() {
        // just assume location is a numeric code and we will only generate 10
        String location = "0000";
        Random rand = new Random();
        location += rand.nextInt(9)+1;
        System.out.println("location: " + location);
        return location;

    }

    public String assignRegion() {
        String region;
        Random rand = new Random();
        String[] regions = {"NE", "SW", "W", "SE", "MW"};
        region = regions[rand.nextInt(4)];
        return region;
    }

    public long generateExpirationDate(String category) {
        long expiration = 0;
        // Unix time in seconds
        long currentTime = System.currentTimeMillis()/1000;
        long addedTime = 0;
        // specify that we want to add 10 minutes to the current date for expiration
        // 3600 seconds is 1 hour.
        addedTime = 3600/6;

        // Calculate expiration time
        expiration = currentTime + addedTime;
        System.out.println("Created expiration date: " + expiration + "unix. " + addedTime + " after batch date.");
        return expiration;
    }

    public String calculateBatch(long productDate) {
        long origDate = productDate - 3600/6;
        String batch = "BATCH-";
        String date = new java.text.SimpleDateFormat("MMddyyyy").format(new java.util.Date (origDate*1000));

        batch += date;
        batch += "-00" + origDate%10;
        System.out.println("Expiration: " + batch);
        return batch;
    }
}
