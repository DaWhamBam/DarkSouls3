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

        var atkName = attacks.keys
        var attacke = atkWahl()
        var index = atkName.indexOf(attacke)

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
}