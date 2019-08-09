package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println(calculateResultFromFile(args[0]));
    }

    /**
     * Calculates result based on provided input file.
     *
     * Note: public for reason unit testing.
     *
     * @param fileName The name of input file with operators and values.
     * @return Calculated result.
     */
    public static double calculateResultFromFile(String fileName) {

        List<String> lines = readFile(fileName);

        double result = getInitValueFromLines(lines);

        for (String line: lines) {
            String words[] = line.split(" ", 2);
            String operator = words[0];
            int value = Integer.parseInt(words[1]);
            result = makeOperation(operator, value, result);
        }

        return result;
    }

    /**
     * Does mathematical operation for one line in input file.
     *
     * Note: public for reason unit testing.
     *
     * @param operator Mathematical operator
     * @param value The numeric value from specific line in input file.
     * @param temporaryResult Temporary result from last mathematical operation(s).
     * @return
     */
    public static double makeOperation(String operator, int value, double temporaryResult) {

        switch(operator)
        {
            case "add":
                temporaryResult = temporaryResult + value;
                break;
            case "divide":
                temporaryResult = temporaryResult / value;
                break;
            case "subtract":
                temporaryResult = temporaryResult - value;
                break;
            case "multiply":
                temporaryResult = temporaryResult * value;
                break;
            default:
                // for "apply" line
        }
        return temporaryResult;
    }

    /**
     * Finds starting value after "apply" in last line.
     *
     * Note: public for reason unit testing.
     *
     * @param lines All parsed lines of file.
     * @return Starting value.
     */
    public static int getInitValueFromLines(List<String> lines) {

        String lastLine =  lines.get(lines.size() - 1);
        String[] words = lastLine.split(" ", 2);

        return Integer.parseInt(words[1]);
    }

    /**
     * Reads file and store lines into list.
     *
     * @param filename The name of file.
     * @return The list of lines.
     */
    public static List<String> readFile(String filename)
    {
        List<String> records = new ArrayList<>();
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null)
            {
                records.add(line);
            }
            reader.close();
            return records;
        }
        catch (Exception e)
        {
            System.err.format("Exception occurred while trying to read '%s'.", filename);
            e.printStackTrace();
            return null;
        }
    }
}
