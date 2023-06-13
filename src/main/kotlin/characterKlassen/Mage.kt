package characterKlassen

import SLEEP_TIME

class Mage(name: String, klasse: String, hp: Int, isBurning: Boolean, isPoisen: Boolean, isBleeding: Boolean, var magic: Int = 6):
    Hero(name, klasse, hp, isBurning, isPoisen, isBleeding) {

        var attacks: MutableMap<String, Int> = mutableMapOf(
            "Feuerball" to 50,
            "Inferno" to 30, // trifft alle
            "Schutzschild" to 0 // schützt eine Runde den aktuellen Char
        )

    fun atkChar(): Int {
        var atkName = attacks.keys
//        var itemName = inventory.keys
        println("Wähle deinen Angriff!")
//        Thread.sleep(SLEEP_TIME)
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
        var charSchaden = attacks[attacke]!!
        return charSchaden

    }

//    Liste Intventory evtl. muss das ein Map sein
//        var inventory: List<Item>: ListOf()



//     Kampf()


}