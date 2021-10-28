package co.edu.demo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SumServiceUnitTest {

    @Test
    public void TestSumNumbers() {
        // Arrange
        double expectedValue = 5;

        SumService sumService = new SumService();
        // Act
        double actualValue = sumService.SumNumber(3, 2);

        // Assert
        Assertions.assertEquals(expectedValue, actualValue);
    }
}
