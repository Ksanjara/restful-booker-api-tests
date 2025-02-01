package data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TestData {
    Faker faker = new Faker(new Locale("en"));
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public final String firstName = faker.name().firstName();
    public final String lastName = faker.name().lastName();
    public final Integer totalPrice = faker.number().numberBetween(100, 5000);
    public final Boolean depositPaid = faker.random().nextBoolean();
    public final LocalDate nonFormatCheckin = LocalDate.now().plusDays(faker.number().numberBetween(1, 365));
    public final String checkin = nonFormatCheckin.format(dtf).toString();
    //faker.date().future(365, DAYS,).toString();
    public final LocalDate nonFormatCheckout = nonFormatCheckin.plusDays(faker.number().numberBetween(1, 30));
    public final String checkout = nonFormatCheckout.format(dtf).toString();
    public final String additionalNeeds = faker.options()
            .option("Breakfast", "Mini-Bar", "All inclusive", "Additional bed");
    public final Integer randomId = faker.random().nextInt(1, 100);

}
