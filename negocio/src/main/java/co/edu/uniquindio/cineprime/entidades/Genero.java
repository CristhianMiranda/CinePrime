package co.edu.uniquindio.cineprime.entidades;

public enum Genero {
    ACCION(1),
    COMEDIA(2),
    ROMANCE(3),
    CIENCIA_FICCION(4),
    ANIME(5),
    ANIMACION(6),
    DOCUMENTAL(7),
    TERROR(8),
    DRAMA(9);

    private int valor;

    Genero(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
