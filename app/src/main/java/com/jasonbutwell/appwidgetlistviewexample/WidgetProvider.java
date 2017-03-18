package com.jasonbutwell.appwidgetlistviewexample;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;

import static com.jasonbutwell.appwidgetlistviewexample.R.layout.widget;

/**
 * Created by J on 18/03/2017.
 */

public class WidgetProvider extends AppWidgetProvider {

    public static String EXTRA_WORD = "_THE_WORD";

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {

        for (int appWidgetId : appWidgetIds) {

            RemoteViews widgetViews = new RemoteViews(context.getPackageName(), widget);

            Intent svcIntent = new Intent(context, WidgetService.class);
            svcIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
            svcIntent.setData(Uri.parse(svcIntent.toUri(Intent.URI_INTENT_SCHEME)));

            widgetViews.setRemoteAdapter(R.id.words, svcIntent);

            Intent clickIntent = new Intent(context, DetailActivity.class);
            PendingIntent clickPI = PendingIntent.getActivity(context, 0, clickIntent, PendingIntent.FLAG_UPDATE_CURRENT);

            widgetViews.setPendingIntentTemplate(R.id.words, clickPI);

            appWidgetManager.updateAppWidget(appWidgetId, widgetViews);
        }

        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }
}
