package characterKlassen

import Arena
import SLEEP_TIME
import enemieKlassen.Enemie

class Healer(name: String, category: String, hp: Int) :
    Hero(name, category, hp) {


    //       The attacks of the Healer
    override var attacks: MutableMap<String, Int> = mutableMapOf(
        "Hand punch" to 20,
        "Healing" to 30, // heals one Char
        "Protection Hand" to 0 // protect one round
    )

    override fun atkChar(enemie: Enemie, arena: Arena) {
        canBeAttacked = true

        var atkName = attacks.keys
        var attack = atkWahl()
        var index = atkName.indexOf(attack)

//        Here you choose who you want to heal.
        if (index == 1) {
            var charHealing = attacks[attack]!!
            var char = arena.charList
            println(
                """
                1: ${char.elementAt(0).name}
                2: ${char.elementAt(1).name}
                3: ${char.elementAt(2).name}
            """.trimIndent()
            )
            var inputHealing = readln()
            var indexHealing = inputHealing.toInt() - 1
            var cured = arena.charList.elementAt(indexHealing)
            cured.hp += charHealing
            Thread.sleep(SLEEP_TIME)
            println("\n ---> ${this.name} (${this.category}) heals ${cured.name} and has now ${cured.hp} HP.\n")

        } else if (index == 2) {
            Thread.sleep(SLEEP_TIME)
            println("\n ---> ${this.name} (${this.category}) is protected this round!\n")
            canBeAttacked = false

        } else if (enemie.canBeAttacked == false) {
            println("\n ---> ${enemie.name} is protected and takes no damage!\n")

        } else {
            var charDamage = attacks[attack]!!
            enemie.hp -= charDamage
            println("\n ---> You hit!! ${enemie.name} gets $charDamage HP damage and has only ${enemie.hp} HP left.\n")

        }
    }
}