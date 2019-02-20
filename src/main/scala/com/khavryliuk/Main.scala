package com.khavryliuk

import akka.actor.{ActorSystem, Props}
import com.khavryliuk.actors.FilesActor
import com.khavryliuk.models.PrintTree

object Main extends App {
  implicit val system = ActorSystem("my-system")
  implicit val executionContext = system.dispatcher

  val actor = system.actorOf(Props[FilesActor], "filesActor")

//example of normal request (for Windows)
  actor ! PrintTree("d://курсач")

//example of bad request
//  actor ! "d://java"

}
