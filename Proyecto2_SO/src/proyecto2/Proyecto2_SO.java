/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto2;

import Buffer.Buffer;
import Interface.MainWindow;


public class Proyecto2_SO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
        Buffer buffer = new Buffer();
       MainWindow main = new MainWindow(buffer);
       main.setVisible(true);
    }
    
    
}
