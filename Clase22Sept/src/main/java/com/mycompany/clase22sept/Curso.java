package com.mycompany.clase22sept;

import javax.swing.JOptionPane;

public class Curso {

    private String Curso;
    private int CantEstudiantes;
    private Estudiante[] Estudiantes;

    public Curso() {
        this.Curso = JOptionPane.showInputDialog(null, "Nombre del curso.");
        this.CantEstudiantes = 0;
        this.Estudiantes = new Estudiante[30];
    }

    public String getCurso() {
        return Curso;
    }

    public void setCurso(String Curso) {
        this.Curso = Curso;
    }

    public int getCantEstudiantes() {
        return CantEstudiantes;
    }

    public void setCantEstudiantes(int CantEstudiantes) {
        this.CantEstudiantes = CantEstudiantes;
    }

    public Estudiante[] getEstudiantes() {
        return Estudiantes;
    }

    public void setEstudiantes(Estudiante[] Estudiantes) {
        this.Estudiantes = Estudiantes;
    }

    public void registrarEstudiate() {
        if (CantEstudiantes < 30) {
            Estudiante nuevo = new Estudiante();
            Estudiantes[CantEstudiantes] = nuevo;
            CantEstudiantes++;
        }else{
            JOptionPane.showMessageDialog(null,"El curso está lleno.");
        }
    }
    
    public Estudiante buscarPorIdentificacion() {
        int Identificacion = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la identificación del estudiante."));
        Estudiante encontrado = null;
        int i = 0;
        boolean encontro = false;
        while (i < CantEstudiantes && !encontro) {
            if(Estudiantes[i].getIdentificacion() == Identificacion) {
                encontro = true;
                encontrado = Estudiantes[i];
            }
            i++;
        }
        return encontrado;
    }
    
    public void registrarFaltaAEstudiante(){
        JOptionPane.showMessageDialog(null,"Registrar falta a estudiante usando la cédula.");
        buscarPorIdentificacion().registrarFaltas();
    }
    
    public void aplicarNotaAEstudiante() {
        JOptionPane.showInputDialog(null,"Insertar nota a estudiante usando la cédula");
        buscarPorIdentificacion().registrarNota();
    }
}
