package characterKlassen

import Arena
import SLEEP_TIME
import enemieKlassen.Enemie

class Mage(name: String, klasse: String, hp: Int):
    Hero(name, klasse, hp) {

        override var attacks: MutableMap<String, Int> = mutableMapOf(
            "Feuerball" to 50,
            "Inferno" to 30, // trifft alle
            "Schutzschild" to 0 // schützt eine Runde den aktuellen Char
        )

    override fun atkChar(enemie: Enemie, arena: Arena) {
        kannAngegriffenWerden = true
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

        if (index == 2) {
            Thread.sleep(SLEEP_TIME)
            println("${this.name} (${this.klasse}) ist diese Runde geschützt!\n")
            kannAngegriffenWerden = false

        } else if(enemie.kannAngegriffenWerden == false){
            println("${enemie.name} ist geschützt und nimmt kein schaden!")

        } else {
            var charSchaden= attacks[attacke]!!
            enemie.hp -= charSchaden
            println("Du triffst!! ${enemie.name} bekommt $charSchaden Schaden und hat nur noch ${enemie.hp} HP\n")

        }
    }

//    Liste Intventory evtl. muss das ein Map sein
//        var inventory: List<Item>: ListOf()



//     Kampf()


}