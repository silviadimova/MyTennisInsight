package com.sniper.tennis.insight.dataModels

data class GeneralAnalysisDataModel(
        val successfulReturn: Boolean,
        val unsuccessfulReturn: Boolean,
        val firstServe: Boolean,
      var secondServe: Boolean = false,
      var doubleFault: Boolean = false,
      var unforcedError: Boolean = false,
      var forcedError: Boolean = false,
      var opponentError: Boolean = false,
      var volley: Boolean = false,
      var winner: Boolean = false

)
