import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {
    private Ingredient ingredient;
    private IngredientType type;
    private String name;
    private float price;
    private IngredientType expectedType;
    private String expectedName;
    private float expectedPrice;


    public IngredientParameterizedTest(IngredientType type, String name, float price, IngredientType expectedType, String expectedName, float expectedPrice) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.expectedType = expectedType;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Parameterized.Parameters
    public static Object[][] getIngredient() {
        return new Object[][]{
                {IngredientType.SAUCE, "Вкусный соус", 10.5f, IngredientType.SAUCE, "Вкусный соус", 10.5f},
                {IngredientType.FILLING, "Bad filling", -50.3f, IngredientType.FILLING, "Bad filling", -50.3f},
                {IngredientType.SAUCE, " ", 0, IngredientType.SAUCE, " ", 0},
                {IngredientType.FILLING, "Funny начинка", 5156814.3E-19f, IngredientType.FILLING, "Funny начинка", 5156814.3E-19f},
        };
    }

    @Test
    public void getTypeIngredientTest() {
        assertEquals("Тип ингредиента не совпадает с ожидаемым результатом", expectedType, ingredient.getType());
    }


    @Test
    public void getNameIngredientTest() {
        assertEquals("Название ингредиента не совпадает с ожидаемым результатом", expectedName, ingredient.getName());
    }

    @Test
    public void getPriceIngredientTest() {
        assertEquals("Цена ингредиента не совпадает с ожидаемым результатом", expectedPrice, ingredient.getPrice(), 0.001f);
    }
}
