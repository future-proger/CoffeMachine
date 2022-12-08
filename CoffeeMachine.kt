var water = 400
var milk = 540
var coffee = 120
var cups = 9
var money = 550

enum class CoffeeMachine(val watter: Int, val milk: Int, val coffee: Int, val cups: Int, val price: Int) {
    ESPRESSO(
        watter = 250,
        milk = 0,
        coffee = 16,
        cups = 1,
        price = 4
    ),
    LATTE(
        watter = 350,
        milk = 75,
        coffee = 20,
        cups = 1,
        price = 7
    ),
    CAPPUCCINO(
        watter = 200,
        milk = 100,
        coffee = 12,
        cups = 1,
        price = 6
    )
}

fun choice() {
    do {
        println("Write action (buy, fill, take, remaining, exit): ")
        val input = readln()
        when(input){
            "buy" -> buy()
            "fill" -> fill()
            "take" -> take()
            "remaining" -> remaining(water, milk, coffee, cups, money)
        }
    }while (input != "exit")
}

fun buy() {
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")

    when(readln()){
        "1" -> {
            check(CoffeeMachine.ESPRESSO)
        }
        "2" -> {
            check(CoffeeMachine.LATTE)
        }
        "3" -> {
            check(CoffeeMachine.CAPPUCCINO)
        }
        "back" -> return
    }
}

fun check(typeOfCoffee: CoffeeMachine) {
    if (typeOfCoffee.watter > water) {
        println("Sorry, not enough water!")
        return
    } else if (typeOfCoffee.milk > milk) {
        println("Sorry, not enough milk!")
        return
    } else if (typeOfCoffee.coffee > coffee) {
        println("Sorry, not enough coffee!")
        return
    } else if (cups == 0) {
        println("Sorry, not enough cups!")
        return
    }
    making(typeOfCoffee)
}

fun making (typeOfCoffee: CoffeeMachine) {
    water -= typeOfCoffee.watter
    milk -= typeOfCoffee.milk
    coffee -= typeOfCoffee.coffee
    cups -= typeOfCoffee.cups
    money += typeOfCoffee.price
}

fun fill() {
    println("Write how many ml of water you want to add:")
    water += readln().toInt()

    println("Write how many ml of milk you want to add:")
    milk += readln().toInt()

    println("Write how many grams of coffee beans you want to add:")
    coffee += readln().toInt()

    println("Write how many disposable cups you want to add:")
    cups += readln().toInt()

    println()
}

fun take() {
    println("I gave you $money")
    println()
    money = 0
}

fun remaining(water: Int, milk: Int, coffee: Int, cups: Int, money: Int) {
    println("The coffee machine has:")
    println("$water ml of water")
    println("$milk ml of milk")
    println("$coffee g of coffee beans")
    println("$cups disposable cups")
    println("$$money of money")
    println()
}

fun main() {
    choice()
}