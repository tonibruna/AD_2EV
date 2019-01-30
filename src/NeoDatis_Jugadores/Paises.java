package NeoDatis_Jugadores;

public class Paises {

	 // Propiedades
    private int idPais;
    private String nomPais;
    
    // Constructores
    public Paises(){};
   
    public Paises(int idPais, String nomPais) {
          super();
          this.idPais = idPais;
          this.nomPais = nomPais;
    }
    
    // Métodos
    public int getIdPais() {
          return idPais;
    }
    public void setIdPais(int idPais) {
          this.idPais = idPais;
    }
    public String getNomPais() {
          return nomPais;
    }
    public void setNomPais(String nomPais) {
          this.nomPais = nomPais;
    }
    
} //Fin clase
