/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personaje;

import Enumeracion.Franquicia;
import Enumeracion.TierEnum;
import Enumeracion.TipoEnum;

/**
 *
 * @author andre
 */
public class Personaje{
    
    private String nombre;
    private int id;
    private Franquicia franquicia;
    private TierEnum tier;
    private TipoEnum tipo;
    private String imgPath;

    public Personaje(String name, int id, Franquicia franquicia, String imgPath) {
        this.nombre = name;
        this.id = id;
        this.franquicia = franquicia;
        this.imgPath= imgPath;
        //define su tipo 
        this.tierTypeAlg();
    }
    
    public Personaje(Personaje clone){
        this.franquicia = clone.getFranquicia();
        this.nombre = clone.getNombre();
        this.tierTypeAlg();
        this.imgPath = clone.getImgPath();
    }
    
    public void tierTypeAlg(){
        boolean[] type = new boolean[4];
        double[] base = {0.7,0.6,0.5,0.4};
        double prob;
        for (int i = 0; i < 4; i++) {
            prob = Math.random();
            type[i] = (prob<=base[i]);
        }
        if(type[2]&&type[3]){
            this.tipo = TipoEnum.MASTER;
        }else if(type[2]||type[3]){
            this.tipo = TipoEnum.SKILLED;
        }else if(type[1]||type[0]){
            this.tipo = TipoEnum.DEFICIENT;
        }else if(!type[1]&&!type[0]){
            this.tipo = TipoEnum.WEAK;
        }else{
            this.tipo = TipoEnum.AVERAGE;
        }
        
        
       
        switch(this.tipo){
            case WEAK:
                this.tier = TierEnum.THIRD;
                break;
            case DEFICIENT:
                this.tier = TierEnum.THIRD;
                break;
            case AVERAGE:
                this.tier = TierEnum.SECOND;
                break;
            case SKILLED:
                this.tier = TierEnum.SECOND;
                break;
            case MASTER:
                this.tier = TierEnum.FIRST;
                break;
        }
    }
    /**
     * @return the name
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the name to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the company
     */
    public Franquicia getFranquicia() {
        return franquicia;
    }

    /**
     * @param franquicia the company to set
     */
    public void setFranquicia(Franquicia franquicia) {
        this.franquicia = franquicia;
    }

    /**
     * @return the tier
     */
    public TierEnum getTier() {
        return tier;
    }

    /**
     * @param tier the tier to set
     */
    public void setTier(TierEnum tier) {
        this.tier = tier;
    }

    /**
     * @return the tipo
     */
    public TipoEnum getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoEnum tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the imgPath
     */
    public String getImgPath() {
        return imgPath;
    }

    /**
     * @param imgPath the imgPath to set
     */
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    
}
