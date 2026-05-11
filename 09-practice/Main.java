public class Main {

	static void myMethod() {
		String name = "Welcome to Java Programming";
		System.out.println("This is a static method" + " " + name.length());
		System.out.println("This is a static method" + " " + name.toUpperCase());
		System.out.println("This is a static method" + " " + name.startsWith("Welcome"));
		System.out.println("This is a static method" + " " + name.endsWith("Programming"));
		System.out.println(name.replace("to", "Hello"));
	}

	public static void main(String[] args) {
		myMethod();
	}
}
