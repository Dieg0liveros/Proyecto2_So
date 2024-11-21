/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;

import javax.swing.DefaultListModel;
import Buffer.Buffer;
import EDD.Nodo;
import EDD.Cola;
import Interface.MainWindow;
import Personaje.Personaje;
import Enumeracion.TierEnum;
import static Enumeracion.TierEnum.FIRST;
import static Enumeracion.TierEnum.REINFORCEMENT;
import static Enumeracion.TierEnum.SECOND;
import static Enumeracion.TierEnum.THIRD;
import static Enumeracion.Franquicia.STARWARS;
import static Enumeracion.Franquicia.STARTREK;

/**
 *
 * @author HP
 */
public class Administrador extends Thread {

    private Buffer buffer;
    private MainWindow mainWindow;
    private int nextID;

    public Administrador(Buffer buffer, MainWindow main, int lastID) {
        this.buffer = buffer;
        this.mainWindow = main;
        this.nextID = lastID + 1;
    }

    @Override
    public void run() {

        while (true) {

            try {
                getBuffer().getS1().release();
                getBuffer().getS2().acquire();

            } catch (Exception e) {
            }

            if (getBuffer().getNumCiclos() == 2) {
                //Ingresar un nuevo personaje después de dos ciclos
                double randomNum = Math.random();

                if (randomNum <= 0.80) {

                    crearPersonaje();

                }
                
                getBuffer().setNumCiclos(0);
            }

            if(getBuffer().getSWARSFighter()!=null && getBuffer().getSTREKFighter()!=null){
               moverACola(getBuffer().getSTREKFighter());
               moverACola(getBuffer().getSWARSFighter());
               
            }
             updateWindow();

            //Actualizar las colas segun los nodos que completaron ciclo
            Cola fullCicloColaSwars2 = getBuffer().getSWARSTier2Cola().desencolarFullCiclo();
            getBuffer().getSWARSTier1Cola().encolarNodosFullCiclo(fullCicloColaSwars2, TierEnum.FIRST);

            Cola fullCicloColaSwars3 = getBuffer().getSWARSTier3Cola().desencolarFullCiclo();
            getBuffer().getSWARSTier2Cola().encolarNodosFullCiclo(fullCicloColaSwars3, TierEnum.SECOND);

            Cola fullCicloColaStrek2 = getBuffer().getSTREKTier2Cola().desencolarFullCiclo();
            getBuffer().getSTREKTier1Cola().encolarNodosFullCiclo(fullCicloColaStrek2, TierEnum.FIRST);

            Cola fullCicloColastrek3 = getBuffer().getSTREKTier3Cola().desencolarFullCiclo();
            getBuffer().getSTREKTier2Cola().encolarNodosFullCiclo(fullCicloColastrek3, TierEnum.SECOND);

            //Seleccionar los personajes a batallar
            Personaje swarsFighter = null;
            Personaje strekFighter = null;
 
            if (!buffer.getSWARSTier1Cola().isEmpty()) {
               
                swarsFighter = getBuffer().getSWARSTier1Cola().desencolarPersonaje();

            } else if (!buffer.getSWARSTier2Cola().isEmpty()) {

                swarsFighter = getBuffer().getSWARSTier2Cola().desencolarPersonaje();

            } else if (!buffer.getSWARSTier3Cola().isEmpty()) {

                swarsFighter = getBuffer().getSWARSTier3Cola().desencolarPersonaje();

            }
            

            if (!buffer.getSTREKTier1Cola().isEmpty()) {

                strekFighter = getBuffer().getSTREKTier1Cola().desencolarPersonaje();

            } else if (!buffer.getSTREKTier2Cola().isEmpty()) {

                strekFighter = getBuffer().getSTREKTier2Cola().desencolarPersonaje();

            } else if (!buffer.getSTREKTier3Cola().isEmpty()) {

                strekFighter = getBuffer().getSTREKTier3Cola().desencolarPersonaje();

            }
           

            //Administracion de cola de refuerzo
            double randomNum2 = Math.random();
           
            if (randomNum2 <= 0.40) {

                if (!buffer.getSTREKEffortCola().isEmpty()) {

                    Nodo StrekNewFighter = getBuffer().getSTREKEffortCola().desencolar();
                    StrekNewFighter.getPersonaje().setTier(FIRST);
                    getBuffer().getSTREKTier1Cola().queue(StrekNewFighter);

                }
                if (!buffer.getSWARSEffortCola().isEmpty()) {

                    Nodo SwarsNewFighter = getBuffer().getSWARSEffortCola().desencolar();
                    SwarsNewFighter.getPersonaje().setTier(FIRST);
                    getBuffer().getSWARSTier1Cola().queue(SwarsNewFighter);

                }
            }

            updateWindow();
            getBuffer().setSWARSFighter(swarsFighter);
            getBuffer().setSTREKFighter(strekFighter);
            
            getBuffer().setNumCiclos(getBuffer().getNumCiclos() + 1);
            
        }
    }

    public void updateWindow() {
        actualizaColas(getMainWindow().getEffortSwars(), getBuffer().getSWARSEffortCola());
        actualizaColas(getMainWindow().getEffortStrek(), getBuffer().getSTREKEffortCola());
        actualizaColas(getMainWindow().getTier1Swars(), getBuffer().getSWARSTier1Cola());
        actualizaColas(getMainWindow().getTier1StarTrek(), getBuffer().getSTREKTier1Cola());
        actualizaColas(getMainWindow().getTier2Swars(), getBuffer().getSWARSTier2Cola());
        actualizaColas(getMainWindow().getTier2Strek(), getBuffer().getSTREKTier2Cola());
        actualizaColas(getMainWindow().getTier3Swars(), getBuffer().getSWARSTier3Cola());
        actualizaColas(getMainWindow().getTier3Strek(), getBuffer().getSTREKTier3Cola());

    }

    public void actualizaColas(javax.swing.JList<String> list, Cola queue) {
        
        DefaultListModel model = new DefaultListModel();
        list.setModel(model);
        String[] elements = queue.toArray();
        if (elements != null) {
            for (String element : elements) {
                model.addElement(element);
            }
        }

    }

    public void crearPersonaje() {
        int random = (int) Math.round(Math.random() * 19);
        Personaje swarsP;
        Personaje strekP;
        try {
            swarsP = new Personaje(getBuffer().getSWARSPersonajes()[random]);
            strekP = new Personaje(getBuffer().getSTREKPersonajes()[random]);     
            swarsP.setId(getNextID());
            moverACola(swarsP);
            strekP.setId(getNextID() + 1);
            moverACola(strekP);
            setNextID(getNextID() + 2);
        } catch (Exception e) {
            
        }

    }

    public void moverACola(Personaje fighter) {
        switch (fighter.getFranquicia()) {
            case STARWARS:
                switch (fighter.getTier()) {
                    case REINFORCEMENT:
                        getBuffer().getSWARSEffortCola().cola(fighter, fighter.getId(), 0);
                        break;
                    case THIRD:
                        getBuffer().getSWARSTier3Cola().cola(fighter, fighter.getId(), 0);
                        break;
                    case SECOND:
                        getBuffer().getSWARSTier2Cola().cola(fighter, fighter.getId(), 0);
                        break;
                    case FIRST:
                        getBuffer().getSWARSTier1Cola().cola(fighter, fighter.getId(), 0);
                        break;

                }
                break;
            case STARTREK:
                switch (fighter.getTier()) {
                    case REINFORCEMENT:
                        getBuffer().getSTREKEffortCola().cola(fighter, fighter.getId(), 0);                      
                        break;
                    case THIRD:
                        getBuffer().getSTREKTier3Cola().cola(fighter, fighter.getId(), 0);
                        break;
                    case SECOND:
                        getBuffer().getSTREKTier2Cola().cola(fighter, fighter.getId(), 0);
                        break;
                    case FIRST:
                        getBuffer().getSTREKTier1Cola().cola(fighter, fighter.getId(), 0);
                        break;

                }
                break;
        }

    }

   

    /**
     * @return the buffer
     */
    public Buffer getBuffer() {
        return buffer;
    }

    /**
     * @param buffer the buffer to set
     */
    public void setBuffer(Buffer buffer) {
        this.buffer = buffer;
    }

    /**
     * @return the mainWindow
     */
    public MainWindow getMainWindow() {
        return mainWindow;
    }

    /**
     * @param mainWindow the mainWindow to set
     */
    public void setMainWindow(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    /**
     * @return the nextID
     */
    public int getNextID() {
        return nextID;
    }

    /**
     * @param nextID the nextID to set
     */
    public void setNextID(int nextID) {
        this.nextID = nextID;
    }
}
