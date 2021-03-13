package org.medianik.test;

import org.junit.jupiter.api.Assertions;

public class Test{

    @org.junit.jupiter.api.Test
    public void testSimpleString(){
        var input = "3[xyz]4[xy]z";
        var output = StringUnpacker.unpackString(input);
        Assertions.assertEquals("xyzxyzxyzxyxyxyxyz", output);
    }
    @org.junit.jupiter.api.Test
    public void testSimpleString2(){
        var input = "2[xzr]8[q]z";
        var output = StringUnpacker.unpackString(input);
        Assertions.assertEquals("xzrxzrqqqqqqqqz", output);
    }
    @org.junit.jupiter.api.Test
    public void testHardString(){
        var input = "2[3[x]y]";
        var output = StringUnpacker.unpackString(input);
        Assertions.assertEquals("xxxyxxxy", output);
    }
}
