/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Buffer;

import java.util.concurrent.Semaphore;
import EDD.Cola;
import Personaje.Personaje;

/**
 *
 * @author andre
 */
public class Buffer {
    
    
    //personajes
    private Personaje[] SWARSPersonajes = new Personaje[20];
    private Personaje[] STREKPersonajes = new Personaje[20];
    
    //listas de ganadores
    private Cola SWARSWinners = new Cola();
    private Cola STREKWinners = new Cola();
    
    //colas de Nick
    private Cola SWARSTier1Cola = new Cola();
    private Cola SWARSTier2Cola = new Cola();
    private Cola SWARSTier3Cola = new Cola();
    private Cola SWARSEffortCola = new Cola();
    
    //colas de Cartoon
    private Cola STREKTier1Cola = new Cola();
    private Cola STREKTier2Cola = new Cola();
    private Cola STREKTier3Cola = new Cola();
    private Cola STREKEffortCola = new Cola();
    
    //semaforos de sincronizacion
    private final Semaphore s1 = new Semaphore(0);
    private final Semaphore s2 = new Semaphore(0);
    
    //contador de ciclos
    private int numCiclos = 0;
    
    //luchadores 
    private Personaje SWARSFighter;
    private Personaje STREKFighter;
    
    //simulacion
    private double simSpeed=500;
    private double nextSim = 1000;
    private double simLoad = 2000;

    public Buffer() {
    }

    /**
     * @return the SWARSPersonajes
     */
    public Personaje[] getSWARSPersonajes() {
        return SWARSPersonajes;
    }

    /**
     * @param SWARSPersonajes the SWARSPersonajes to set
     */
    public void setSWARSPersonajes(Personaje[] SWARSPersonajes) {
        this.SWARSPersonajes = SWARSPersonajes;
    }

    /**
     * @return the STREKPersonajes
     */
    public Personaje[] getSTREKPersonajes() {
        return STREKPersonajes;
    }

    /**
     * @param STREKPersonajes the STREKPersonajes to set
     */
    public void setSTREKPersonajes(Personaje[] STREKPersonajes) {
        this.STREKPersonajes = STREKPersonajes;
    }

    /**
     * @return the SWARSWinners
     */
    public Cola getSWARSWinners() {
        return SWARSWinners;
    }

    /**
     * @param SWARSWinners the SWARSWinners to set
     */
    public void setSWARSWinners(Cola SWARSWinners) {
        this.SWARSWinners = SWARSWinners;
    }

    /**
     * @return the STREKWinners
     */
    public Cola getSTREKWinners() {
        return STREKWinners;
    }

    /**
     * @param STREKWinners the STREKWinners to set
     */
    public void setSTREKWinners(Cola STREKWinners) {
        this.STREKWinners = STREKWinners;
    }

    /**
     * @return the SWARSTier1Cola
     */
    public Cola getSWARSTier1Cola() {
        return SWARSTier1Cola;
    }

    /**
     * @param SWARSTier1Cola the SWARSTier1Cola to set
     */
    public void setSWARSTier1Cola(Cola SWARSTier1Cola) {
        this.SWARSTier1Cola = SWARSTier1Cola;
    }

    /**
     * @return the SWARSTier2Cola
     */
    public Cola getSWARSTier2Cola() {
        return SWARSTier2Cola;
    }

    /**
     * @param SWARSTier2Cola the SWARSTier2Cola to set
     */
    public void setSWARSTier2Cola(Cola SWARSTier2Cola) {
        this.SWARSTier2Cola = SWARSTier2Cola;
    }

    /**
     * @return the SWARSTier3Cola
     */
    public Cola getSWARSTier3Cola() {
        return SWARSTier3Cola;
    }

    /**
     * @param SWARSTier3Cola the SWARSTier3Cola to set
     */
    public void setSWARSTier3Cola(Cola SWARSTier3Cola) {
        this.SWARSTier3Cola = SWARSTier3Cola;
    }

    /**
     * @return the SWARSEffortCola
     */
    public Cola getSWARSEffortCola() {
        return SWARSEffortCola;
    }

    /**
     * @param SWARSEffortCola the SWARSEffortCola to set
     */
    public void setSWARSEffortCola(Cola SWARSEffortCola) {
        this.SWARSEffortCola = SWARSEffortCola;
    }

    /**
     * @return the STREKTier1Cola
     */
    public Cola getSTREKTier1Cola() {
        return STREKTier1Cola;
    }

    /**
     * @param STREKTier1Cola the STREKTier1Cola to set
     */
    public void setSTREKTier1Cola(Cola STREKTier1Cola) {
        this.STREKTier1Cola = STREKTier1Cola;
    }

    /**
     * @return the STREKTier2Cola
     */
    public Cola getSTREKTier2Cola() {
        return STREKTier2Cola;
    }

    /**
     * @param STREKTier2Cola the STREKTier2Cola to set
     */
    public void setSTREKTier2Cola(Cola STREKTier2Cola) {
        this.STREKTier2Cola = STREKTier2Cola;
    }

    /**
     * @return the STREKTier3Cola
     */
    public Cola getSTREKTier3Cola() {
        return STREKTier3Cola;
    }

    /**
     * @param STREKTier3Cola the STREKTier3Cola to set
     */
    public void setSTREKTier3Cola(Cola STREKTier3Cola) {
        this.STREKTier3Cola = STREKTier3Cola;
    }

    /**
     * @return the STREKEffortCola
     */
    public Cola getSTREKEffortCola() {
        return STREKEffortCola;
    }

    /**
     * @param STREKEffortCola the STREKEffortCola to set
     */
    public void setSTREKEffortCola(Cola STREKEffortCola) {
        this.STREKEffortCola = STREKEffortCola;
    }

    /**
     * @return the s1
     */
    public Semaphore getS1() {
        return s1;
    }

   
    /**
     * @return the s2
     */
    public Semaphore getS2() {
        return s2;
    }

   
    /**
     * @return the numCiclos
     */
    public int getNumCiclos() {
        return numCiclos;
    }

    /**
     * @param numCiclos the numCiclos to set
     */
    public void setNumCiclos(int numCiclos) {
        this.numCiclos = numCiclos;
    }

    /**
     * @return the SWARSFighter
     */
    public Personaje getSWARSFighter() {
        return SWARSFighter;
    }

    /**
     * @param SWARSFighter the SWARSFighter to set
     */
    public void setSWARSFighter(Personaje SWARSFighter) {
        this.SWARSFighter = SWARSFighter;
    }

    /**
     * @return the STREKFighter
     */
    public Personaje getSTREKFighter() {
        return STREKFighter;
    }

    /**
     * @param STREKFighter the STREKFighter to set
     */
    public void setSTREKFighter(Personaje STREKFighter) {
        this.STREKFighter = STREKFighter;
    }

    /**
     * @return the simSpeed
     */
    public double getSimSpeed() {
        return simSpeed;
    }

    /**
     * @param simSpeed the simSpeed to set
     */
    public void setSimSpeed(double simSpeed) {
        this.simSpeed = simSpeed;
    }

    /**
     * @return the nextSim
     */
    public double getNextSim() {
        return nextSim;
    }
    
    public void setNextSim(double nextSim){
        this.nextSim = nextSim;
    }

    /**
     * @return the simLoad
     */
    public double getSimLoad() {
        return simLoad;
    }

    /**
     * @param simLoad the simLoad to set
     */
    public void setSimLoad(double simLoad) {
        this.simLoad = simLoad;
    }
    
    
    
}
