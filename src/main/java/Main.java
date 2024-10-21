import utils.Util;

public class Main {
    public static void main(String[] args) {

        // Task 13.1
        try {
            System.out.println(Util.getLengthOfStrings(Util.getStringsArrayFromUser()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Task 13.2
        try {
            System.out.println(Util.createMap(Util.getStringsArrayFromUser()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Task 13.3
        try {
            System.out.println(Util.countWords(Util.getStringsArrayFromUser()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Task 13.4
        try {
            System.out.println(Util.mergeStringsByFirstChar(Util.getStringsArrayFromUser()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Task 13.5
        try {
            System.out.println(Util.buildResultString(Util.getStringsArrayFromUser()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Task 13.6
        System.out.println(Util.findTheMostRepeatedElement(Util.getIntegerListFromUser()));

        // Task 13.7
        System.out.println(Util.haveCommonElement(Util.getLinkedHashSetFromUser(), Util.getLinkedHashSetFromUser()));

        // Task 13.8
        System.out.println(Util.merge2SetsTo1Set(Util.getIntegerTreeSetFromUser(), Util.getIntegerTreeSetFromUser()));
    }
}
