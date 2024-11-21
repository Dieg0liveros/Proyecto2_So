/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Enumeracion;

/**
 *
 * @author diego
 */
public enum TierEnum {
    
    FIRST(0), 
    SECOND(1), 
    THIRD(2),
    REINFORCEMENT(3);
    
    private final int id;
    
    private TierEnum(int id){
        this.id = id;
    }
    
}
