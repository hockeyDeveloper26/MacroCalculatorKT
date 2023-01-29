


open class Food(var name: String, var servings: Double, var calories: Double, var carbs: Double, var fat: Double, var protein: Double){






override fun toString(): String {

    var returnMacros: String = name + " " + servings + " servings " + calories + " calories " + carbs + " carbs " +  fat + " fats " + protein + " proteins."

    return returnMacros


}




}