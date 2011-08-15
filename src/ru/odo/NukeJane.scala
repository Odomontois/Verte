package ru.odo
import javafx.application.Application
import javafx.stage.Stage
import javafx.scene.Group
import javafx.scene.shape._
import javafx.scene.paint._
import javafx.scene.effect._
import javafx.animation._
import javafx.scene.Scene
import javafx.util.Duration
import java.lang.Math.random
import javafx.beans.value.WritableValue
import javafx.beans.property.DoubleProperty
import scala.collection.JavaConversions._
import NukeJaneAppl._;


object NukeJane {

  def main(args: Array[String]): Unit = Application.launch(classOf[NukeJaneAppl], args)

}

class NukeJaneAppl extends Application {
  override def start(primaryStage: Stage) = {
    primaryStage.setScene(scene)
    root.getChildren.add(blendMode);
    timeline.play
    primaryStage.setVisible(true)
  }
  private lazy val root = new Group
  private lazy val scene = new Scene(root, 800, 600, Color.BLACK)
  private lazy val circles = {
    val circles = new Group
    for (i <- 0 until 30) {
      val circle = new Circle(150, Color.web("white", 0.05))
      circle.setStrokeType(StrokeType.OUTSIDE)
      circle.setStroke(Color.web("white", 0.16))
      circle.setStrokeWidth(4)
      circles.getChildren.add(circle)
    }
    circles.setEffect(new BoxBlur(10, 10, 3))
    circles
  }

  private lazy val colors = {
    val colors = new Rectangle(scene.getWidth, scene.getHeight,
      new LinearGradient(0., 1., 1., 0., true, CycleMethod.NO_CYCLE,
        new Stop(0, Color.web("#f8bd55")),
        new Stop(0.14, Color.web("#c0fe56")),
        new Stop(0.28, Color.web("#5dfbc1")),
        new Stop(0.43, Color.web("#64c2f8")),
        new Stop(0.57, Color.web("#be4af7")),
        new Stop(0.71, Color.web("#ed5fc2")),
        new Stop(0.85, Color.web("#ef504c")),
        new Stop(1, Color.web("#f2660f"))))
    colors
  }
  private lazy val timeline = {
    val timeline = new Timeline
    for (circle <- circles.getChildren) {
      timeline.getKeyFrames.addAll(
        new KeyFrame(Duration.ZERO,
          new KeyValue(circle.translateXProperty, random * 800),
          new KeyValue(circle.translateYProperty, random * 600)),
        new KeyFrame(new Duration(40000),
          new KeyValue(circle.translateXProperty, random * 800),
          new KeyValue(circle.translateYProperty, random * 600)))
    }
    timeline
  }
  private lazy val blendMode = {
    val blendMode = new Group(
      new Group(
        new Rectangle(scene.getWidth, scene.getHeight, Color.BLACK),
        circles),
      colors)
    colors.setBlendMode(BlendMode.OVERLAY)
    blendMode
  }
}

object NukeJaneAppl {
  implicit def writableValueDown [T <: WritableValue[Number]] (property : T): WritableValue[Any] = property.asInstanceOf[WritableValue[Any]]
}


