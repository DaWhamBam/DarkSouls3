package enemieKlassen

import Arena
import characterKlassen.Hero

open class Enemie(var name: String, var typ: String, var hp: Int) {

    var isBurning: Boolean = false
    var isPoisen: Boolean = false
    var isBleeding: Boolean = false
    var kannAngegriffenWerden = true
    var defense: Int = 6
    var speed: Int = 6

    /*
    Die Grundfunktion vom Angriff startet hier und wird dann in den Unterklassen überschrieben.
     */
    open fun angriffGegner(hero: Hero, arena: Arena){
        println("Noch nicht implementiert. Bitte in Unterklasse überschreiben!")
    }
}