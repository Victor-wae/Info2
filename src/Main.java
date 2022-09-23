public class Main {
    public static void main(String... args) {
        Integer i1 = 128;
        Integer i2 = 128;
        Integer i3 = 42;
        Integer i4 = 42;
        String s1 = "EPL";
        String s2 = new String("EPL");

        System.out.println(i1 == i2);
        System.out.println(i3 == i4);
        System.out.println(s1 == s2);
    }
}
