public class Main {
    public static void main(String[] args) {
        // Integer types
        byte age = 25;
        short year = 2024;
        int population = 1400000000;
        long worldPopulation = 8000000000L;

        // Floating-point types
        float price = 19.99f;
        double pi = 3.141592653589793;

        // Character type
        char grade = 'A';

        // Boolean type
        boolean isActive = true;

        // Printing all values
        System.out.println("=== Java Primitive Types Demo ===");
        System.out.println("byte (age): " + age);
        System.out.println("short (year): " + year);
        System.out.println("int (population): " + population);
        System.out.println("long (world population): " + worldPopulation);
        System.out.println("float (price): " + price);
        System.out.println("double (pi): " + pi);
        System.out.println("char (grade): " + grade);
        System.out.println("boolean (isActive): " + isActive);

        // Type information
        System.out.println("\n=== Size Information ===");
        System.out.println("byte size: " + Byte.BYTES + " bytes");
        System.out.println("short size: " + Short.BYTES + " bytes");
        System.out.println("int size: " + Integer.BYTES + " bytes");
        System.out.println("long size: " + Long.BYTES + " bytes");
        System.out.println("float size: " + Float.BYTES + " bytes");
        System.out.println("double size: " + Double.BYTES + " bytes");
        System.out.println("char size: " + Character.BYTES + " bytes");

        // Min/Max values
        System.out.println("\n=== Range Information ===");
        System.out.println("byte range: " + Byte.MIN_VALUE + " to " + Byte.MAX_VALUE);
        System.out.println("int range: " + Integer.MIN_VALUE + " to " + Integer.MAX_VALUE);
        System.out.println("double range: " + Double.MIN_VALUE + " to " + Double.MAX_VALUE);
    }
}
