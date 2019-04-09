package bjpkten.eventdispatchtestdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;

public class DemoActivity extends AppCompatActivity {

    private MyLinearLayout mMyLinearLayout;
    private MyLinearLayout mMyLinearLayout2;
    private MyView mMyView;

    private String TAG = "kodulf";

    private static final int RETURN_SUPER = 2;
    private static final int RETURN_TRUE = 1;
    private static final int RETURN_FALSE = 0;
    private int mActivityDispatchSelect = 2;
    private int mActivityOntouchSelect = 2;
    private int mLinearLayoutDispatchSelect = 2;
    private int mLinearLayoutOntouchSelect = 2;
    private int mLinearLayoutOnInterrupteSelect = 2;
    private int mLinearLayoutOnInterrupteSelect2 = 2;

    private int mLinearLayoutDispatchSelect2 = 2;
    private int mLinearLayoutOntouchSelect2 = 2;

    private int mViewDispatchSelect = 2;
    private int mViewOntouchSelect = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        Intent intent = getIntent();

        mActivityDispatchSelect = intent.getIntExtra("activity_dispatch",mActivityDispatchSelect);
        mActivityOntouchSelect = intent.getIntExtra("activity_ontouch",mActivityOntouchSelect);

        mLinearLayoutDispatchSelect = intent.getIntExtra("linearlayout_dispatch",mLinearLayoutDispatchSelect);
        mLinearLayoutOntouchSelect = intent.getIntExtra("linearlayout_ontouch",mLinearLayoutOntouchSelect);
        mLinearLayoutOnInterrupteSelect = intent.getIntExtra("linearlayout_interrupte", mLinearLayoutOnInterrupteSelect);

        mLinearLayoutDispatchSelect2 = intent.getIntExtra("linearlayout_dispatch2",mLinearLayoutDispatchSelect2);
        mLinearLayoutOntouchSelect2 = intent.getIntExtra("linearlayout_ontouch2",mLinearLayoutOntouchSelect2);
        mLinearLayoutOnInterrupteSelect2 = intent.getIntExtra("linearlayout_interrupte2", mLinearLayoutOnInterrupteSelect2);

        mViewDispatchSelect = intent.getIntExtra("view_dispatch",mViewDispatchSelect);
        mViewOntouchSelect = intent.getIntExtra("view_ontouch",mViewOntouchSelect);

        mMyLinearLayout = (MyLinearLayout) findViewById(R.id.myLinearLayout);
        mMyLinearLayout.mLinearLayoutOntouchSelect = mLinearLayoutOntouchSelect;
        mMyLinearLayout.mLinearLayoutDispatchSelect = mLinearLayoutDispatchSelect;
        mMyLinearLayout.mLinearLayoutonInterceptTouchSelect = mLinearLayoutOnInterrupteSelect;


        mMyLinearLayout2 = (MyLinearLayout) findViewById(R.id.myLinearLayout2);
        mMyLinearLayout2.mLinearLayoutOntouchSelect = mLinearLayoutOntouchSelect2;
        mMyLinearLayout2.mLinearLayoutDispatchSelect = mLinearLayoutDispatchSelect2;
        mMyLinearLayout2.mLinearLayoutonInterceptTouchSelect = mLinearLayoutOnInterrupteSelect2;


        mMyView = (MyView)findViewById(R.id.myView);
        mMyView.mLinearLayoutOntouchSelect = mViewOntouchSelect;
        mMyView.mLinearLayoutDispatchSelect = mViewDispatchSelect;

    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        getActionAndUpdate(ev,"dispatchTouchEvent");
        switch (mActivityDispatchSelect){
            case RETURN_FALSE:
                return false;
            case RETURN_TRUE:
                return true;
            default:
                return super.dispatchTouchEvent(ev);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        getActionAndUpdate(ev,"onTouchEvent");
        switch (mActivityOntouchSelect){
            case RETURN_FALSE:
                return false;
            case RETURN_TRUE:
                return true;
            default:
                return super.onTouchEvent(ev);
        }

    }



    @NonNull
    private String getActionAndUpdate(MotionEvent ev,String method) {
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
        String updateText = "part: " + "=============Activity" + " method:[-" + method+" -] action:"
                + action + " \n";
        Log.d("kodulf",updateText);
        return updateText;
    }
}
