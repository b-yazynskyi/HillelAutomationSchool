package utils;


public final class InstructionNameHelper {

    private InstructionNameHelper(){}

    public static String createInstructionName(String instructionDescription, String brandName, String modelName) {
        String result = instructionDescription + " " + brandName + " " + modelName + ".pdf";
        return result.replaceAll(" ", "_20");
    }
}
