package enemieKlassen

import Arena
import SLEEP_TIME
import characterKlassen.Hero

/*
The dragon acts as the first enemy (boss) in the game.
It is already active at the beginning of the game.
The dragon and all other enemies in the game have several attacks that are chosen by a "dice" that goes from 1 - 100.
An attack from the dragon is calling a helper. Only 2 opponents (dragon and 1 helper) can be in play at the same time.
Each attack can be stopped by a block of the hero.
If a hero wears a protection stone, the damage of all attacks is reduced by 10 points for one round.
 */
class Dragon(name: String, typ: String, hp: Int):
    Enemie(name, typ, hp) {

    var attacks: MutableMap<String, Int> = mutableMapOf(
        "Firebreath" to 35,
        "Wingbeat" to 30, // hits all
        "Razorclaw" to 40,
        "Wingblock" to 0, // protect one round
        "Scream" to 0, // calls a helper to the side; list of different monsters that are taken randomly. A maximum of one opponent can be called to help.
        "Deadman" to 65
    )

    override fun atkEnemie(hero: Hero, arena: Arena) {
        canBeAttacked = true

        if (hero.hasProtectionStone == true) {
            attacks["Firebreath"] = 25
            attacks["Wingbeat"] = 20
            attacks["Razorclaw"] = 30
            attacks["Deadman"] = 55

        } else {
            attacks["Firebreath"] = 35
            attacks["Wingbeat"] = 30
            attacks["Razorclaw"] = 40
            attacks["Deadman"] = 65
        }

        println("---> ${this.name} gets ready for his attack! <---")
        Thread.sleep(SLEEP_TIME)
        var atkName = attacks.keys

        var dice = (1..100).random()
        when (dice) {
            in 1..35 -> {
                if (hero.canBeAttacked == true) {
                    var attack = atkName.elementAt(0)
                    println("${this.name} attacks with $attack!!")
                    Thread.sleep(SLEEP_TIME)
                    var enemieDamage = attacks[attack]!!
                    var victimHero = hero
                    victimHero.hp -= enemieDamage
                    Thread.sleep(SLEEP_TIME)
                    println("\n ---> ${victimHero.name} gets $enemieDamage HP damage and has only ${victimHero.hp} HP left!!\n")
                } else{
                    var attack = atkName.elementAt(0)
                    println("${this.name} attacks with $attack!!")
                    Thread.sleep(SLEEP_TIME)
                    println("\n ---> ${hero.name} is protected this round!!\n")
                }
            }

            in 36..51 -> {
                if (hero.canBeAttacked == true) {
                    var attack = atkName.elementAt(1)
                    println("${this.name} attacks with $attack!!\n")
                    Thread.sleep(SLEEP_TIME)
                    var enemieDamage = attacks[attack]!!
                    var victimHero1 = arena.charList.elementAt(0)
                    var victimHero2 = arena.charList.elementAt(1)
                    var victimHero3 = arena.charList.elementAt(2)

                    if(victimHero1.canBeAttacked == true){
                        victimHero1.hp -= enemieDamage
                        println("\n ---> ${victimHero1.name} gets $enemieDamage HP damage and has only ${victimHero1.hp} HP left!!")
                    } else {
                        println("\n ---> ${victimHero1.name} is protected this round!!")
                    }

                    if(victimHero2.canBeAttacked == true){
                        victimHero2.hp -= enemieDamage
                        println("\n ---> ${victimHero2.name} gets $enemieDamage HP damage and has only ${victimHero2.hp} HP left!!")
                    } else {
                        println("\n ---> ${victimHero2.name} is protected this round!!")
                    }

                    if(victimHero3.canBeAttacked == true){
                        victimHero3.hp -= enemieDamage
                        println("\n ---> ${victimHero3.name} gets $enemieDamage HP damage and has only ${victimHero3.hp} HP left!!\n")
                    } else {
                        println("\n ---> ${victimHero3.name} is protected this round!!\n")
                    }

                } else{
                    var attack = atkName.elementAt(1)
                    println("${this.name} attacks with $attack!!")
                    Thread.sleep(SLEEP_TIME)
                    println("\n ---> All are protected this round!\n")
                }
            }

            in 52..69 -> {
                if (hero.canBeAttacked == true) {
                    var attack = atkName.elementAt(2)
                    println("${this.name} attacks with $attack!!")
                    Thread.sleep(SLEEP_TIME)
                    var enemieDamage = attacks[attack]!!
                    var victimHero = hero
                    victimHero.hp -= enemieDamage
                    Thread.sleep(SLEEP_TIME)
                    println("\n ---> ${victimHero.name} gets $enemieDamage HP damage and has only ${victimHero.hp} HP left!!\n")
                } else{
                    var attack = atkName.elementAt(2)
                    println("${this.name} attacks with $attack!!")
                    Thread.sleep(SLEEP_TIME)
                    println("\n ---> ${hero.name} is protected this round!!\n")
                }
            }

            in 70..85 -> {
                var attack = atkName.elementAt(3)
                canBeAttacked = false
                println("\n ---> ${this.name} uses $attack and protects himself\n")
            }

            in 86..90 -> {

                if (arena.enemieList.size <= 1) {
                    var helperList = listOf<Enemie>(
                        Zombie("Zombie159", "Undead", 200),
                        Zombie("Zombie3522", "Undead", 200),
                        Zombie("Zombie695", "Undead", 200),
                        Zombie("Zombie5132", "Undead", 200),
                        Zombie("Zombie451", "Undead", 200),
                        Zombie("Zombie9521", "Undead", 200),
                        Zombie("Zombie324", "Undead", 200),
                        Zombie("Zombie55", "Undead", 200),
                        Zombie("Zombie16", "Undead", 200),
                        Zombie("Zombie6231", "Undead", 200),
                        Zombie("Zombie3354", "Undead", 200),
                        Zombie("Zombie65", "Undead", 200),
                        Zombie("Zombie1", "Undead", 200),
                        Zombie("Zombie85", "Undead", 200),
                        DarkMage("Dark Mage Ron", "Magic", 200),
                        DarkMage("Dark Mage Harry", "Magic", 200),
                        DarkMage("Dark Mage Hermione", "Magic", 200),
                        DarkMage("Dark Mage Snape", "Magic", 200)
                    ).random()

                    arena.enemieList.add(helperList)
                    println("\n ---> Smaug has enlisted help at his side!\n")
                } else {
                    println("\n ---> Smaug's scream was not heard!\n")
                }
            }

            in 91..100 -> {
                if (hero.canBeAttacked == true) {
                    var attack = atkName.elementAt(5)
                    println("${this.name} attacks with $attack!!")
                    Thread.sleep(SLEEP_TIME)
                    var enemieDamage = attacks[attack]!!
                    var victimHero = hero

                    victimHero.hp -= enemieDamage
                    Thread.sleep(SLEEP_TIME)
                    println("\n ---> ${victimHero.name} gets $enemieDamage HP damage and has only ${victimHero.hp} HP left!!\n")

                } else{
                    var attack = atkName.elementAt(5)
                    println("${this.name} attacks with $attack!!")
                    Thread.sleep(SLEEP_TIME)
                    println("\n ---> ${hero.name} is protected this round!!\n")
                }
            }
        }
    }
}