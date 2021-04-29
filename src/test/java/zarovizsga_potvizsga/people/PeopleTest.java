package zarovizsga_potvizsga.people;
import static org.junit.jupiter.api.Assertions .*;
import org.junit.jupiter.api.Test;

class PeopleTest {
    @Test
    void getNumberOfMales() {
        People people = new People();
        int males = people.getNumberOfMales("src/main/resources/people.csv");
        assertEquals(545, males);
    }


}