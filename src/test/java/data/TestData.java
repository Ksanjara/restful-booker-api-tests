package data;

import com.github.javafaker.Faker;

import java.util.Locale;

import static java.util.concurrent.TimeUnit.DAYS;

public class TestData {
    Faker faker = new Faker(new Locale("en"));
    public final String firstName = faker.name().firstName();
    public final String lastName = faker.name().lastName();
    public final Integer totalPrice = faker.number().numberBetween(100, 5000);
    public final Boolean depositPaid = faker.random().nextBoolean();
    public final String checkin = faker.date().future(365, DAYS).toString();
    public final String checkout = faker.date().future(365, DAYS).toString();
    public final String additionalNeeds = faker.options()
            .option("Breakfast", "Mini-Bar", "All inclusive", "Additional bed");
    public final Integer randomId = faker.random().nextInt(1, 500);

}
