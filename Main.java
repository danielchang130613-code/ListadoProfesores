//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ListaProfesores lista = new ListaProfesores();

        lista.add(new Profesor("Ana Pérez", 28, "Instructor"));
        lista.add(new Profesor("Luis Gómez", 25, "Instructor"));
        lista.add(new Profesor("Marta Ruiz", 35, "Asistente"));
        lista.add(new Profesor("Carlos Díaz", 40, "Auxiliar"));
        lista.add(new Profesor("Elena Torres", 50, "Titular"));
        lista.add(new Profesor("Pedro Sánchez", 30, "Instructor"));

        System.out.println("===== a) Próximos a cambio =====");
        System.out.println(lista.ProxCambio());

        System.out.println("===== b) Ordenados por edad =====");
        System.out.println(lista.MostrarLista());

        System.out.println(" Cantidad por categoría");
        System.out.println(lista.CantProfesores());
    }
}
