package com.securitywidget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews
import android.graphics.Color

class SecurityWidget : AppWidgetProvider() {

    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        for (id in appWidgetIds) {
            val views = RemoteViews(context.packageName, R.layout.widget_security)
            val severity = "CRITICAL" // مؤقت، يمكن تحديثه لاحقاً
            val color = getColorBySeverity(severity)
            views.setTextViewText(R.id.icon, "⚠️")
            views.setInt(R.id.icon, "setTextColor", color)
            appWidgetManager.updateAppWidget(id, views)
        }
    }

    private fun getColorBySeverity(level: String): Int {
        return when(level.uppercase()) {
            "CRITICAL" -> Color.RED
            "HIGH" -> Color.parseColor("#FF9800")
            "MEDIUM" -> Color.YELLOW
            else -> Color.GREEN
        }
    }
}
