package org.medianik.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class StringTest{

    @Test
    public void testValidationStrings(){
        var input1 = "2[356[xy]";
        Assertions.assertThrows(IllegalArgumentException.class, () -> StringUnpacker.unpackString(input1));

        var input2 = "2[356[xy]";
        Assertions.assertThrows(IllegalArgumentException.class, () -> StringUnpacker.unpackString(input2));

        var input3 = "2[z3]x[xy]";
        Assertions.assertThrows(IllegalArgumentException.class, () -> StringUnpacker.unpackString(input3));

        var input4 = "2[x]asdf[sdf]";
        Assertions.assertThrows(IllegalArgumentException.class, () -> StringUnpacker.unpackString(input4));

        var input5 = "2[x]asdf4[sdf]";
        Assertions.assertDoesNotThrow(() -> StringUnpacker.unpackString(input5));
    }

    @Test
    public void testSimpleString(){
        var input = "3[xyz]4[xy]z";
        Assertions.assertEquals("xyzxyzxyzxyxyxyxyz", StringUnpacker.unpackString(input));

        input = "2[xzr]8[q]z";
        Assertions.assertEquals("xzrxzrqqqqqqqqz", StringUnpacker.unpackString(input));
    }
    @Test
    public void testHardString(){
        var input1 = "2[3[x]y]";
        Assertions.assertEquals("xxxyxxxy", StringUnpacker.unpackString(input1));

        var input2 = "2[3[4[x]y]z]w";
        Assertions.assertEquals("xxxxyxxxxyxxxxyzxxxxyxxxxyxxxxyzw", StringUnpacker.unpackString(input2));
    }
}
