package io.internetthings.tidbittest;

/*

 Created by: Jason Maderski
 Date: 03/23/15
 Name: TidBit Test Program
 Version: 0.1

 This program will create and cancel notifications.

 */
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private NotificationManager nManager = null;
    private int nId = 0;
    private String sTag = "io.internetthings.tidbittest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Function that performs an action when a button is pressed
    public void buttonClicked(View v){
        //Action performed when Create Notification button is pressed
        if(v.getId() == R.id.btnCreate){
            nId = (int)System.currentTimeMillis();
            NotificationCompat.Builder nCompat = new NotificationCompat.Builder(this);
            nCompat.setContentTitle("Notification Created");
            nCompat.setContentText("Test Notification Id: " + nId);
            nCompat.setSmallIcon(R.mipmap.ic_launcher);
            nManager.notify(sTag, nId, nCompat.build());
            toastMSG("Notification Created");
        }
        //Action performed when Clear All Notification button is pressed
        else if(v.getId() == R.id.btnClearAll){
           nManager.cancelAll();
           toastMSG("Notifications Cancelled");
        }
    }
    //Creates toast messages
    public void toastMSG(CharSequence text){
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
