package characterKlassen

import Arena
import enemieKlassen.Enemie



/*
Die Oberklasse Hero wird hier definiert. Alle Heldenklassen (Worrior, Mage, Healer) erben von hier.
Es sind bereits mehr Eigenschaften hinerlegt als tatsächlich genutzt werden.
Geplant war ein größerer Ausbau der Mechaniken.
Ungenutzte Eigenschaften sind auskommentiert.
 */
open class Hero(var name: String, var klasse: String, var hp: Int) {

//    var isBurning: Boolean = false
//    var isPoisen: Boolean = false
//    var isBleeding: Boolean = false
    var kannAngegriffenWerden = true
    var hatSchutzStein = false
//    var strength: Int = 6
//    var magic: Int = 6
//    var healing: Int = 6
//    var defense: Int = 6
//    var speed: Int = 6
//    var level: Int = 1
//    var expPoints= 0
    open var attacks: MutableMap<String, Int> = mutableMapOf()

/*    Das ist die eigentlich Methode damit ein Held angreiffen kann. Wird aber in der Unterklasse
ausgeschrieben da die einzelenen Helden sehr unterschiedlich Funktionieren.
 */
    open fun atkChar(enemie: Enemie, arena: Arena) {
        println("Bitte in Unterklasse überschreiben!")
    }

//    Jeder Held beginnt mit der gleichen Methode um die Auswahl der Attacken zu fällen.
    open fun atkWahl(): String{

        var atkName = attacks.keys
        println("Wähle deinen Angriff!")
        println(
            """
            1: ${(atkName.elementAt(0))}
            2: ${(atkName.elementAt(1))}
            3: ${(atkName.elementAt(2))}
        """.trimIndent()
        )
        var eingabe = readln()
        var index = eingabe.toInt() - 1
        var attacke = atkName.elementAt(index)
        return attacke
    }
}