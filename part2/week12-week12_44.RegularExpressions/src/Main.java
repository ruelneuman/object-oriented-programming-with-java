
public class Main {

    public static void main(String[] args) {
        System.out.println(clockTime("23:00:45"));
    }

    public static boolean isAWeekDay(String string) {
        return string.matches("mon|tue|wed|thu|fri|sat|sun");
    }

    public static boolean allVowels(String string) {
        return string.matches("[aeiouäö]*");
    }

    public static boolean clockTime(String string) {
        // 23:59:59
        return string.matches("([01][0-9]|2[0-3])(:[0-5][0-9]){2}");
    }
}
