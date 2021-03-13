package org.medianik.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUnpacker{

    public static void main(String[] args){
        String s = "3[xyz]4[xy]z";
    }
    static Pattern p = Pattern.compile("(\\d+)\\[([a-zA-Z]+)\\]");
    /**
     * Unpacks string.
     * For example:
     * packed: {@code 2[xzr]8[q]z}
     * output: {@code xzrxzrqqqqqqqqz}
     */
    public static String unpackString(String packed){
        Matcher m;
        while((m = p.matcher(packed)).find()){
            packed = m.replaceAll(e ->
                e.group(2).repeat(Integer.parseInt(e.group(1)))
            );
        }
        return packed;
    }
}
