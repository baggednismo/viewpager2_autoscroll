package com.devinmartinolich.viewpager2autoscroll.models

class UpdatesSeriesModel(
    title: String,
    subtitle: String,
    description: String,
    image: Int
) {
    companion object {
        private const val TAG = "UpdatesSeriesModel"
    }

    var title: String
    var subtitle: String
    var description: String
    var image: Int

    init {
        this.title = title
        this.subtitle = subtitle
        this.description = description
        this.image = image
    }
}