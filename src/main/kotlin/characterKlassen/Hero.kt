package characterKlassen

import Arena
import enemieKlassen.Enemie



/*
The Hero superclass is defined here. All hero classes (Worrior, Mage, Healer) inherit from here.
There are already more traits imposed than are actually used.
A larger expansion of the mechanics was planned.
Unused properties are commented out.
 */
open class Hero(var name: String, var category: String, var hp: Int) {

//    var isBurning: Boolean = false
//    var isPoisen: Boolean = false
//    var isBleeding: Boolean = false
    var canBeAttacked = true
    var hasProtectionStone = false
//    var strength: Int = 6
//    var magic: Int = 6
//    var healing: Int = 6
//    var defense: Int = 6
//    var speed: Int = 6
//    var level: Int = 1
//    var expPoints= 0
    open var attacks: MutableMap<String, Int> = mutableMapOf()

/*
This is the actual method for a hero to attack. But it is written out in the subclass
because the individual heroes function very differently.
 */
    open fun atkChar(enemie: Enemie, arena: Arena) {
        println("Please overwrite in subclass!")
    }

//    Each hero starts with the same method to make the choice of attacks.
    open fun atkWahl(): String {

        var atkName = attacks.keys
        while (true) {
            try {
                println("---> Choose your attack! <---")
                println(
                    """
                1: ${(atkName.elementAt(0))}
                2: ${(atkName.elementAt(1))}
                3: ${(atkName.elementAt(2))}
            """.trimIndent()
                )
                var inputAtk = readln()
                var indexAtk = inputAtk.toInt() - 1
                var attack = atkName.elementAt(indexAtk)
                return attack
            } catch (ex: Exception) {
                println("Wrong input. Please try again.")
            }
        }
    }
}