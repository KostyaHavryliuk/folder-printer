package com.khavryliuk.models

sealed trait Command

case class PrintTree(path: String) extends Command