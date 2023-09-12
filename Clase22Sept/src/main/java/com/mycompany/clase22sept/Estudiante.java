
package com.mycompany.clase22sept;

import javax.swing.JOptionPane;

public class Estudiante {
    private String Nombre;
    private String Programa;
    private int Asistencia;
    private int Identificacion;
    private boolean Estado;
    private float Nota;

    public Estudiante() {
        this.Nombre = JOptionPane.showInputDialog(null,"Nombre del estudiante.");
        this.Programa = JOptionPane.showInputDialog(null,"Nombre del programa.");
        this.Identificacion = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese cédula del estudiante."));
        this.Estado = true;
        this.Asistencia = 0;
        this.Nota = 0;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getPrograma() {
        return Programa;
    }

    public void setPrograma(String Programa) {
        this.Programa = Programa;
    }

    public int getAsistencia() {
        return Asistencia;
    }

    public void setAsistencia(int Asistencia) {
        this.Asistencia = Asistencia;
    }

    public int getIdentificacion() {
        return Identificacion;
    }

    public void setIdentificacion(int Identificacion) {
        this.Identificacion = Identificacion;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    public float getNota() {
        return Nota;
    }

    public void setNota(float Nota) {
        this.Nota = Nota;
    }
    
    public void registrarFaltas(){
        int faltas = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese las faltas."));
        
        Asistencia+=faltas;
        if(Asistencia >= 13){
            Nota = 0;
        }
    }
    
    public void registrarNota() {
        if(Asistencia < 13) {
            Nota = Float.parseFloat(JOptionPane.showInputDialog(null,"Ingrese la nota del estudiante."));
        }
    }
}
