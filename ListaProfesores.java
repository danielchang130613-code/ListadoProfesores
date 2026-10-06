public class ListaProfesores {
    private Node<Profesor> first;
    private int size;

    public ListaProfesores() {
        this.first = null;
        this.size = 0;
    }


    public void add(Profesor p) {
        Node<Profesor> node = new Node<>(p);
        if (isEmpty()) {
            first = node;
        } else {
            Node<Profesor> cursor = first;
            while (cursor.getNext() != null) {
                cursor = cursor.getNext();
            }
            cursor.setNext(node);
        }
        size++;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public String ProxCambio() {
        String resultado = "Profesores próximos a cambio de categoría:\n";
        Node<Profesor> cursor = first;
        boolean hay = false;

        while (cursor != null) {
            Profesor p = cursor.getInfo();
            if (p.getCategoria().equalsIgnoreCase("Instructor") && p.getEdad() > 26) {
                resultado += "- " + p.getNombre() + " (" + p.getEdad() + " años)\n";
                hay = true;
            }
            cursor = cursor.getNext();
        }

        if (!hay) {
            resultado += "No hay profesores en esta condición.\n";
        }
        return resultado;
    }

    public String MostrarLista() {

        Profesor[] arreglo = new Profesor[size];
        Node<Profesor> cursor = first;
        int i = 0;
        while (cursor != null) {
            arreglo[i] = cursor.getInfo();
            cursor = cursor.getNext();
            i++;
        }
        for (int j = 0; j < size - 1; j++) {
            for (int k = 0; k < size - 1 - j; k++) {
                if (arreglo[k].getEdad() < arreglo[k + 1].getEdad()) {
                    Profesor temp = arreglo[k];
                    arreglo[k] = arreglo[k + 1];
                    arreglo[k + 1] = temp;
                }
            }
    }

        String resultado = "Profesores ordenados por edad (mayor a menor):\n";
        for (int j = 0; j < size; j++) {
            resultado += arreglo[j].toString() + "\n";
        }
        return resultado;
    }
    public String CantProfesores() {
        int instructores = 0, asistentes = 0, auxiliares = 0, titulares = 0;

        Node<Profesor> cursor = first;
        while (cursor != null) {
            String cat = cursor.getInfo().getCategoria();
            if (cat.equalsIgnoreCase("Instructor")) instructores++;
            else if (cat.equalsIgnoreCase("Asistente")) asistentes++;
            else if (cat.equalsIgnoreCase("Auxiliar")) auxiliares++;
            else if (cat.equalsIgnoreCase("Titular")) titulares++;

            cursor = cursor.getNext();
        }

        return "Cantidad de profesores por categoría:\n" +
                "Instructores: " + instructores + "\n" +
                "Asistentes: " + asistentes + "\n" +
                "Auxiliares: " + auxiliares + "\n" +
                "Titulares: " + titulares + "\n";
    }

}