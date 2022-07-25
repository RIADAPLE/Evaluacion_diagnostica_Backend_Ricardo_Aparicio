package palabrathis;

public class PalabraThis {
    public static void main(String[] args) {
        Personita p = new Personita("Juan");
    }
}

class Personita {
    String nombre;

    Personita(String nombre){
        this.nombre = nombre;

        Imprimir i = new Imprimir();
        i.imprimir(this);
    }
}

class Imprimir{
    public void imprimir(Object o){
        System.out.println("Imprimir parametro: " + o);

        System.out.println("Imprimir objeto actual (this): " + this);
    }
}
