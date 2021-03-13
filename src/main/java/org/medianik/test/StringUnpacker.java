package org.medianik.test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUnpacker{

    public static void main(String[] args){
        var input = new Scanner(System.in);
        System.out.print("Enter your packed string: ");
        String packed = input.nextLine();
        try{
            String unpackedString = unpackString(packed);
            System.out.println("Your unpacked string: " + unpackedString);
        }catch(IllegalArgumentException e){
            System.out.println("Oops, it seems that you entered invalid packed string");
        }
    }

    static Pattern brackets = Pattern.compile("[\\[\\]]+");

    static Pattern unpacker = Pattern.compile("(\\d+)\\[([a-zA-Z]+)\\]");

    /**
     * <p>
     *      Unpacks string.
     * </p>
     * <br>
     * For example:
     * </br>
     * <br>
     * <strong>packed</strong>: {@code 2[xzr]8[q]z}
     * </br>
     * <br>
     * <strong>output</strong>: {@code xzrxzrqqqqqqqqz}
     * </br>
     * @throws IllegalArgumentException if string is invalid.
     */
    public static String unpackString(String packed) throws IllegalArgumentException{
        Matcher m;
        while((m = unpacker.matcher(packed)).find()){
            packed = m.replaceAll(e ->
                e.group(2).repeat(Integer.parseInt(e.group(1)))
            );
        }
        if(brackets.matcher(packed).find())
            throw new IllegalArgumentException("Input string is not valid");
        return packed;
    }
}
