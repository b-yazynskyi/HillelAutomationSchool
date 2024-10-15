import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(3, 14, 15, 92, 6);
        List<String> fullName = Arrays.asList("Bohdan", "Yazynskyi", "Oleksiyovych");

        Set<Integer> uniqueNumbers = new HashSet<>();

        uniqueNumbers.add(5);
        // Can't add same element, as result in printing only one 5
        uniqueNumbers.add(5);

        Map<String, String> citiesAndPhoneCodes = new HashMap<>();

        citiesAndPhoneCodes.put("Kyiv", "044");
        citiesAndPhoneCodes.put("Kharkiv", "057");
        citiesAndPhoneCodes.put("Lviv", "32");
        citiesAndPhoneCodes.put("Mykolaiv", "512");

        System.out.println(numbers);
        System.out.println(fullName);
        System.out.println(uniqueNumbers);
        for (Map.Entry<String, String> elem : citiesAndPhoneCodes.entrySet()) {
            System.out.println(elem.getKey() + ": " + elem.getValue());
        }


    }
}
