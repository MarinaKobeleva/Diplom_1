import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunParameterizedTest {
    private Bun bun;
    private String name;
    private float price;
    private String expectedName;
    private float expectedPrice;

    public BunParameterizedTest(String name, float price, String expectedName, float expectedPrice) {
        this.name = name;
        this.price = price;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }

    @Parameterized.Parameters
    public static Object[][] getBun() {
        return new Object[][]{
                {"Вкусная булочка", 100.5f, "Вкусная булочка", 100.5f},
                {"Bad bun", -500.3f, "Bad bun", -500.3f},
                {" ", 0, " ", 0},
                {"Funny булочка", 5156814.3E-19f, "Funny булочка", 5156814.3E-19f},
        };
    }

    @Test
    public void getNameBunTest() {
        assertEquals("Название булочки не совпадает с ожидаемым результатом", expectedName, bun.getName());
    }

    @Test
    public void getPriceBunTest() {
        assertEquals("Цена булочки не совпадает с ожидаемым результатом", expectedPrice, bun.getPrice(), 0.001f);
    }
}
