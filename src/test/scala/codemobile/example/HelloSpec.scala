package codemobile.example

import org.apache.spark.sql.Row
import org.apache.spark.sql.types._
import org.scalatest._

class HelloSpec extends FlatSpec with Matchers with SparkTestWrapper {
  import spark.implicits._
  "The Hello object" should "verifiy that expected dataframe is same as actual " in {
    val sourceDataFrame =  Seq(
      "Nigeria",
      "Canada"
    ).toDF("country")

    val expectedSchema = List(
      StructField("country", StringType, true),
      StructField("message", StringType, false)
    )
    val actualDataFrame  = sourceDataFrame.transform(Hello.greeter())
    val expectedData = Seq(
      Row("Nigeria", "Hello from"),
      Row("Canada", "Hello from")
    )

    val expectedDataFrame = spark.createDataFrame(spark.sparkContext.parallelize(expectedData), StructType(expectedSchema))

    assert(actualDataFrame.count() === expectedDataFrame.count())
  }
}
