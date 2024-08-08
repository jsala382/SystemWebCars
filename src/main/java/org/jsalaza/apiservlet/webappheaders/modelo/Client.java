package org.jsalaza.apiservlet.webappheaders.modelo;

public class Client {
    private int id;
    private String identificationCard;
    private String name;
    private String gender;
    private String civilStatus;
    private String typeDocuments;
    private String address;
    private String phones;
    private int idCity;
    private int idProvinces;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentificationCard() {
        return identificationCard;
    }

    public void setIdentificationCard(String identificationCard) {
        this.identificationCard = identificationCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    public String getTypeDocuments() {
        return typeDocuments;
    }

    public void setTypeDocuments(String typeDocuments) {
        this.typeDocuments = typeDocuments;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhones() {
        return phones;
    }

    public void setPhones(String phones) {
        this.phones = phones;
    }

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public int getIdProvinces() {
        return idProvinces;
    }

    public void setIdProvinces(int idProvinces) {
        this.idProvinces = idProvinces;
    }
}
