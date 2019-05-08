package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import program.StackApps;

/**
 * Test the implementation of the StackApps class.
 * @author Yaro Salo    
 * @version 1.0
 *
 */
public class StackAppsTest {

    /**
     * Tests the decimalToBinary() method with negative value.
     */
    @Test(expected = IllegalArgumentException.class) 
    public void testDecimalToBinaryNegative() {
        
        StackApps.decimalToBinary(-25);
    }
    
    /**
     * Tests the decimalToBinary() method with zero.
     */
    @Test(expected = IllegalArgumentException.class) 
    public void testDecimalToBinaryZero() {
        
        StackApps.decimalToBinary(0);
    }
    
    /**
     * Tests the decimalToBinary() method with a lowest acceptable value.
     */
    @Test 
    public void testDecimalToBinaryLow() {
        
        assertEquals("Incorrect value returned", "1", StackApps.decimalToBinary(1));    
    }
    
    /**
     * Tests the decimalToBinary() method with a value somewhere in the middle.
     */
    @Test 
    public void testDecimalToBinaryMid() {
        
        assertEquals("Incorrect value returned", "1000000000000000000011011101110", 
                     StackApps.decimalToBinary(1073743598));     
    }
    
    /**
     * Tests the decimalToBinary() method with the largest representable integer value.
     */
    @Test 
    public void testDecimalToBinaryLargest() {
        
        assertEquals("Incorrect value returned", "1111111111111111111111111111111", 
                     StackApps.decimalToBinary(2147483647));   
    }
}
