import java.util.*

import kotlin.collections.ArrayList

val allFoodMacros: MutableList<Food> = ArrayList()

var macroInput = Scanner(System.`in`)

var macroGoalInput = Scanner(System.`in`)

var removalInput = Scanner(System.`in`)

var runInput: Int = 1

var endInput = Scanner(System.`in`)

var macroGoals = MacroGoals(0.0,0.0,0.0,0.0)

fun main() {



    println("Welcome to the Macro Calculator! This calculator will help you track your macro-nutrients on a daily basis.")

    macroGoals = setMacroGoals()

    println()

    println("Now we will enter a food item into the Food Log.")

    println()


    while (runInput != 0) {


        when (runInput) {

            1 -> userInputFood()

            2 -> removeFood()

            3 -> calculateTotalMacros()

            else -> runInput = endInput.nextInt()
        }


    }
}


fun userInputFood() {


    println("Enter a piece of food or meal that you made starting with it's name: ")

    var enteredFoodName: String = macroInput.nextLine()

    println("Enter the amount of servings consumed: ")

    var enteredServings: Double = macroInput.nextDouble()

    println("Enter the amount of calories per serving: ")

    var enteredCalories: Double = macroInput.nextDouble()

    println("Enter the amount of carbohydrates per serving: ")

    var enteredCarbs: Double = macroInput.nextDouble()

    println("Enter the amount of fats per serving: ")

    var enteredFats: Double = macroInput.nextDouble()

    println("Enter the amount of proteins per serving: ")

    var enteredProteins: Double = macroInput.nextDouble()

    var newFood = Food(enteredFoodName, enteredServings, enteredCalories, enteredCarbs, enteredFats, enteredProteins)

    allFoodMacros.add(newFood)



    println()

    printFoodLog()

    println()

    nextDecision()

}

fun removeFood() {


    println("Which food item do you wish to remove from your food log? Enter the corresponding number of the food item for removal")

    printFoodLog()



    var removeFoodAt: Int = removalInput.nextInt()

    allFoodMacros.removeAt(removeFoodAt)

    println("The Food log now contains: ")


    printFoodLog()



    println()

    nextDecision()



}

fun calculateTotalMacros(){

    var totalCaloriesConsumed: Double = 0.0

    var totalCarbohydratesConsumed: Double = 0.0

    var totalFatsConsumed: Double = 0.0

    var totalProteinsConsumed: Double = 0.0

    for(food in allFoodMacros){

        totalCaloriesConsumed += food.calories

        totalCarbohydratesConsumed += food.carbs

        totalFatsConsumed += food.fat

        totalProteinsConsumed += food.protein

    }

    printFoodLog()

    println("_________________________________________________________________")

    println()

    println("The total of your macros for today is currently: ")

    println()

    println(totalCaloriesConsumed.toString() + " calories consumed.")

    println()

    println(totalCarbohydratesConsumed.toString() + " carbs consumed.")

    println()

    println(totalFatsConsumed.toString() + " fats consumed.")

    println()

    println(totalProteinsConsumed.toString() + " proteins consumed.")

    println()

    println("__________________________________________________________________")

    println()

    println(macroGoals.toString() )

    println()

    println("The remaining balance of Macro Nutrients you have available for consumption today is: \n" +
            " ${macroGoals.calories - totalCaloriesConsumed}  calories \n" +
            " ${macroGoals.carbs - totalCarbohydratesConsumed} grams of carbs \n" +
            " ${macroGoals.fats - totalFatsConsumed} grams of fats \n" +
            " ${macroGoals.proteins - totalProteinsConsumed} grams of proteins")



    nextDecision()


}

fun nextDecision(){


    println("Do you wish to add food information? Enter 0 to stop.")

    println()

    println("Enter 1 to add a Food item.")

    println()

    println("If you wish to remove another item, enter 2.")

    println()

    println("If you wish to calculate your total macros consumed so far today, enter 3.")

    println()

    runInput = endInput.nextInt()

    macroInput = Scanner(System.`in`)

}

fun printFoodLog(){
    var counter: Int = 0

    println("Today's Food Log:")

    println("_________________________________________________________________")

    println()

    for (food in allFoodMacros) {


        println(counter.toString() + " --- " + food)

        counter++


    }

}

fun setMacroGoals() : MacroGoals{

    println()

    println("We will now set up you Macro-Nutrient Target Goals.")

    println()

    println("Please enter your numeric (in decimal form, example 0.0) target goal for total calories.")

    var macroGoalsCal : Double = macroGoalInput.nextDouble()

    println()

    println("Please enter your numeric (in decimal form, example 0.0) target goal for total carbohydrates in grams.")

    var macroGoalsCarbs : Double = macroGoalInput.nextDouble()

    println()

    println("Please enter your numeric (in decimal form, example 0.0) target goal for total fats in grams.")

    var macroGoalsFats : Double = macroGoalInput.nextDouble()

    println()

    println("Please enter your numeric (in decimal form, example 0.0) target goal for total proteins in grams.")

    var macroGoalsProteins : Double = macroGoalInput.nextDouble()

    var newMacroGoals = MacroGoals(macroGoalsCal,macroGoalsCarbs,macroGoalsFats,macroGoalsProteins)

    return newMacroGoals


}