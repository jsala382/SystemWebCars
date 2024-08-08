package org.jsalaza.apiservlet.webappheaders.modelo;

public class Color {
    private int id;
    private String tone;
    private int idCar;

  /*  public Color(String tone, int idCar) {
        this.tone = tone;
        this.idCar = idCar;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTone() {
        return tone;
    }

    public void setTone(String tone) {
        this.tone = tone;
    }

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }
}
