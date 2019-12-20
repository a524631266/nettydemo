package com.zhangll.selftype
import scala.collection.immutable
abstract class Food(val name: String) {
  override def toString = name
}

class Recipe(
              val name: String,
              val ingredients: List[Food],
              val instructions: String
            ) {
  override def toString = name +"[" +  ingredients
}

object Apple extends Food("Apple")
object Orange extends Food("Orange")
object Cream extends Food("Cream")
object Sugar extends Food("Sugar")


abstract class Browser {
  val database: Database
  def recipesUsing(food: Food) =
    database.allRecipes.filter(recipe =>
      recipe.ingredients.contains(food))
  def displayCategory(category: database.FoodCategory) = {
    println(category)
  }
}
abstract class Database extends FoodCategories{
  def allFoods: List[Food]
  def allRecipes: List[Recipe]
  def foodNamed(name: String) = allFoods.find(f => f.name == name)

}

trait FoodCategories{
  case class FoodCategory(name: String, foods: List[Food])
  def allCategories: List[FoodCategory]
}

object SimpleDatabase extends Database with SimpleFoods with SimpleRecipes
//  with SimpleFoods with SimpleRecipes

trait SimpleFoods {
  object Pear extends Food("Pear")
  val data = 123
  def allFoods = List(Apple, Pear)
  def allCategories = Nil
}

trait SimpleRecipes { // Does not compile
  self: SimpleFoods => // SimpleRecipes伪装成简单食物
object FruitSalad extends Recipe(
  "fruit salad",
  List(Apple, Pear), // Uh oh
  "Mix it all together."
)
  def allRecipes = List(FruitSalad)
  def sayData(): Unit = {
    println(data)
  }
}
object TestSeflType {
  def main(args: Array[String]): Unit = {
    val rescipes = SimpleDatabase.allRecipes
    rescipes.foreach(println(_))
    println(SimpleDatabase.data)
  }
}
