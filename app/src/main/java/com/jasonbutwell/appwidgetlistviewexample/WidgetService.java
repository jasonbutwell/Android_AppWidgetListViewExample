package com.jasonbutwell.appwidgetlistviewexample;

import android.content.Intent;
import android.widget.RemoteViewsService;

/**
 * Created by J on 18/03/2017.
 */

public class WidgetService extends RemoteViewsService {
    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return( new LoremViewsFactory( this.getApplicationContext(), intent ) );
    }
}
