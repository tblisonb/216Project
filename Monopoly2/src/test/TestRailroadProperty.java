package test;

import core.RailroadProperty;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class TestRailroadProperty {
    private RailroadProperty prop;
    private int[] test;

    @BeforeClass
    public void setUpBeforeClass() {
        System.out.println("Started testing core.RailroadProperty.java");
    }

    @AfterClass
    public void tearDownAfterClass() {
        System.out.println("Finished testing core.RailroadProperty.java");
    }

    @BeforeMethod
    public void setUp() {
        test = new int[1];
        test[0] = 15;
        prop = new core.RailroadProperty("test_prop", 100, test, 500);
    }

    @AfterMethod
    public void tearDown() {
    }

    @Test
    public void testGettersAndSetters() {
        prop.setMortgaged(true);
        Assert.assertFalse(prop.getMortgaged());
        Assert.assertEquals(prop.getName(), "test_prop");
        Assert.assertEquals(prop.getCost(), 100);
        Assert.assertEquals(prop.getMortgageRate(), 500);
    }
}