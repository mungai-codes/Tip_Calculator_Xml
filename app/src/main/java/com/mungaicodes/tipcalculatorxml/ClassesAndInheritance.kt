package com.mungaicodes.tipcalculatorxml

import kotlin.math.PI

fun main() {
    val squareCabin = SquareCabin(6, 50.0)
    with(squareCabin) {
        println("\nSquare Cabin\n=======================")
        println("Capacity: $capacity")
        println("Building Material: $buildingMaterial")
        println("Has room?: ${hasRoom()}")
        println("Floor Area: ${floorArea()}")
    }

    val roundHut = RoundHut(3,10.0)
    with(roundHut) {
        println("\nRund Hut\n===========================")
        println("Capacity: $capacity")
        println("Building Material: $buildingMaterial")
        println("Has room?: ${hasRoom()}")
        getRoom()
        println("Has room?: ${hasRoom()}")
        getRoom()
        println("Floor Area: ${floorArea()}")
    }

    val roundTower = RoundTower(4, 15.5)
    with(roundTower) {
        println("\nRound Tower\n========================")
        println("Capacity: $capacity")
        println("Building Material: $buildingMaterial")
        println("Has room?: ${hasRoom()}")
        println("Floor Area: ${floorArea()}")
    }

}

abstract class Dwelling(private var residents: Int) {

    abstract val buildingMaterial: String
    abstract val capacity: Int

    fun hasRoom(): Boolean {
        return residents < capacity
    }

    abstract fun floorArea(): Double

    fun getRoom() {
        if (capacity > residents) {
            residents++
            println("You get a room!, everyone gets a room!!!")
        } else {
            println("No rooms available!")
        }
    }

}

class SquareCabin(residents: Int, val length: Double) : Dwelling(residents = residents) {

    override val buildingMaterial: String = "wood"
    override val capacity: Int = 6
    override fun floorArea(): Double {
        return length * length
    }

}

open class RoundHut(residents: Int, val radius: Double) : Dwelling(residents = residents) {

    override val buildingMaterial: String = "straw"
    override val capacity: Int = 4
    override fun floorArea(): Double {
        return PI * radius * radius
    }
}

class RoundTower(residents: Int, radius: Double, val floors: Int = 2) : RoundHut(residents, radius) {

    override val buildingMaterial: String = "stone"
    override val capacity: Int = 4 * floors
    override fun floorArea(): Double {
        return super.floorArea() * floors
    }

}