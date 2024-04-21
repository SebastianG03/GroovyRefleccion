package domain.entities;

public class Vehiculo {
    private int galonesGasolina;
    private String marca;
    private String modelo;

    public String getMarca() {
        return "Marca: " + marca;
    }

    public String getModelo() {
        return "Modelo: " + modelo;
    }

    public String getGalonesGasolina() {
        return "Galones: " + galonesGasolina;
    }

    public void setGalonesGasolina(int galonesGasolina) {
        this.galonesGasolina = galonesGasolina;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void encender() {
        System.out.println("Encendido");
    }

    public void acelerar() {
        System.out.println("Acelerando");
    }

    public void frenar() {
        System.out.println("Frenando");
    }
}
