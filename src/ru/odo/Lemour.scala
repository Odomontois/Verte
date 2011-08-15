package ru.odo
import javafx.application.Application
import javafx.stage.Stage
import javafx.scene.layout.BorderPane
import javafx.scene.shape.Rectangle
import javafx.scene.paint.Color
import javafx.scene.Scene
import javafx.scene.layout.HBox
import javafx.scene.control.Button
import javafx.geometry.Insets
import javafx.geometry.Pos

object Lemour {

  def main(args: Array[String]): Unit = Application.launch(classOf[LemourAppl],args)

}

class LemourAppl extends Application{
  override def start(mainStage : Stage) = {
	mainStage.setScene(scene)
    mainStage.setVisible(true)
  }
  lazy val scene = new Scene(borderPane,200,200,Color.BLACK)
  lazy val borderPane = {
    val borderPane = new BorderPane
    borderPane.setTop(new Rectangle(200,50, Color.DARKCYAN))
    borderPane.setBottom(bottomPanel)
    borderPane.setLeft(new Rectangle(50,100,Color.DARKTURQUOISE))
    borderPane.setRight(new Rectangle(50,100,Color.DARKTURQUOISE))
    borderPane.setCenter(new Rectangle(100,100,Color.MEDIUMAQUAMARINE))
    borderPane
  }
 lazy val bottomPanel ={
   val bottomPanel = new HBox
   bottomPanel.setPadding(new Insets(15,12,15,12))
   bottomPanel.setSpacing(10)
   bottomPanel.setStyle("-fx-background-color: #336699")
   bottomPanel.getChildren.addAll(buttonCurrent, buttonProjected)
   bottomPanel.setAlignment(Pos.CENTER)
   bottomPanel
 }
 lazy val buttonCurrent = new Button("Current")
 lazy val buttonProjected = new Button("Projected")
}