package com.tpandroid.nicolas.testcanvasapplication.util;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.LinkedList;

/**
 * Created by nicolas on 20/08/14.
 */
public class Dessin extends View implements View.OnTouchListener {

    public LinkedList<Cercle> listeCercles;

    public Dessin(Context context, AttributeSet attrs) {
        super(context, attrs);
        listeCercles = new LinkedList<Cercle>();
        setOnTouchListener(this);
    }

    /**
     * Permet de dessiner les cercles enregistrés dans la liste
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        for (Cercle cercle : listeCercles){
            cercle.draw(canvas);
        }
    }

    /**
     * Permet de dessiner un cercle de rayon spot-touché à spot-relaché
     * Redessine le canvas à chaque création de cercle.
     * @param v vue ou dessiner
     * @param event event déclencheur (touché ou relaché)
     * @return
     */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int x = (int)event.getX(); int y = (int)event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: // toucher en x,y
                listeCercles.add(new Cercle(x, y, 1));
                break;
            case MotionEvent.ACTION_MOVE: // mouvement vers x,y
                Cercle cercle = listeCercles.getLast();
                cercle.rayon = (int)Math.sqrt(
                        (x-cercle.xc)*(x-cercle.xc) + (y-cercle.yc)*(y-cercle.yc));
                break;
        }
        this.invalidate();
        return true;
    }
}
