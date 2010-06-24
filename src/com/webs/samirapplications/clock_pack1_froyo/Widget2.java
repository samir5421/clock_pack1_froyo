
package com.webs.samirapplications.clock_pack1_froyo;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class Widget2 extends AppWidgetProvider
{    
    public void onReceive(Context context, Intent intent)
    {
        String action = intent.getAction();
        if (AppWidgetManager.ACTION_APPWIDGET_UPDATE.equals(action))
        {
       	
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget2);
            
            Intent AlarmClockIntent = new Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_LAUNCHER).setComponent(new ComponentName("com.android.alarmclock", "com.android.alarmclock.AlarmClock"));
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, AlarmClockIntent, 0);
            views.setOnClickPendingIntent(R.id.Widget, pendingIntent);
                                    
            AppWidgetManager.getInstance(context).updateAppWidget(intent.getIntArrayExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS), views);
        }
    }
}
