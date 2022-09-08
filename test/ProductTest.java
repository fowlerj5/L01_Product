import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    Product p;

    @BeforeEach
    void setUp() {
        p = new Product("000001", "Name", "Desc.", 20.0);
    }

    @Test
    void toCSVDataRecord() {
        assertEquals("000001, Name, Desc., 20.0", p.toCSVDataRecord());
    }

    @Test
    void setName() {
        p.setName("Test Name");
        assertEquals("Test Name", p.getName());
    }

    @Test
    void setDescription() {
        p.setDescription("Test Desc.");
        assertEquals("Test Desc.",p.getDescription());
    }

    @Test
    void setCost() {
        p.setCost(100.0);
        assertEquals(100.0, p.getCost());
    }
}
