import java.time.*;
import java.time.format.*;
import java.time.temporal.ChronoUnit;

/*
Invoking the program with a relevant birthday:
    java 01201934
produces the output (when run on January 13, 2017):
    your birthday is: 1934-01-20
    a SATURDAY
    you´ve lived for:
    24 days, 11 months, 82 years
    you´ve lived for 30309 days, so far
    you´ll reach 3000 days on 2016-03-10
    period since Y2K: P17Y12D
 */
public class DrWho {
    public static void main(String[] args){
        DateTimeFormatter f = DateTimeFormatter.ofPattern("MMddyyyy"); // describe a format
        LocalDate bday = null;

        try {
            bday = LocalDate.parse(args[0], f); // verify input date. often parse() methode throw exception
        } catch (java.time.DateTimeException e){
            System.out.println("Bad dates Indy");
            System.exit(0);
        }
        System.out.println("your birthday is: " + bday);
        System.out.println("a " + bday.getDayOfWeek()); //useful

        Period pl = Period.between(bday, LocalDate.now()); // very useful!
        System.out.println("you´ve lived for: ");
        System.out.println(pl.getDays() + " days, "); // split up a period
        System.out.println(pl.getMonths() + " months, ");
        System.out.println(pl.getYears() + " years");

        int yearsOld = pl.getYears();
        if (yearsOld < 0 || yearsOld > 119)
            System.out.println("Wow, are you a time lord?");

        long tDays = bday.until(LocalDate.now(), ChronoUnit.DAYS); // handy methode + handy enum = powerful date math
        System.out.println("you´ve lived for " + tDays + " days, so far");
        System.out.println("you´ll reach 30,000 days on " + bday.plusDays(30_000)); // date math

        LocalDate d2000 = LocalDate.of(2_000, 1, 1); // of() is a commonly used 'factory' method

        Period p2 = Period.between(d2000, LocalDate.now());
        System.out.println("period since Y2K: " + p2);
    }
}

