/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personaje;

import Enumeracion.Franquicia;
import Enumeracion.TierEnum;
import Enumeracion.TipoEnum;
import static Enumeracion.TipoEnum.AVERAGE;
import static Enumeracion.TipoEnum.DEFICIENT;
import static Enumeracion.TipoEnum.MASTER;
import static Enumeracion.TipoEnum.SKILLED;
import static Enumeracion.TipoEnum.WEAK;
//import java.util.Arrays;
//import java.util.List;
import java.util.Random;
import EDD.Lista;
import EDD.Array;



public class Personaje {
    
    private String nombre;
    private int id;
    private Franquicia franquicia;
    private TierEnum tier;
    private TipoEnum tipo;
    private String imgPath;
    private String item; // Nuevo atributo para almacenar el ítem asignado

    public Personaje(String name, int id, Franquicia franquicia, String imgPath) {
        this.nombre = name;
        this.id = id;
        this.franquicia = franquicia;
        this.imgPath = imgPath;
        this.tierTypeAlg();
        this.item(); // Asignar ítem al inicializar
    }

    public Personaje(Personaje clone) {
        this.franquicia = clone.getFranquicia();
        this.nombre = clone.getNombre();
        this.tierTypeAlg();
        this.imgPath = clone.getImgPath();
        this.item();
    }

    public void tierTypeAlg() {
        boolean[] type = new boolean[4];
        double[] base = {0.7, 0.6, 0.5, 0.4};
        double prob;
        for (int i = 0; i < 4; i++) {
            prob = Math.random();
            type[i] = (prob <= base[i]);
        }
        if (type[2] && type[3]) {
            this.tipo = TipoEnum.MASTER;
        } else if (type[2] || type[3]) {
            this.tipo = TipoEnum.SKILLED;
        } else if (type[1] || type[0]) {
            this.tipo = TipoEnum.DEFICIENT;
        } else if (!type[1] && !type[0]) {
            this.tipo = TipoEnum.WEAK;
        } else {
            this.tipo = TipoEnum.AVERAGE;
        }

        switch (this.tipo) {
            case WEAK:
            case DEFICIENT:
                this.tier = TierEnum.THIRD;
                break;
            case AVERAGE:
            case SKILLED:
                this.tier = TierEnum.SECOND;
                break;
            case MASTER:
                this.tier = TierEnum.FIRST;
                break;
        }
    }

    public void item() {
        // Ítems por franquicia
        Lista<String> starWarsItems = Array.asList("Sable de luz", "Bláster E-11", "Destructor Estelar");
        Lista<String> starTrekItems = Array.asList("Faser", "Torpedo de fotones", "Escudo Deflector");

        // Generador aleatorio
        Random random = new Random();

        // Asignación según franquicia
        if (this.franquicia == Franquicia.STARWARS) {
            this.item = starWarsItems.get(random.nextInt(starWarsItems.size()));
        } else if (this.franquicia == Franquicia.STARTREK) {
            this.item = starTrekItems.get(random.nextInt(starTrekItems.size()));
        }
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Franquicia getFranquicia() {
        return franquicia;
    }

    public void setFranquicia(Franquicia franquicia) {
        this.franquicia = franquicia;
    }

    public TierEnum getTier() {
        return tier;
    }

    public void setTier(TierEnum tier) {
        this.tier = tier;
    }

    public TipoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoEnum tipo) {
        this.tipo = tipo;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    
}
