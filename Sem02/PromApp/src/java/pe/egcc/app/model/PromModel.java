package pe.egcc.app.model;

public class PromModel {

  // input
  private int pract1;
  private int pract2;
  private int pract3;
  private int pract4;
  private int exaParcial;
  private int exaFinal;
  
  // Output
  private int practMenor;
  private int promPract;
  private int promFinal;
  private String estado;

  public PromModel() {
  }

  public PromModel(int pract1, int pract2, int pract3, int pract4, int exaParcial, int exaFinal) {
    this.pract1 = pract1;
    this.pract2 = pract2;
    this.pract3 = pract3;
    this.pract4 = pract4;
    this.exaParcial = exaParcial;
    this.exaFinal = exaFinal;
  }

  public void setPromPract(int promPract) {
    this.promPract = promPract;
  }

  public int getPromPract() {
    return promPract;
  }
  
  public int getPract1() {
    return pract1;
  }

  public void setPract1(int pract1) {
    this.pract1 = pract1;
  }

  public int getPract2() {
    return pract2;
  }

  public void setPract2(int pract2) {
    this.pract2 = pract2;
  }

  public int getPract3() {
    return pract3;
  }

  public void setPract3(int pract3) {
    this.pract3 = pract3;
  }

  public int getPract4() {
    return pract4;
  }

  public void setPract4(int pract4) {
    this.pract4 = pract4;
  }

  public int getExaParcial() {
    return exaParcial;
  }

  public void setExaParcial(int exaParcial) {
    this.exaParcial = exaParcial;
  }

  public int getExaFinal() {
    return exaFinal;
  }

  public void setExaFinal(int exaFinal) {
    this.exaFinal = exaFinal;
  }

  public int getPractMenor() {
    return practMenor;
  }

  public void setPractMenor(int practMenor) {
    this.practMenor = practMenor;
  }

  public int getPromFinal() {
    return promFinal;
  }

  public void setPromFinal(int promFinal) {
    this.promFinal = promFinal;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  
}
