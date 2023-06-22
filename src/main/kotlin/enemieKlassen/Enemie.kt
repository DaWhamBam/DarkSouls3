package enemieKlassen

import Arena
import characterKlassen.Hero

/*
The Enemy superclass is defined here. All enemies (Dragon, Dark Mage, Zombie) inherit from here.
There are already more traits imposed than are actually used.
A larger expansion of the mechanics was planned.
 */
open class Enemie(var name: String, var typ: String, var hp: Int) {

    var canBeAttacked = true


    /*
The basic function of the attack starts here and is then overwritten in the subclasses.
     */
    open fun atkEnemie(hero: Hero, arena: Arena) {
        println("Please overwrite in subclass!")
    }
}