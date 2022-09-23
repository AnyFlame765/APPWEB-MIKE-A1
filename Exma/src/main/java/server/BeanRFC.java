package server;

public class BeanRFC {

    int id;
    String rfc;
    String name;
    String apellido1;
    String apellido2;
    String curp;
    String anio;
    String mes;
    String dia;

    public BeanRFC(int id, String rfc, String name, String apellido1, String apellido2, String curp, String anio, String mes, String dia) {
        this.id = id;
        this.rfc = rfc;
        this.name = name;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.curp = curp;
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
    }

    public BeanRFC() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }


    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
}
