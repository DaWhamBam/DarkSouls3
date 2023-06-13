package enemieKlassen

class DarkMage(name: String, typ: String, hp: Int, isBurning: Boolean, isPoisen: Boolean, isBleeding: Boolean, var magic: Int = 6):
    Enemie(name, typ, hp, isBurning, isPoisen, isBleeding)  {

    var attacks: MutableMap<String, Int> = mutableMapOf(
        "Feuerball" to 10,
        "Eispfeil" to 10, // Schaden über 2-5 Runden
        "Elektroblitz" to 10,
        "Schutzschild" to 0, // Schütz eine Runde den Enemie
    )


}