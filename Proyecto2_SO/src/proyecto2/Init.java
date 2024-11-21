/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

import Buffer.Buffer;
import Enumeracion.Franquicia;
import Interface.MainWindow;
import Personaje.Personaje;
import Sistema.Administrador;
import Sistema.Procesador;
/**
 *
 * @author chris
 */
public class Init {
    MainWindow main;
    Buffer buffer;
    
    public Init(MainWindow main, Buffer buffer){
        this.main = main;
        this.buffer = buffer;
    }
    
    public void init(){
        
        crearPersonajes(buffer);
        Administrador admin = new Administrador(buffer, main, 39);
        Procesador proc = new Procesador(buffer, main);
        
        for (int i = 0; i < 19; i++) {
            admin.moverACola(buffer.getSWARSPersonajes()[i]);
            admin.moverACola(buffer.getSTREKPersonajes()[i]);
        }
       
        
        admin.updateWindow();
        proc.start();
       
        admin.start();
        
       
      
        
        
        
    
    }
    
    
    public void crearPersonajes(Buffer buffer){
    
       buffer.getSWARSPersonajes()[0] = new Personaje("Quigon",0, Franquicia.STARWARS, "src\\StarWarsImagenes\\Qui-GonJinn.jpeg");
       buffer.getSWARSPersonajes()[1] = new Personaje("Ahsoka",1, Franquicia.STARWARS, "src\\StarWarsImagenes\\\\AhsokaTano.jpeg");
       buffer.getSWARSPersonajes()[2] = new Personaje("Bobbafet",2, Franquicia.STARWARS, "src\\StarWarsImagenes\\BobbaFet.jpeg");
       buffer.getSWARSPersonajes()[3] = new Personaje("C3p0",3, Franquicia.STARWARS, "src\\StarWarsImagenes\\C-3PO.jpg");
       buffer.getSWARSPersonajes()[4] = new Personaje("Chewbacca",4, Franquicia.STARWARS, "src\\StarWarsImagenes\\Chewbacca.jpg");
       buffer.getSWARSPersonajes()[5] = new Personaje("Darth Vader",5, Franquicia.STARWARS, "src\\StarWarsImagenes\\DarthVader.jpeg");
       buffer.getSWARSPersonajes()[6] = new Personaje("Conde Dooku",6, Franquicia.STARWARS, "src\\StarWarsImagenes\\CondeDooku.jpeg");
       buffer.getSWARSPersonajes()[7] = new Personaje("Grand Moff Tarkin",7, Franquicia.STARWARS, "src\\StarWarsImagenes\\GrandMoffTarkin.jpg"); 
       buffer.getSWARSPersonajes()[8] = new Personaje("K-2SO",8, Franquicia.STARWARS, "src\\StarWarsImagenes\\K-2SO.jpeg"); 
       buffer.getSWARSPersonajes()[9] = new Personaje("Han Solo",9, Franquicia.STARWARS, "src\\StarWarsImagenes\\HanSolo.jpeg");
       buffer.getSWARSPersonajes()[10] = new Personaje("Mace Windu",10, Franquicia.STARWARS, "src\\StarWarsImagenes\\MaceWindu.jpeg"); 
       buffer.getSWARSPersonajes()[11] = new Personaje("Princess Leia",11, Franquicia.STARWARS, "src\\StarWarsImagenes\\PrincessLeia.jpeg"); 
       buffer.getSWARSPersonajes()[12] = new Personaje("Luke Skywalker",12, Franquicia.STARWARS, "src\\StarWarsImagenes\\LukeSkywalker.jpeg");
       buffer.getSWARSPersonajes()[13] = new Personaje("Darth Maul",13, Franquicia.STARWARS, "src\\StarWarsImagenes\\DarthMaul.jpeg");
       buffer.getSWARSPersonajes()[14] = new Personaje("Obi Wan Kenobi",14, Franquicia.STARWARS, "src\\StarWarsImagenes\\Obi-WanKenobi.jpg");
       buffer.getSWARSPersonajes()[15] = new Personaje("Admiral Ackbar",15, Franquicia.STARWARS, "src\\StarWarsImagenes\\AdmiralAckbar.jpg"); 
       buffer.getSWARSPersonajes()[16] = new Personaje("Palpatine",16, Franquicia.STARWARS, "src\\StarWarsImagenes\\TheEmperor.jpg");
       buffer.getSWARSPersonajes()[17] = new Personaje("R2-D2",17, Franquicia.STARWARS, "src\\StarWarsImagenes\\R2-D2.jpg");
       buffer.getSWARSPersonajes()[18] = new Personaje("Anakin",18, Franquicia.STARWARS, "src\\StarWarsImagenes\\Anakin.jpeg"); 
       buffer.getSWARSPersonajes()[19] = new Personaje("Yoda",19, Franquicia.STARWARS, "src\\StarWarsImagenes\\Yoda.jpg");
       
       
       buffer.getSTREKPersonajes()[0] = new Personaje("Bejamin Sisko",20, Franquicia.STARTREK, "src\\StarTrekImagenes\\BenjaminSisko.jpg");
       buffer.getSTREKPersonajes()[1] = new Personaje("Beverly Crusher",21, Franquicia.STARTREK, "src\\StarTrekImagenes\\BeverlyCrusher.jpg");
       buffer.getSTREKPersonajes()[2] = new Personaje("Jadzia Dax",22, Franquicia.STARTREK, "src\\StarTrekImagenes\\JadziaDax.jpg");
       buffer.getSTREKPersonajes()[3] = new Personaje("Deanna Troi",23, Franquicia.STARTREK, "src\\StarTrekImagenes\\DeannaTroi.jpg"); 
       buffer.getSTREKPersonajes()[4] = new Personaje("Hikaru Sulu",24, Franquicia.STARTREK, "src\\StarTrekImagenes\\HikaruSulu.jpg");
       buffer.getSTREKPersonajes()[5] = new Personaje("James Kirk",25, Franquicia.STARTREK, "src\\StarTrekImagenes\\James-Tiberius-Kirk.jpg");
       buffer.getSTREKPersonajes()[6] = new Personaje("Jean-LucPicard",26, Franquicia.STARTREK, "src\\StarTrekImagenes\\jean-luc-picard.jpg");
       buffer.getSTREKPersonajes()[7] = new Personaje("Quark",27, Franquicia.STARTREK, "src\\StarTrekImagenes\\quark.jpg"); 
       buffer.getSTREKPersonajes()[8] = new Personaje("Kathryn Janeway",28, Franquicia.STARTREK, "src\\StarTrekImagenes\\KathrynJaneway.jpg");
       buffer.getSTREKPersonajes()[9] = new Personaje("Kira Nerys",29, Franquicia.STARTREK, "src\\StarTrekImagenes\\KiraNerys.jpg");
       buffer.getSTREKPersonajes()[10] = new Personaje("Bones",30, Franquicia.STARTREK, "src\\StarTrekImagenes\\Bones.jpg");
       buffer.getSTREKPersonajes()[11] = new Personaje("Sheldon Spock",31, Franquicia.STARTREK, "src\\StarTrekImagenes\\sheldonSpock.jpg");
       buffer.getSTREKPersonajes()[12] = new Personaje("Scotty",32, Franquicia.STARTREK, "src\\StarTrekImagenes\\MontgomeryScott.jpg");
       buffer.getSTREKPersonajes()[13] = new Personaje("Seven of Nine",33, Franquicia.STARTREK, "src\\StarTrekImagenes\\SevenOfNine.jpg");
       buffer.getSTREKPersonajes()[14] = new Personaje("Spock",34, Franquicia.STARTREK, "src\\StarTrekImagenes\\Spock.jpg");
       buffer.getSTREKPersonajes()[15] = new Personaje("William Riker",35, Franquicia.STARTREK, "src\\StarTrekImagenes\\WilliamRiker.jpg");
       buffer.getSTREKPersonajes()[16] = new Personaje("Worf",36, Franquicia.STARTREK, "src\\StarTrekImagenes\\Worf.jpg");
       buffer.getSTREKPersonajes()[17] = new Personaje("Odo",37, Franquicia.STARTREK, "src\\StarTrekImagenes\\odo.jpg");
       buffer.getSTREKPersonajes()[18] = new Personaje("Tuvok",38, Franquicia.STARTREK, "src\\StarTrekImagenes\\Tuvok.jpg"); 
       buffer.getSTREKPersonajes()[19] = new Personaje("Data",39, Franquicia.STARTREK, "src\\StarTrekImagenes\\Data.png");
    
    
    }
    
}
