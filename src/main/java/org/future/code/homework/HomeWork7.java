package org.future.code.homework;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

public class HomeWork7 {
    /*
        ЗАДАНИЕ

        Напишите реализации для методов, используя StreamAPI

        В этих задания ЗАПРЕЩАЕТСЯ использование for и if
        Тело каждого метода должно начинаться с ключевого слова return
        (т.е. задания должны быть выполнены за одно выражение)
     */

    /**
     * Метод должен вернуть список людей с фамилией или именем King
     */
    public static List<String> methodOne(List<String> names) {
        List<String> listOne = names.stream()
                .filter(s -> s.contains("King"))
                .collect(Collectors.toList());
        return listOne;
        
    }

    /**
     * Метод должен вернуть список уникальных фамилий (2 позиция в строке)
     */
    public static List<String> methodTwo(List<String> names) {
        List<String> listTwo = names.stream()
                .map(s->s.substring(s.indexOf(" ")+1))
                .distinct()
                .collect(Collectors.toList());
        return listTwo;
        
    }

    /**
     * Метод должен вернуть список уникальных имен, начинающихся с L
     */
    public static List<String> methodThree(List<String> names) {
       List<String> listThree = names.stream()
                .map(s->s.substring(+0, s.indexOf(" ")))
                .filter(s->s.startsWith("L"))
                .distinct()
                .collect(Collectors.toList());
        return listThree;
    }

    /**
     * Метод должен вернуть список уникальных фамилий, начинающихся с W, отсортированный по алфавиту
     */
    public static List<String> methodFour(List<String> names) {
        List<String> listFour = names.stream()
                .map(s->s.substring(s.indexOf(" ")+1))
                .filter(s->s.startsWith("W"))
                .distinct()
                .sorted()
                .collect(Collectors.toList());
         return listFour;
    }

    /**
     * Метод должен вернуть количество имен длинее чем 6 символов
     */
    public static Integer methodFive(List<String> names) {
        public static Integer methodFive(List<String> names) {
        // Твой код здесь
       long counterFive = names.stream()
                .map(s->s.substring(+0, s.indexOf(" ")))
                .filter(s->s.length()>6)
                .distinct()
                .count();
       return (int) counterFive;
    }

    /**
     * Метод должен вернуть суммарное количество уникальных имён и фамилий, длиннее 5 символов
     * P. S. Самостоятельно почитайте про метод flatMap()
     */
    public static Integer methodSix(List<String> names) {
        long namesC = names.stream()
                .map(s -> s.substring(0, s.indexOf(" ")-1))
                .filter(s -> s.length()>5)
                .distinct()
                .count();
        long surnameC = names.stream()
                .map(s -> s.substring(s.indexOf(" ")))
                .filter(s->s.length()>5)
                .distinct()
                .count();
        return (int) (surnameC+namesC);
    }

    /**
     * Метод должен вернуть имена людей, чья фамилия начинается с K или S, в формате имя + первая буква фамилии,
     * например "David Z.". Список должен быть отсортирован по алфавиту и состоять только из уникальных значений
     */
    public static List<String> methodSeven(List<String> names) {
        List<String> listSeven = names.stream()
                .map(s -> s.substring(+0, s.indexOf(" ")+2))
                .filter(s -> (s.endsWith("K")) || (s.endsWith("S")))
                .map(s -> s.concat("."))
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        return listSeven;
    }

    public static void main(String[] args) {
        AntiCheat.run();
        printTestCase(KINGS, methodOne(FULL_NAMES));
        printTestCase(UNIQ_SURNAMES, methodTwo(FULL_NAMES));
        printTestCase(NAMES_STARTS_WITH_L, methodThree(FULL_NAMES));
        printTestCase(SURNAMES_STARTS_WITH_W_SORTED, methodFour(FULL_NAMES));
        printTestCase(NAMES_LONGER_THAN_SIX, methodFive(FULL_NAMES));
        printTestCase(NAMES_AND_SURNAMES_LONGER_THAN_FIVE, methodSix(FULL_NAMES));
        printTestCase(NAMES_WITH_LETTER_SORTED, methodSeven(FULL_NAMES));
    }

    private static final List<String> FULL_NAMES = List.of(
            "Joseph Smith", "Thomas Doyle", "Ronald Pratt", "Thomas Spencer", "King Lee",
            "Gregory Smith", "Leroy Zimmerman", "Lee Smith", "Michael Harrington", "Lee Daniels",
            "Eugene Williams", "Lee Terry", "Arnold Fowler", "Billy Harrison", "Lee Bennett", "Lee Evans",
            "Ronald Diaz", "Leonard King", "Timothy Smith", "George Lee", "King Mann", "Dean Wright",
            "Lee Richards", "Arthur Smith", "Gregory Moore", "Larry Hall", "Patrick Moore", "Ben Smith",
            "Jose Smith", "Michael Parker", "Jeff Smith", "Larry Thompson", "Joel Smith", "Ivan Spencer",
            "Robert Anderson", "Lee Phillips", "Stanley Warren", "William Sanchez", "Jamie McDonald",
            "David Griffith", "Terry Hicks", "Larry Johnson", "Mike Fowler", "Ivan Shaw", "Lee Stevenson",
            "Lee Powell", "Larry King", "Lee Mitchell", "Robert Diaz", "John Fowler", "Todd Cox",
            "David James", "Willie Bryan", "Thomas Howard", "Ivan Stanley", "Paul Harper", "Robert King",
            "David Stanley", "Dale Fletcher", "Larry Mullins", "Arthur King", "Robert King", "John King",
            "Larry Coleman", "Anthony King", "Ivan Johnson", "Ivan Mann", "Michael Diaz", "Leroy Smith",
            "King Wagner", "David Stanley", "Ivan Willis", "Ivan Stewart", "Frank King", "Roland Jones",
            "Leroy Warren", "Rodney Bailey", "David King", "Randy King", "James Soto", "James Parker",
            "Bobby Stanley", "Leroy Cooper", "Michael Woods", "David Mann", "Lee Padilla", "Samuel Shelton",
            "Jesse Simmons", "Ivan Stanley", "Lee Gibson", "Bryan King", "David Brooks", "David Fowler",
            "Robert Fowler", "Ivan King", "Donald Thomas", "Leroy Ramsey", "Russell Diaz", "David Torres"
    );

    private static final List<String> KINGS = List.of(
            "King Lee", "Leonard King", "King Mann", "Larry King", "Robert King", "Arthur King",
            "Robert King", "John King", "Anthony King", "King Wagner", "Frank King", "David King", "Randy King",
            "Bryan King", "Ivan King"
    );

    private static final List<String> UNIQ_SURNAMES = List.of(
            "Smith", "Doyle", "Pratt", "Spencer",
            "Lee", "Zimmerman", "Harrington", "Daniels", "Williams", "Terry", "Fowler", "Harrison",
            "Bennett", "Evans", "Diaz", "King", "Mann", "Wright", "Richards", "Moore", "Hall", "Parker",
            "Thompson", "Anderson", "Phillips", "Warren", "Sanchez", "McDonald", "Griffith", "Hicks",
            "Johnson", "Shaw", "Stevenson", "Powell", "Mitchell", "Cox", "James", "Bryan", "Howard",
            "Stanley", "Harper", "Fletcher", "Mullins", "Coleman", "Wagner", "Willis", "Stewart",
            "Jones", "Bailey", "Soto", "Cooper", "Woods", "Padilla", "Shelton", "Simmons", "Gibson",
            "Brooks", "Thomas", "Ramsey", "Torres"
    );

    private static final List<String> NAMES_STARTS_WITH_L = List.of(
            "Leroy", "Lee", "Leonard", "Larry"
    );

    private static final List<String> SURNAMES_STARTS_WITH_W_SORTED = List.of(
            "Wagner", "Warren", "Williams", "Willis", "Woods", "Wright"
    );

    private static final List<String> NAMES_WITH_LETTER_SORTED = List.of(
            "Anthony K.", "Arthur K.", "Arthur S.", "Ben S.", "Bobby S.", "Bryan K.", "David K.",
            "David S.", "Frank K.", "Gregory S.", "Ivan K.", "Ivan S.", "James S.", "Jeff S.", "Jesse S.",
            "Joel S.", "John K.", "Jose S.", "Joseph S.", "Larry K.", "Lee S.", "Leonard K.", "Leroy S.",
            "Randy K.", "Robert K.", "Samuel S.", "Thomas S.", "Timothy S.", "William S."
    );

    private static final Integer NAMES_LONGER_THAN_SIX = 9;

    private static final Integer NAMES_AND_SURNAMES_LONGER_THAN_FIVE = 61;

    public static class AntiCheat {
        public static void run() {
            List<String> antiCheatList = new ArrayList<>();
            antiCheatList.addAll(FULL_NAMES);
            antiCheatList.addAll(KINGS);
            antiCheatList.addAll(UNIQ_SURNAMES);
            antiCheatList.addAll(NAMES_STARTS_WITH_L);
            antiCheatList.addAll(SURNAMES_STARTS_WITH_W_SORTED);
            antiCheatList.addAll(NAMES_WITH_LETTER_SORTED);
            antiCheatList.add(NAMES_LONGER_THAN_SIX.toString());
            antiCheatList.add(NAMES_AND_SURNAMES_LONGER_THAN_FIVE.toString());
            calcHash(antiCheatList);
        };

        public static String bytesToHex(byte[] bytes) {
            char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
            char[] hexChars = new char[bytes.length * 2];
            for (int j = 0; j < bytes.length; j++) {
                int v = bytes[j] & 0xFF;
                hexChars[j * 2] = HEX_ARRAY[v >>> 4];
                hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
            }
            return new String(hexChars);
        }

        public static void calcHash(List<String> list) {
            String total = String.join("", list);
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(total.getBytes());
                byte[] digest = md.digest();
                System.out.println("AntiCheatCheck: " + bytesToHex(digest));
            } catch (NoSuchAlgorithmException ignored) {}
        }
    }

    public static String constLen(String str, int len) {
        StringBuilder sb = new StringBuilder(str);
        while (len-- - str.length() > 0) sb.append(" ");
        return sb.toString();
    }

    public static void printTestCase(List<String> exp, List<String> act) {
        System.out.println();
        Function<String, String> green = str -> "\u001B[34m" + str + "\u001B[0m";
        Function<String, String> yellow = str -> "\u001B[33m" + str + "\u001B[0m";
        System.out.println("Ожидание: " + yellow.apply(constLen(exp.toString(), 15)));
        System.out.println("Реальность: " + green.apply(constLen(act.toString(), 15)));
        System.out.print("RESULT ");
        if (Objects.equals(exp, act)) System.out.print("✅"); else System.out.print("❌");
        System.out.println();
    }

    public static void printTestCase(Integer exp, Integer act) {
        System.out.println();
        Function<String, String> green = str -> "\u001B[34m" + str + "\u001B[0m";
        Function<String, String> yellow = str -> "\u001B[33m" + str + "\u001B[0m";
        System.out.println("Ожидание: " + yellow.apply(constLen(exp.toString(), 15)));
        System.out.println("Реальность: " + green.apply(constLen(act.toString(), 15)));
        System.out.print("RESULT ");
        if (Objects.equals(exp, act)) System.out.print("✅"); else System.out.print("❌");
        System.out.println();
    }
}
