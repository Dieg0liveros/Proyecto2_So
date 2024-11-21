/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Enumeracion;

/**
 *
 * @author andre
 */
public enum Franquicia {
    
    STARWARS(0),
    STARTREK(1),;
    
    private final int id;
    
    
    private Franquicia(int id){
        this.id = id;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

}
