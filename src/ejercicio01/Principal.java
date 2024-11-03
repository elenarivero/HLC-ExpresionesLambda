package ejercicio01;

public class Principal {

	public static void main(String[] args) {
		Saludo<String> saludo1 = s -> "Hola " + s;
		Saludo<Cliente> saludo2 = c -> "Hola " + c.getNombre();
		
		System.out.println(saludo1.saludar("Elena"));
		System.out.println(saludo2.saludar(new Cliente("Pepe")));

	}

}
