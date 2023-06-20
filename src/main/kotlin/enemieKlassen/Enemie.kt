package enemieKlassen

import Arena
import characterKlassen.Hero

/*
Die Oberklasse Enemie wird hier definiert. Alle Gegner (Dragon, Dark Mage, Zombie) erben von hier.
Es sind bereits mehr Eigenschaften hinerlegt als tatsächlich genutzt werden.
Geplant war ein größerer Ausbau der Mechaniken.
Ungenutzte Eigenschaften sind auskommentiert.
 */
open class Enemie(var name: String, var typ: String, var hp: Int) {

//    var isBurning: Boolean = false
//    var isPoisen: Boolean = false
//    var isBleeding: Boolean = false
    var kannAngegriffenWerden = true
//    var defense: Int = 6
//    var speed: Int = 6

    /*
    Die Grundfunktion vom Angriff startet hier und wird dann in den Unterklassen überschrieben.
     */
    open fun angriffGegner(hero: Hero, arena: Arena){
        println("Bitte in Unterklasse überschreiben!")
    }
}