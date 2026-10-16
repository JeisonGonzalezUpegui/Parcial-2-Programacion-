public enum CategoriaPrenda {
    CAMISETA(0.00),
    PANTALON(0.00),
    VESTIDO(0.10),
    CHAQUETA(0.15),
    CALZADO(0.05);

    private double Recargo;

    CategoriaPrenda(double recargo) {
        Recargo = recargo;
    }

    public double getRecargo() {
        return Recargo;
    }
}
