package characterKlassen

import Arena
import SLEEP_TIME
import enemieKlassen.Enemie

class Mage(name: String, category: String, hp: Int):
    Hero(name, category, hp) {

//        The attacks of the Mage
        override var attacks: MutableMap<String, Int> = mutableMapOf(
            "Fireball" to 50,
            "Inferno" to 30, // hits all
            "Protectionshield" to 0 // protect one round
        )

    override fun atkChar(enemie: Enemie, arena: Arena) {
        canBeAttacked = true

        var atkName = attacks.keys
        var attack = atkWahl()
        var index = atkName.indexOf(attack)

        if (index == 2) {
            Thread.sleep(SLEEP_TIME)
            println("\n ---> ${this.name} (${this.category}) is protected this round!!\n")
            canBeAttacked = false

        } else if(enemie.canBeAttacked == false){
            println("\n ---> ${enemie.name} is protected and takes no damage!")

        } else {
            var charDamage= attacks[attack]!!
            enemie.hp -= charDamage
            println("\n ---> You hit!! ${enemie.name} gets $charDamage HP damage and has only ${enemie.hp} HP left.\n")
        }
    }
}