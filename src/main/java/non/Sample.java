package non;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Sample {
    public static void main(String[] args) {
        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();

        // Print the current date and time
        System.out.println(now);

        // Get the current date
        LocalDate date = now.toLocalDate();

        // Get the current time
        LocalTime time = now.toLocalTime();

        // Add 1 day to the current date
        LocalDate tomorrow = date.plusDays(1);
        System.out.println(tomorrow);
        // Subtract 1 hour from the current time
        LocalTime earlier = time.minusHours(1);
        System.out.println(earlier);

        LocalDate localDatea = date.minusMonths(3);
        System.out.println(localDatea);

        // Format the current date and time
        String formattedDateTime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // Print the formatted date and time
        System.out.println(formattedDateTime);
    }
}
