package com.jasonbutwell.appwidgetlistviewexample;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

/**
 * Created by J on 18/03/2017.
 */

public class LoremViewsFactory implements RemoteViewsService.RemoteViewsFactory {

    private static final String[] items = {
            "lorem", "ipsum", "dolor",
            "sit", "amet", "consectetuer",
            "adipiscing", "elit", "morbi",
            "vel", "ligula", "vitae",
            "arcu", "aliquet", "mollis",
            "etiam", "vel", "erat",
            "placerat", "ante",
            "porttitor", "sodales",
            "pellentesque", "augue",
            "purus"
    };

    private Context context = null;
    private int appWidgetId;

    public LoremViewsFactory(Context context, Intent intent) {
        this.context=context;
        appWidgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
    }


    @Override
    public void onCreate() {
    }

    @Override
    public void onDataSetChanged() {
    }

    @Override
    public void onDestroy() {
    }

    @Override
    public int getCount() {
        return(items.length);
    }

    @Override
    public RemoteViews getViewAt(int position) {
        RemoteViews row = new RemoteViews( context.getPackageName(), R.layout.row );

        row.setTextViewText(android.R.id.text1, items[position]);

        Intent intent = new Intent();

        Bundle extras = new Bundle();
        extras.putString(WidgetProvider.EXTRA_WORD, items[position]);

        intent.putExtras(extras);

        row.setOnClickFillInIntent(android.R.id.text1, intent);

        return row;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
}
