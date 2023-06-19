package characterKlassen

import Arena
import enemieKlassen.Enemie

open class Hero(var name: String, var klasse: String, var hp: Int) {

    var isBurning: Boolean = false
    var isPoisen: Boolean = false
    var isBleeding: Boolean = false
    var kannAngegriffenWerden = true
    var strength: Int = 6
    var magic: Int = 6
    var healing: Int = 6
    var defense: Int = 6
    var speed: Int = 6
    var level: Int = 1
    var expPoints= 0
    open var attacks: MutableMap<String, Int> = mutableMapOf()


    open fun atkChar(enemie: Enemie, arena: Arena) {
        println("Noch nicht implementiert. Bitte in Unterklasse überschreiben!")
    }

    open fun atkWahl(): Int{
        println("${this.name} (${this.klasse}) ist an der Reihe. Aktuell hast du ${this.hp} HP.")
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
        return attacke.toInt()
    }


}