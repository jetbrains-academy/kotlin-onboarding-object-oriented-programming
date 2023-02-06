package jetbrains.kotlin.course.codenames.utils

import codenames.JsCodeNamesCard
import jetbrains.kotlin.course.codenames.card.Card
import jetbrains.kotlin.course.codenames.card.WordCardData
import jetbrains.kotlin.course.codenames.keyCard.KeyCard
import jetbrains.kotlin.course.codenames.keyCard.KeyCardCell
import jetbrains.kotlin.course.codenames.keyCard.KeyCardType

fun KeyCard.toJsKeyCard() = this.cells.map { it.toJsKeyCardType() }

private fun KeyCardCell.toJsKeyCardType() = when (this.type) {
    KeyCardType.Pink -> 0
    KeyCardType.Violet -> 1
    KeyCardType.Gray -> 2
    KeyCardType.Black -> 3
}

object ConvertersUtils {
    val cardsFactory = IdentifierFactory()
}

fun List<Card>.toJsCards() =
    this.map { JsCodeNamesCard(ConvertersUtils.cardsFactory.uniqueIdentifier(), (it.data as WordCardData).word) }
