/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import Personaje.Personaje;
import Enumeracion.TierEnum;

/**
 *
 * @author diego
 */
public class Cola {

    private Nodo front;
    private Nodo back;
    private int size;

    public Cola() {
        this.front = null;
        this.back = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return getFront() == null;
    }

    public void empty() {
        this.front = null;
        this.back = null;
        this.size = 0;
    }
    
    //Desencolar los nodos que ya llevan 8 ciclos
    public Cola desencolarFullCiclo() {
        Cola auxQ = new Cola();
        int queueSize = getSize();
        for (int i = 0; i < queueSize; i++) {
            
            Nodo pAux = desencolar();
            if(pAux != null){
            if (pAux.getCycle() == 8 ) {
                pAux.setCycle(0);
                auxQ.queue(pAux);
                
            }else {
               
                pAux.setCycle(pAux.getCycle() + 1);
               
                queue(pAux);

            } }
        }

        return auxQ;
    }

    //Encola los nodos que deben cambiar de cola (completaron un ciclo)
    public void encolarNodosFullCiclo(Cola cycleQueue, TierEnum newTier) {
        
        if(!cycleQueue.isEmpty()){
        Nodo pAux=cycleQueue.desencolar();
            
            
            while(pAux !=null){
                
            
            pAux.getPersonaje().setTier(newTier);
            queue(pAux);
            pAux = cycleQueue.desencolar();}
            
            
            
        }

    }

    public void cola(Personaje personaje, int id, int cycle) {
        Nodo newNodo = new Nodo(personaje, id, cycle);
        if (isEmpty()) {
            setFront(newNodo);
            setBack(newNodo);

        } else {
            getBack().setNext(newNodo);
            setBack(newNodo);

        }
        setSize(getSize() + 1);

    }

    public void queue(Nodo newNodo) {
        newNodo.setNext(null);
        if (isEmpty()) {
            setFront(newNodo);
            setBack(newNodo);

        } else {
            getBack().setNext(newNodo);
            setBack(newNodo);

        }
        setSize(getSize() + 1);

    }

    public Nodo desencolar() {
        Nodo ret = null;
        if (!isEmpty()) {
            ret = getFront();

            setFront(getFront().getNext());
            setSize(getSize() - 1);

        }
        return ret;
    }

    public Personaje desencolarPersonaje() {
        Personaje ret = null;

        if (!isEmpty()) {
            ret = getFront().getPersonaje();
            desencolar();
        }
        return ret;
    }

    public String[] toArray() {
        try {
            if (!isEmpty()) {
                String[] array = new String[getSize()];
                Nodo ch = null;
                for (int i = 0; i < array.length; i++) {
                    ch = desencolar();
                    array[i] = ch.getId() + ": " + ch.getPersonaje().getNombre();
                    queue(ch);
                }

                return array;

            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @return the front
     */
    public Nodo getFront() {
        return front;
    }

    /**
     * @param front the front to set
     */
    public void setFront(Nodo front) {
        this.front = front;
    }

    /**
     * @return the back
     */
    public Nodo getBack() {
        return back;
    }

    /**
     * @param back the back to set
     */
    public void setBack(Nodo back) {
        this.back = back;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

   public void print(){
        Nodo aux = this.getFront();
        Nodo in=aux;
        do{
            System.out.println(front.getPersonaje().getNombre());
            desencolar();
            queue(in);
            in=this.getFront();
        }while(aux!=in);
        System.out.println("done");
    }
    
}
