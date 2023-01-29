open class MacroGoals(var calories: Double, var carbs: Double, var fats: Double, var proteins: Double) {


    override fun toString(): String {


        var macroGoalsPrint : String = "Your Macro-Nutrient goals are \n" +
                "\n" +
                "$calories Calories \n" +
                "$carbs grams of Carbohydrates \n" +
                "$fats grams of Fats \n" +
                "$proteins grams of Protein"


        return macroGoalsPrint

    }


}