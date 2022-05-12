package de.htwg.se.mastermind.model

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class FeedbackSpec extends AnyWordSpec {
    "Feedback" when {
        "created with 1 and 3" should {
            val fb = new Feedback(1,3)
            "have correctColors = 1" in {
                fb.correctColors should be(1)
            }
            "have correctPositions = 3" in {
                fb.correctPositions should be(3)
            }
            "have a String representation" in {
                fb.toString should be(Color.White.code + "1 3")
            }
        }
    }
}