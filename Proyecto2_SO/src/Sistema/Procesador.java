/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import Buffer.Buffer;
import Interface.MainWindow;
import Personaje.Personaje;
import Enumeracion.Franquicia;
import Enumeracion.TierEnum;
import Enumeracion.TipoEnum;
import EDD.Map;
import EDD.HashMap;


/**
 *
 * @author chris
 */
public class Procesador extends Thread {

    private Buffer buffer;
    private MainWindow mainWindow;

    public Procesador(Buffer buffer, MainWindow main) {
        this.buffer = buffer;
        this.mainWindow = main;
    }

    @Override
    public void run() {
        while (true) {
            try {
                try {
                    getBuffer().getS2().release();
                    getBuffer().getS1().acquire();

                } catch (Exception e) {
                }
                getMainWindow().getStateAI().setText("Seleccionando");
                getMainWindow().getFighterSwars().setText("");
                getMainWindow().getFighterStrek().setText(" ");
                getMainWindow().getSwarsTarjeta().setIcon(null);
                getMainWindow().getStrekPersonajeCard().setIcon(null);
                getMainWindow().getSwarsPersonajeImagen().setIcon(null);
                getMainWindow().getStrekPersonajeImagen().setIcon(null);
                getMainWindow().getIDSwarsP().setText("None");
                getMainWindow().getIDStrekP().setText("None");
                sleep((long)getBuffer().getSimLoad());
                System.out.println(getBuffer().getSimLoad());

                Personaje swarsFighter = getBuffer().getSWARSFighter();
                Personaje strekFighter = getBuffer().getSTREKFighter();
                getMainWindow().getIDSwarsP().setText(Integer.toString(getBuffer().getSWARSFighter().getId()));
                getMainWindow().getIDStrekP().setText(Integer.toString(getBuffer().getSTREKFighter().getId()));

                //Después de escoger los luchadores, colocarlos en el mainWindow
                if (swarsFighter != null && strekFighter != null) {
                    System.out.println(swarsFighter.getNombre() + " vs " + strekFighter.getNombre());
                    getMainWindow().getFighterSwars().setText(swarsFighter.getNombre());
                    getMainWindow().getFighterStrek().setText(strekFighter.getNombre());
                    String swarsItem = swarsFighter.getItem();
                    String strekItem = strekFighter.getItem();
                    getMainWindow().getItemSW().setText(swarsItem);
                    getMainWindow().getItemST().setText(strekItem);
                    
                    //ImageIcon card = new ImageIcon(getTipoTarjeta(swarsFighter.getTipo(), swarsFighter.getFranquicia()));
                    //getMainWindow().getSwarsTarjeta().setIcon(card);
                    //card = new ImageIcon(getTipoTarjeta(strekFighter.getTipo(), strekFighter.getFranquicia()));
                    //getMainWindow().getStrekPersonajeCard().setIcon(card);

                    ImageIcon icon = new ImageIcon(swarsFighter.getImgPath());
                    getMainWindow().getSwarsPersonajeImagen().setIcon(icon);
                    icon = new ImageIcon(strekFighter.getImgPath());
                    getMainWindow().getStrekPersonajeImagen().setIcon(icon);

                    getMainWindow().getStateAI().setText("Decidiendo");
                    sleep((long)getBuffer().getSimSpeed());

                    double prob = Math.random();

                    //Decidir quién gana
                    if (prob <= 0.4) {
                        System.out.println("fight");
                        boolean result = elegirGanador(swarsFighter, strekFighter);
                        if (result) {
                            getBuffer().getSWARSWinners().cola(swarsFighter, swarsFighter.getId(), 0);
                            getMainWindow().getStateAI().setText("Star Wars Gana");
                            int swWins = Integer.parseInt(getMainWindow().getWinnersSwars().getText());
                            swWins++;
                            getMainWindow().getWinnersSwars().setText(String.valueOf(swWins));
                            
                            
                        } else {
                            getBuffer().getSTREKWinners().cola(strekFighter, swarsFighter.getId(), 0);
                            getMainWindow().getStateAI().setText("Star Trek Gana");
                            int stWins = Integer.parseInt(getMainWindow().getWinnersStrek().getText());
                            stWins++;
                            getMainWindow().getWinnersStrek().setText(String.valueOf(stWins));
                            
                        }
                        getBuffer().setSWARSFighter(null);
                        getBuffer().setSTREKFighter(null);
                         
                    } else if (prob <= 0.67) {
                        getMainWindow().getStateAI().setText("Empate");
                        
                        swarsFighter.setTier(TierEnum.FIRST);
                        strekFighter.setTier(TierEnum.FIRST);
                       
                       

                    } else {
                        getMainWindow().getStateAI().setText("No es posible");
                        
                        
                        
                        swarsFighter.setTier(TierEnum.REINFORCEMENT);
                        strekFighter.setTier(TierEnum.REINFORCEMENT);
                        

                      

                    }
                     
                    sleep((long)getBuffer().getNextSim());

                }

            } catch (InterruptedException ex) {
                System.out.println(ex);
                Logger.getLogger(Procesador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public boolean elegirGanador(Personaje swars, Personaje strek) {
        if (swars.getTipo().getId() > strek.getTipo().getId()) {
            return true; // Gana Star Wars si su tipo tiene mayor ID
        } else if (swars.getTipo().getId() < strek.getTipo().getId()) {
            return false; // Gana Star Trek si su tipo tiene menor ID
        } else {
            // Mismo tipo: desempate con piedra, papel o tijeras
            Map<String, String> reglas = new HashMap<>();
            // Ítems de Star Wars
            reglas.put("Sable de luz", "Tijera");
            reglas.put("Bláster E-11", "Piedra");
            reglas.put("Destructor Estelar", "Papel");
            // Ítems de Star Trek
            reglas.put("Faser", "Tijera");
            reglas.put("Torpedo de fotones", "Piedra");
            reglas.put("Escudo Deflector", "Papel");

            String itemSW = swars.getItem();
            String itemST = strek.getItem();

            String movimientoSW = reglas.get(itemSW);
            String movimientoST = reglas.get(itemST);

            if (movimientoSW.equals(movimientoST)) {
                // Empate en piedra, papel o tijeras -> Coin Toss
                int wins = 0;
                for (int i = 0; i < 3; i++) {
                    double rand = Math.random();
                    wins = (rand < 0.5) ? wins + 1 : wins - 1;
                }
                if (wins > 0) {
                    return true; // Gana Star Wars
                } else if (wins < 0) {
                    return false; // Gana Star Trek
                } else {
                    // Muerte súbita
                    double rand = Math.random();
                    return rand < 0.5;
                }
            } else if ((movimientoSW.equals("Piedra") && movimientoST.equals("Tijera")) ||
                       (movimientoSW.equals("Papel") && movimientoST.equals("Piedra")) ||
                       (movimientoSW.equals("Tijera") && movimientoST.equals("Papel"))) {
                return true; // Gana Star Wars
            } else {
                return false; // Gana Star Trek
            }
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

}
