
/* una clase en Kotlin puede tener un unico constructor primario, y varios constructores secundarios*/
/* un constructor primario es parte del header de la clase.
   Sus parametros son listados despues de la primera linea */
class InitOrderDemo(name: String) {
    val firstProperty = "First property: $name"/*.also(::println)*/

    init {
        println("First initializer block that prints ${name}")
    }
}

class Person(val firstName: String, val lastName: String, var age: Int) {
    init {
        println("This goes first?")
    }

    var children: MutableList<Person> = mutableListOf<Person>();

    constructor(firstName: String, lastName: String, age: Int, parent: Person) : this(firstName, lastName, age) {
        parent.children.add(this)

        println("Secondary call")
    }

    init  {
        println("This ??")
    }
}

class Noncreatable private constructor() {

}

class Constructors {
    init {
        println("Init block")
    }

    constructor(i: Int) {
        println("This is a constructor!")
    }
}

data class Invoice (var emitterId: Int, val amount: Int, var number: Int) {

}

fun main() {
    var invoice1 = Invoice(16632834, 150000, 1)
    val invoice2 = Invoice(16632834, 100000, 2)

    println(invoice1)
    println(invoice2)

    invoice2 = Invoice(16632834, 100000, 2)

    // val person1 = Person("Felipe", "Apablaza", 32)
    // val person2 = Person("Felipe", "Apablaza", 32, person1)
    // println(person.toString())

    // val cons = Constructors(10)
}
