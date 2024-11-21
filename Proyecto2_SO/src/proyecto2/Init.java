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
    
       buffer.getSWARSPersonajes()[0] = new Personaje("Quigon",0, Franquicia.STARWARS, "src\\StarWarsImagenes\\Quigon.jpg");
       buffer.getSWARSPersonajes()[1] = new Personaje("Ahsoka",1, Franquicia.STARWARS, "src\\StarWarsImagenes\\\\ahsoka.jpg");
       buffer.getSWARSPersonajes()[2] = new Personaje("Bobbafet",2, Franquicia.STARWARS, "src\\StarWarsImagenes\\bobbafet.jpg");
       buffer.getSWARSPersonajes()[3] = new Personaje("C3p0",3, Franquicia.STARWARS, "src\\StarWarsImagenes\\c3po.jpg");
       buffer.getSWARSPersonajes()[4] = new Personaje("Chewbaca",4, Franquicia.STARWARS, "src\\StarWarsImagenes\\chewbaca.jpg");
       buffer.getSWARSPersonajes()[5] = new Personaje("Darth Vader",5, Franquicia.STARWARS, "src\\StarWarsImagenes\\dartvader.jpg");
       buffer.getSWARSPersonajes()[6] = new Personaje("Dooku",6, Franquicia.STARWARS, "src\\StarWarsImagenes\\dooku.jpg");
       buffer.getSWARSPersonajes()[7] = new Personaje("Ewok",7, Franquicia.STARWARS, "src\\StarWarsImagenes\\ewok.jpg");
       buffer.getSWARSPersonajes()[8] = new Personaje("Grievus",8, Franquicia.STARWARS, "src\\StarWarsImagenes\\grievus.jpg");
       buffer.getSWARSPersonajes()[9] = new Personaje("Han Solo",9, Franquicia.STARWARS, "src\\StarWarsImagenes\\hansolo.jpg");
       buffer.getSWARSPersonajes()[10] = new Personaje("Jango Fett",10, Franquicia.STARWARS, "src\\StarWarsImagenes\\jango.jpg");
       buffer.getSWARSPersonajes()[11] = new Personaje("JarJar",11, Franquicia.STARWARS, "src\\StarWarsImagenes\\jarjar.jpg");
       buffer.getSWARSPersonajes()[12] = new Personaje("Luke",12, Franquicia.STARWARS, "src\\StarWarsImagenes\\luke.jpg");
       buffer.getSWARSPersonajes()[13] = new Personaje("Maul",13, Franquicia.STARWARS, "src\\StarWarsImagenes\\maul.jpg");
       buffer.getSWARSPersonajes()[14] = new Personaje("Obi Wan",14, Franquicia.STARWARS, "src\\StarWarsImagenes\\obiwan.jpg");
       buffer.getSWARSPersonajes()[15] = new Personaje("Padme",15, Franquicia.STARWARS, "src\\StarWarsImagenes\\padme.jpg");
       buffer.getSWARSPersonajes()[16] = new Personaje("Palpatine",16, Franquicia.STARWARS, "src\\StarWarsImagenes\\palpatine.jpg");
       buffer.getSWARSPersonajes()[17] = new Personaje("r2d2",17, Franquicia.STARWARS, "src\\StarWarsImagenes\\r2d2.jpg");
       buffer.getSWARSPersonajes()[18] = new Personaje("StormTrooper",18, Franquicia.STARWARS, "src\\StarWarsImagenes\\stormtrooper.jpeg");
       buffer.getSWARSPersonajes()[19] = new Personaje("Yoda",19, Franquicia.STARWARS, "src\\StarWarsImagenes\\yoda.jpg");
       
       
       buffer.getSTREKPersonajes()[0] = new Personaje("BejaminSisko",20, Franquicia.STARTREK, "src\\StarTrekImagenes\\BenjaminSisko.png");
       buffer.getSTREKPersonajes()[1] = new Personaje("Beverly Crusher",21, Franquicia.STARTREK, "src\\StarTrekImagenes\\BeverlyCrusher.png");
       buffer.getSTREKPersonajes()[2] = new Personaje("Charles Trip",22, Franquicia.STARTREK, "src\\StarTrekImagenes\\CharlesTrip.png");
       buffer.getSTREKPersonajes()[3] = new Personaje("Geordi",23, Franquicia.STARTREK, "src\\StarTrekImagenes\\GeordiLaForge.png");
        buffer.getSTREKPersonajes()[4] = new Personaje("Hikaru",24, Franquicia.STARTREK, "src\\StarTrekImagenes\\HikaruSulu.png");
       buffer.getSTREKPersonajes()[5] = new Personaje("James Kirk",25, Franquicia.STARTREK, "src\\StarTrekImagenes\\JamesTKirk.png");
       buffer.getSTREKPersonajes()[6] = new Personaje("Jean-LucPicard",26, Franquicia.STARTREK, "src\\StarTrekImagenes\\Jean-LucPicard.png");
       buffer.getSTREKPersonajes()[7] = new Personaje("Julian Bashir",27, Franquicia.STARTREK, "src\\StarTrekImagenes\\JulianBashir.png");
       buffer.getSTREKPersonajes()[8] = new Personaje("Kathryn Janeway",28, Franquicia.STARTREK, "src\\StarTrekImagenes\\KathrynJaneway.png");
       buffer.getSTREKPersonajes()[9] = new Personaje("Kira Nerys",29, Franquicia.STARTREK, "src\\StarTrekImagenes\\KiraNerys.png");
       buffer.getSTREKPersonajes()[10] = new Personaje("Bones",30, Franquicia.STARTREK, "src\\StarTrekImagenes\\Bones.png");
       buffer.getSTREKPersonajes()[11] = new Personaje("Miles",31, Franquicia.STARTREK, "src\\StarTrekImagenes\\MilesObrien.png");
       buffer.getSTREKPersonajes()[12] = new Personaje("Scotty",32, Franquicia.STARTREK, "src\\StarTrekImagenes\\Scotty.png");
       buffer.getSTREKPersonajes()[13] = new Personaje("Seven of Nine",33, Franquicia.STARTREK, "src\\StarTrekImagenes\\SevenOfNine.png");
       buffer.getSTREKPersonajes()[14] = new Personaje("Spock",34, Franquicia.STARTREK, "src\\StarTrekImagenes\\Spock.png");
       buffer.getSTREKPersonajes()[15] = new Personaje("William Riker",35, Franquicia.STARTREK, "src\\StarTrekImagenes\\WilliamRiker.png");
       buffer.getSTREKPersonajes()[16] = new Personaje("Worf",36, Franquicia.STARTREK, "src\\StarTrekImagenes\\Worf.png");
       buffer.getSTREKPersonajes()[17] = new Personaje("Odo",37, Franquicia.STARTREK, "src\\StarTrekImagenes\\Odo.png");
       buffer.getSTREKPersonajes()[18] = new Personaje("Nyota Uhura",38, Franquicia.STARTREK, "src\\StarTrekImagenes\\NyotaUhura.png");
       buffer.getSTREKPersonajes()[19] = new Personaje("Data",39, Franquicia.STARTREK, "src\\StarTrekImagenes\\Data.png");
    
    
    }
    
}
