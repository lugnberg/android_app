package com.example.android.first;
import android.provider.MediaStore;

/**
 * Created by chlug on 2018-01-23.
 *
 * implement synchronization
 */

public class Pauser {
    private boolean flag;

    public Pauser(boolean startValue){
        flag=startValue;
    }

    public boolean getPauseFlag() {
        return flag;
    }

    public void toggleFlag() {
        flag = flag ?  false : true;
        }

}
