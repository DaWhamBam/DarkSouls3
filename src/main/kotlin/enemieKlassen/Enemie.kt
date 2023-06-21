package enemieKlassen

import Arena
import characterKlassen.Hero

/*
The Enemy superclass is defined here. All enemies (Dragon, Dark Mage, Zombie) inherit from here.
There are already more traits imposed than are actually used.
A larger expansion of the mechanics was planned.
Unused properties are commented out.
 */
open class Enemie(var name: String, var typ: String, var hp: Int) {

//    var isBurning: Boolean = false
//    var isPoisen: Boolean = false
//    var isBleeding: Boolean = false
    var canBeAttacked = true
//    var defense: Int = 6
//    var speed: Int = 6

    /*
The basic function of the attack starts here and is then overwritten in the subclasses.
     */
    open fun atkEnemie(hero: Hero, arena: Arena){
        println("Please overwrite in subclass!")
    }
}