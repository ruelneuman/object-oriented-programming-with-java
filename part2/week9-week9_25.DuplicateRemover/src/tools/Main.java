package tools;

public class Main {

    public static void main(String[] args) {
        PersonalDuplicateRemover remover = new PersonalDuplicateRemover();

        remover.add("first");
        System.out.println(remover.getNumberOfDetectedDuplicates());
        remover.add("second");
        System.out.println(remover.getNumberOfDetectedDuplicates());
        remover.add("second");
        System.out.println(remover.getNumberOfDetectedDuplicates());
        remover.add("second");
        System.out.println(remover.getNumberOfDetectedDuplicates());
        remover.add("third");
        System.out.println(remover.getNumberOfDetectedDuplicates());
        remover.add("first");
        System.out.println(remover.getNumberOfDetectedDuplicates());
        System.out.println(remover.getUniqueCharacterStrings());
        remover.empty();
        System.out.println(remover.getUniqueCharacterStrings());
        System.out.println(remover.getNumberOfDetectedDuplicates());
    }
}
