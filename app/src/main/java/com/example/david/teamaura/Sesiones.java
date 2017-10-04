package com.example.david.teamaura;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by david on 30/9/17.
 */

public class Sesiones {
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Context ctx;

    public Sesiones(Context ctx){
        this.ctx = ctx;
        prefs = ctx.getSharedPreferences("myapp", Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void setLoggedin(boolean logggedin){
        editor.putBoolean("loggedInmode",logggedin);
        editor.commit();
    }

    public boolean loggedin(){
        return prefs.getBoolean("loggedInmode", false);
    }
}
