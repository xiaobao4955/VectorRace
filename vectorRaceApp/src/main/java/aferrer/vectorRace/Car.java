package aferrer.vectorRace;


import java.util.ArrayList;

/**
 * Created by AFerrer on 19/01/2015.
 */

public class Car {
    public ArrayList<Integer> x;
    public ArrayList<Integer> y;
    public ArrayList<Integer> vx;
    public ArrayList<Integer> vy;
    public boolean inTrack;
    public String color;

    public Car(){

        x = new ArrayList<Integer>();
        y = new ArrayList<Integer>();
        vx = new ArrayList<Integer>();
        vy = new ArrayList<Integer>();

        x.add(10);
        y.add(10);
        vx.add(0);
        vy.add(0);

        inTrack=true;
        color="#ffff0000";
    }

    public int getNumOfMovements(){
        return x.size();
    }

    public int getCurrPosIdx(){
        return(x.size() - 1);
    }

    public void moveTo(int ax, int ay){
        int size = x.size();
        vx.add(vx.get(size - 1) + ax);
        vy.add(vy.get(size - 1) + ay);
        x.add(x.get(size - 1) + vx.get(size));
        y.add(y.get(size - 1) + vy.get(size));
    }

    //this function removes the las move
    public void undo(){
        int currPos = getCurrPosIdx();
        x.remove(currPos);
        y.remove(currPos);
        vx.remove(currPos);
        vy.remove(currPos);
    }
}
