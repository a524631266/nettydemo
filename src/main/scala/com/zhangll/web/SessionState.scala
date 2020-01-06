package com.zhangll.web
sealed abstract class SessionState(val state: String = "not", val isActive: Boolean = true){
  override def toString: String = state
}

object SessionState {
  def apply(s: String): SessionState = s match {
    case "not_start" => NotStarted
    case _ => throw new IllegalArgumentException(s"illea state: $s")
  }
  object NotStarted extends SessionState("not_started", true)
}
