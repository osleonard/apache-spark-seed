package codemobile.example

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._

object Hello extends App {
  def greeter()(dataFrame: DataFrame) : DataFrame ={
    dataFrame.withColumn("message", lit("Hello from"))
  }
}
