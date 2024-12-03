package utils;


public class InstructionNameHelper {

    public static String createInstructionName(String instructionDescription, String brandName, String modelName) {
        String result = instructionDescription + " " + brandName + " " + modelName + ".pdf";
        return result.replaceAll(" ", "_20");
    }
}
