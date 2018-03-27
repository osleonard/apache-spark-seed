package codemobile.example

import org.apache.spark.sql.SparkSession

trait SparkTestWrapper {

  lazy val spark : SparkSession = {
    SparkSession.builder().master("local").appName("local[1]").getOrCreate()
  }

}
