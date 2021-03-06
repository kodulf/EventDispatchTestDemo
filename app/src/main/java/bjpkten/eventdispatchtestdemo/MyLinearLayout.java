package bjpkten.eventdispatchtestdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by Kodulf on 2019/4/7.
 */
public class MyLinearLayout extends LinearLayout {

    public static final int RETURN_SUPER = 2;
    public static final int RETURN_TRUE = 1;
    public static final int RETURN_FALSE = 0;
    public int mLinearLayoutDispatchSelect = 2;
    public int mLinearLayoutOntouchSelect = 2;
    public int mLinearLayoutonInterceptTouchSelect = 2;


    public MyLinearLayout(Context context) {
        super(context);
    }

    public MyLinearLayout(Context context,  AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLinearLayout(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        getActionAndUpdate(ev," dispatchTouchEvent ");

        switch (mLinearLayoutDispatchSelect){
            case RETURN_FALSE:
                return false;
            case RETURN_TRUE:
                return true;
            default:
                return super.dispatchTouchEvent(ev);
        }
    }


    @Override
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        getActionAndUpdate(ev,"onTouchEvent");
        switch (mLinearLayoutOntouchSelect){
            case RETURN_FALSE:
                return false;
            case RETURN_TRUE:
                return true;
            default:
                return super.onTouchEvent(ev);
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (mLinearLayoutonInterceptTouchSelect){
            case RETURN_FALSE:
                return false;
            case RETURN_TRUE:
                return true;
            default:
                return super.onInterceptTouchEvent(ev);
        }
    }

    @NonNull
    private String getActionAndUpdate(MotionEvent ev, String method) {
        String action ;
        if(ev.getAction() == MotionEvent.ACTION_DOWN){
            action = "DOWN";
        }else if(ev.getAction() == MotionEvent.ACTION_UP) {
            action = "UP";
        }else if(ev.getAction() == MotionEvent.ACTION_MOVE){
            action = "MOVE";
        }else if(ev.getAction() == MotionEvent.ACTION_CANCEL){
            action = "ACTION_CANCEL";
        }else{
            action = ev.getAction()+"";
        }
        String updateText = "part: " + "-- LinearLayout --" + " method:[-" + method+" -] action:"
                + action + " \n";
        Log.d("kodulf",updateText);
        return updateText;
    }
}
