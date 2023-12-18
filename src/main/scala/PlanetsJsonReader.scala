import io.circe.*
import io.circe.generic.auto.*
import io.circe.parser.*
import io.circe.syntax.*

case class Planet(name: String, satellites: List[String], mass: String)
case class Planets(gasGiants: List[Planet], rockyPlanets: List[Planet])


object PlanetsJsonReader extends App {
  val rawText = scala.io.Source.fromResource("data/planets.json").mkString

  val planetsJson = decode[Planets](rawText)

  val planets = planetsJson.getOrElse(null)

  val rockyPlanets = planets.rockyPlanets

  val gasGiants = planets.gasGiants

  for (planet <- rockyPlanets)
    println(planet.name)
    println(planet.mass)

  for (planet <- gasGiants)
    println(planet.name)
    println(planet.mass)

  println(planets)
//  val gasGiants = planets.gasGiants
//  val rockyPlanets = planets.rockyPlanets

}