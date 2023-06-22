package enemieKlassen

import characterKlassen.Hero
import Arena
import SLEEP_TIME

class Zombie(name: String, typ: String, hp: Int) :
    Enemie(name, typ, hp) {

    var attacks: MutableMap<String, Int> = mutableMapOf(
        "Scratch" to 10,
        "Poisen" to 5, // hits all
        "Block" to 0,
        "Collapse" to 0, // Enemie sits out for a round
    )

    override fun atkEnemie(hero: Hero, arena: Arena) {
        canBeAttacked = true

        if (hero.hasProtectionStone == true) {
            attacks["Scratch"] = 5
            attacks["Poisen"] = 1

        } else {
            attacks["Scratch"] = 10
            attacks["Poisen"] = 5
        }

        println("---> ${this.name} gets ready for his attack! <---")
        Thread.sleep(SLEEP_TIME)
        var atkName = attacks.keys

        var dice = (1..100).random()
        when (dice) {
            in 1..40 -> {
                if (hero.canBeAttacked == true) {
                    var attack = atkName.elementAt(0)
                    println("${this.name} attacks with $attack!!")
                    Thread.sleep(SLEEP_TIME)
                    var enemieDamage = attacks[attack]!!
                    var victimHero = hero
                    victimHero.hp -= enemieDamage
                    Thread.sleep(SLEEP_TIME)
                    println("\n ---> ${victimHero.name} gets $enemieDamage and has only ${victimHero.hp} HP gets!!\n")
                } else {
                    var attack = atkName.elementAt(0)
                    println("${this.name} attacks with $attack!!")
                    Thread.sleep(SLEEP_TIME)
                    println("\n ---> ${hero.name} is protected this round!!\n")
                }
            }

            in 41..60 -> {
                if (hero.canBeAttacked == true) {
                    var attack = atkName.elementAt(1)
                    println("${this.name} attacks with $attack!!\n")
                    Thread.sleep(SLEEP_TIME)
                    var enemieDamage = attacks[attack]!!
                    var victimHero1 = arena.charList.elementAt(0)
                    var victimHero2 = arena.charList.elementAt(1)
                    var victimHero3 = arena.charList.elementAt(2)

                    if (victimHero1.canBeAttacked == true) {
                        println("\n ---> ${victimHero1.name} gets $enemieDamage HP damage and has only ${victimHero1.hp} HP gets!!")
                        victimHero1.hp -= enemieDamage
                    } else {
                        println("\n ---> ${victimHero1.name} is protected this round!!")
                    }

                    if (victimHero2.canBeAttacked == true) {
                        println("\n ---> ${victimHero2.name} gets $enemieDamage HP damage and has only ${victimHero2.hp} HP gets!!")
                        victimHero2.hp -= enemieDamage
                    } else {
                        println("\n ---> ${victimHero2.name} is protected this round!!")
                    }

                    if (victimHero3.canBeAttacked == true) {
                        println("\n ---> ${victimHero3.name} gets $enemieDamage HP damage and has only ${victimHero3.hp} HP gets!!\n")
                        victimHero3.hp -= enemieDamage
                    } else {
                        println("\n ---> ${victimHero3.name} is protected this round!!\n")
                    }

                } else {
                    var attack = atkName.elementAt(1)
                    println("${this.name} attacks with $attack!!")
                    Thread.sleep(SLEEP_TIME)
                    println("\n ---> All are protected this round!\n")
                }
            }

            in 61..75 -> {
                var attacke = atkName.elementAt(2)
                canBeAttacked = false
                println("\n ---> ${this.name} uses $attacke and protects himself!\n")
            }

            in 76..100 -> {
                var attacke = atkName.elementAt(3)
                println("\n ---> ${this.name} uses $attacke and can not defend himself!\n")
            }
        }
    }
}
