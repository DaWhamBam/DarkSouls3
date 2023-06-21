import characterKlassen.*
import enemieKlassen.*
import inventory.Item

val SLEEP_TIME: Long = 2000   // Copy from Gordon


fun main() {


//    Charactere

    val arena = Arena()

    var worrior1 = Worrior("Gladius", "Worrier", 300)
    var mage1 = Mage("Lenni", "Mage", 300)
    var healer1 = Healer("Sienna", "Support", 300)

    arena.charList.add(worrior1)
    arena.charList.add(mage1)
    arena.charList.add(healer1)

//    Enemie

    var dragonBoss = Dragon("Smaug", "Fire", 1000)

    arena.enemieList.add(dragonBoss)





/*
This is where the game begins.
The game continues until either all enemies or all heroes on the field are defeated (respective list is empty).
Enemies are in the class Arena in the list enemieList
Heroes are in the class Arena in the list charList
You start with 3 heroes and a boss (dragon) who can get a maximum of one helper at his side.
 */

    println("""
        
        
        
    ----------HERO RPG FIGHT v.1.0!!!---------
    
    An epic adventure awaits you.
    
    You are traveling with a hero group consisting of warrior, mage and healer. You are confronted by a 
    a huge dragon. You have to defeat him and protect the world from his flames!
    
    Good luck!
    
    """.trimIndent())

    Thread.sleep(SLEEP_TIME)

    println("""
        
        The dragon Smaug towers in front of you and the battle begins!
        
        
    """.trimIndent())

    Thread.sleep(SLEEP_TIME)

    do {

        playersRound(arena)

        enemieRound(arena)

        heroDied(arena)

    } while (arena.charList.isNotEmpty() && arena.enemieList.isNotEmpty())

    if (arena.enemieList.isEmpty()) {
        println("You have conquered the world is saved and can flourish again! Good job, mate!")
    } else {
        println("Evil has triumphed and the world will end! Too bad...")
    }
}


/*
Here begins the actual battle and the round of the heroes.
At the beginning it should be decided whether the inventory should be called or an attack should
should take place.
Before the attack is chosen, a target (opponent) is selected.
 */
fun playersRound(arena: Arena) {

// Choice Fight / Inventory
    for (hero in arena.charList) {

        hero.hasProtectionStone = false  // At the beginning of each round and hero, this variable is reset.

        if (arena.enemieList.size == 0) break

        var inventoryItems = arena.inventoryList.keys
        var indexStartChoice: Int
        while (true) {
            try {
                println("\n${hero.name} (${hero.category}) is on the turn. Currently you have ${hero.hp} HP.")
                println("-----------------------")
                println("What do you want to do?")
                println(
                    """
            ${arena.menueList.elementAt(0)}
            ${arena.menueList.elementAt(1)}
        """.trimIndent()
                )
                var inputMenue = readln()
                indexStartChoice = inputMenue.toInt() - 1
                if (indexStartChoice in 0..1) {
                    break
                } else {
                    println("Wrong input. Please try again.")
                }
            } catch (ex: Exception) {
                println("Wrong input. Please try again.")
            }
        }


//  Item choice
        if (indexStartChoice == 1) {
            var indexItem: Int
            var nameItem: Item
            while (true) {
                try {
                    println("---> Which item do you want to use? <---")
                    println(
                        """
            1: ${(inventoryItems.elementAt(0).name)}
            2: ${(inventoryItems.elementAt(1).name)}
            3: ${(inventoryItems.elementAt(2).name)}
        """.trimIndent()
                    )

                    var inputItem = readln()
                    indexItem = inputItem.toInt() - 1
                    nameItem = inventoryItems.elementAt(indexItem)
                    break
                } catch (ex: Exception) {
                    println("Wrong input. Please try again.")
                }
            }

//            Healing potion is used, It can be chosen who gets the healing potion
            if(indexItem == 0) {
                var charHealing = arena.inventoryList[nameItem]!!
                var indexCharCured: Int
                var curedHero: Hero
                while (true){
                    try {
                        println("\n ---> Healing potion selected. Who do you want to heal?")
                        println(
                            """
                1: ${arena.charList.elementAt(0).name}
                2: ${arena.charList.elementAt(1).name}
                3: ${arena.charList.elementAt(2).name}
            """.trimIndent()
                        )

                        var inputCharCured = readln()
                        indexCharCured = inputCharCured.toInt() - 1
                        curedHero = arena.charList.elementAt(indexCharCured)
                        curedHero.hp += charHealing

                        println("\n ---> ${hero.name} (${hero.category}) heals ${curedHero.name} and now he has ${curedHero.hp} HP.\n")
                        break
                    } catch (ex: Exception) {
                        println("Wrong input. Please try again.")
                    }
            }


//                Protective stone is used; all attacks from enemies are reduced by 10 damage for one round
            } else if (indexItem == 1) {

                while(true) {
                    try {
                        println("\n ---> Protective stone chosen. Who do you want to protect?")
                        println(
                            """
                1: ${arena.charList.elementAt(0).name}
                2: ${arena.charList.elementAt(1).name}
                3: ${arena.charList.elementAt(2).name}
            """.trimIndent()
                        )

                        var inputCharProtectiveStone = readln()
                        var indexCharProtect = inputCharProtectiveStone.toInt() - 1
                        var protected = arena.charList.elementAt(indexCharProtect)
                        protected.hasProtectionStone = true // Here the variable is changed so that the protection stone works.
                        println("\n ---> ${protected.name} is now protected by a Protective stone.\n")
                        break
                    } catch (ex: Exception) {
                        println("Wrong input. Please try again.")
                    }
                }

// Throwing knife is used; you can choose again which enemy to hit
            } else if (indexItem == 2 ){
                if (arena.enemieList.size > 1) {

                    while(true) {
                        try {
                            println("\n ---> Throwing knife selected. Who do you want to attack?")
                            println(
                                """
            1: ${(arena.enemieList.elementAt(0).name)}
            2: ${(arena.enemieList.elementAt(1).name)}
        """.trimIndent()
                            )
                            var inputThrowingKnife = readln()
                            var indexEnemieChoiceKnife = inputThrowingKnife.toInt() - 1
                            var enemieChoiceKnife = arena.enemieList.elementAt(indexEnemieChoiceKnife)

                    if (enemieChoiceKnife.canBeAttacked == true) {
                        enemieChoiceKnife.hp -= 10
                        println("\n ---> ${enemieChoiceKnife.name} gets 10 damage and has only ${enemieChoiceKnife.hp} HP.\n")
                    } else {
                        println("\n ---> ${enemieChoiceKnife.name} is protected and does not take damage!\n")
                    }

                    if (enemieChoiceKnife.hp <= 0) {
                        arena.enemieList.remove(enemieChoiceKnife)
                        println("\n ---> ${enemieChoiceKnife.name} was defeated!\n")
                    }
                        } catch (ex: Exception) {
                            println("Wrong input. Please try again.")
                        }
                    }

                } else {

                    if (arena.enemieList.elementAt(0).canBeAttacked == true){
                    arena.enemieList.elementAt(0).hp -= 10
                    println("\n ---> ${arena.enemieList.elementAt(0).name} has received 10 damage and now has only ${arena.enemieList.elementAt(0).hp} HP.\n")
                    } else {
                        println("\n ---> ${arena.enemieList.elementAt(0).name} is protected and does not take damage!\n")
                    }

                    if (arena.enemieList[0].hp == 0) {
                        arena.enemieList.remove(arena.enemieList[0])
                        println("\n ---> Enemy was defeated!\n")
                        break
                    }
                }
            }


/*
If the inventory is not called but an attack is to take place immediately, it starts here
If there are at least 2 enemies on the field, you will be asked which enemy should be attacked.
If an opponent is defeated, he is removed from the enemie list.
 */
        } else {
            if (arena.enemieList.size > 1) {
                while (true) {
                    try {
                        println("---> Who do you want to attack? <---")
                        println(
                            """
            1: ${(arena.enemieList.elementAt(0).name)}
            2: ${(arena.enemieList.elementAt(1).name)}
          
        """.trimIndent()
                        )
                        var inputAttack = readln()
                        var indexAttack = inputAttack.toInt() - 1
                        var enemieChoiceAttack = arena.enemieList.elementAt(indexAttack)
                        hero.atkChar(enemieChoiceAttack, arena)

                        if (enemieChoiceAttack.hp <= 0) {
                            arena.enemieList.remove(enemieChoiceAttack)
                            println("\n ---> ${enemieChoiceAttack.name} was defeated!\n")
                        }
                    } catch (ex: Exception) {
                        println("Wrong input. Please try again.")
                    }
                }

            } else {
                hero.atkChar(arena.enemieList[0], arena)
                if (arena.enemieList[0].hp == 0) {
                    arena.enemieList.remove(arena.enemieList[0])
                    println("\n ---> Enemy was defeated!\n")
                    break
                }
            }
        }
    }
}


    /*
    In the function, the for loop takes the individual objects in the list to perform an attack.
The dragon will always be the first opponent and has within the attack function the possibility to let other
to appear.
To make this all work a copy of the enemieList is created.
 */

    fun enemieRound(arena: Arena) {
        for (enemie in arena.enemieList.toList()) {
            if (enemie is Dragon) {
                if (enemie.hp > 0) {

                    var heroBoss = arena.charList.random()
                    enemie.atkEnemie(heroBoss, arena)
                } else {
                    arena.enemieList.remove(enemie)
                }
                continue
            }
            if (enemie.hp > 0) {

                var heroEnemie = arena.charList.random()
                enemie.atkEnemie(heroEnemie, arena)
            } else {
                arena.enemieList.remove(enemie)
            }
        }
    }

    /*
Here you can check if a hero is still alive.
 If the respective hero has no more HP, he is removed from the list and can no longer attack.
 */
    fun heroDied(arena: Arena) {
        for (heroAlive in arena.charList) {
            if (heroAlive.hp <= 0)
                arena.charList.remove((heroAlive))
        }
    }


