/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Enumeracion;

/**
 *
 * @author chris
 */
public enum TipoEnum {
    
    MASTER(4),
    SKILLED(3),
    AVERAGE(2),
    DEFICIENT(1),
    WEAK(0);
    
     private final int id;
    
    private TipoEnum(int id){
        this.id = id;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    
    
    
}
