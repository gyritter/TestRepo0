package product;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdTest {

    @Test
    public void Test(){

        Prod prod = new Prod((long)150, Currency.HUF);

        assertEquals(0.5,prod.convertPrice(Currency.USD));
    }


}