package characterKlassen
import SLEEP_TIME

class Worrior(name: String, klasse: String, hp: Int, var strength: Int = 6):
    Hero(name, klasse, hp) {

    var attacks: MutableMap<String, Int> = mutableMapOf(
        "Schwerthieb" to 50,
        "Rundumschlag" to 30, // trifft alle
        "Schildblock" to 0 // schützt eine Runde den aktuellen Char
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