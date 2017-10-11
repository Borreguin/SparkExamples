import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}


object FirstApp extends App{

  /* Setting the level of logging */
  Logger.getLogger("org").setLevel(Level.OFF)
  Logger.getLogger("akka").setLevel(Level.OFF)

  println(">> Let's start... ")

  val conf = new SparkConf().setMaster("local[*]").setAppName("FirstApp")
  val sc = new SparkContext(conf)
  val fileToOpen = "/usr/local/spark/SparkExamples/input.txt"
  val input = sc.textFile(fileToOpen)

  /* Transform the inputRDD into countRDD */
  val count = input.flatMap(line ⇒ line.split(" ")).map(word ⇒ (word, 1)).reduceByKey(_ + _)

  /* count the number of lines */
  println(input.count())
  input.collect().foreach(println)

  /* saveAsTextFile method is an action that effects on the RDD */
  count.saveAsTextFile("outfile")
  System.out.println("\n>> OK... all is done")

}
