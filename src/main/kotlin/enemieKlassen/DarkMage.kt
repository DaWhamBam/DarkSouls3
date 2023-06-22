package enemieKlassen

import characterKlassen.Hero
import Arena
import SLEEP_TIME

class DarkMage(name: String, typ: String, hp: Int) :
    Enemie(name, typ, hp) {

    var attacks: MutableMap<String, Int> = mutableMapOf(
        "Fireball" to 10,
        "Blizzard" to 10, // hits all
        "Thunder" to 10,
        "Protection Shield" to 0, // protect one Round
    )

    override fun atkEnemie(hero: Hero, arena: Arena) {
        canBeAttacked = true

        if (hero.hasProtectionStone == true) {
            attacks["Fireball"] = 5
            attacks["Blizzard"] = 5
            attacks["Thunder"] = 5

        } else {
            attacks["Fireball"] = 10
            attacks["Blizzard"] = 10
            attacks["Thunder"] = 10
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
                    println("\n ---> ${victimHero.name} gets $enemieDamage HP Damage and has only ${victimHero.hp} HP left!!\n")
                } else {
                    var attack = atkName.elementAt(0)
                    println("${this.name} attacks with $attack!!")
                    Thread.sleep(SLEEP_TIME)
                    println("\n ---> ${hero.name} is protected this round!\n")
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
                        println("\n ---> ${victimHero1.name} gets $enemieDamage HP damage and has only ${victimHero1.hp} HP left!!")
                        victimHero1.hp -= enemieDamage
                    } else {
                        println("\n ---> ${victimHero1.name} is protected this round!!")
                    }

                    if (victimHero2.canBeAttacked == true) {
                        println("\n ---> ${victimHero2.name} gets $enemieDamage HP damage and has only ${victimHero2.hp} HP left!!")
                        victimHero2.hp -= enemieDamage
                    } else {
                        println("\n ---> ${victimHero2.name} is protected this round!!")
                    }

                    if (victimHero3.canBeAttacked == true) {
                        println("\n ---> ${victimHero3.name} gets $enemieDamage HP damage and has only${victimHero3.hp} HP!! left\n")
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
                if (hero.canBeAttacked == true) {
                    var attack = atkName.elementAt(2)
                    println("${this.name} attacks with $attack!!")
                    Thread.sleep(SLEEP_TIME)
                    var enemieDamage = attacks[attack]!!
                    var victimHero = hero
                    victimHero.hp -= enemieDamage
                    Thread.sleep(SLEEP_TIME)
                    println("\n ---> ${victimHero.name} gets $enemieDamage HP damage and has only ${victimHero.hp} HP left!!\n")
                } else {
                    var attack = atkName.elementAt(2)
                    println("${this.name} attacks with $attack!!")
                    Thread.sleep(SLEEP_TIME)
                    println("\n ---> ${hero.name} is protected this round!!\n")
                }
            }

            in 76..100 -> {
                var attacke = atkName.elementAt(3)
                canBeAttacked = false
                println("\n ---> ${this.name} uses $attacke and protects himself!\n")
            }
        }
    }
}