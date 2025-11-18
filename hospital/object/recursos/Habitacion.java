package hospital.object.recursos;

import hospital.state.IHabitacionState;

public class Habitacion {
    private IHabitacionState estado;
    
    private int piso;
    private int pasillo;
    private int numCamas;

    public Habitacion(int piso, int pasillo, int numCamas) {
        this.piso = piso;
        this.pasillo = pasillo;
        this.numCamas = numCamas;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getPasillo() {
        return pasillo;
    }

    public void setPasillo(int pasillo) {
        this.pasillo = pasillo;
    }

    public void setEstado(IHabitacionState estado){
        this.estado = estado;
    }

    public IHabitacionState getEstado() {
        return estado;
    }

    public int getNumCamas() {
        return numCamas;
    }

    public void setNumCamas(int numCamas) {
        this.numCamas = numCamas;
    }
}
