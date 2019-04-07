package bjpkten.eventdispatchtestdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * https://www.jianshu.com/p/e99b5e8bd67b, please check this , it is good
 */
public class MainActivity extends AppCompatActivity {

    private String TAG = "kodulf";
    private TextView mTextView;
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

    private RadioGroup mDispatchGroup;
    private RadioGroup mOnTouchGroup;
    private RadioGroup mLinearLayoutDispatchGroup;
    private RadioGroup mLinearLayoutOnTouchGroup;
    private RadioGroup mLinearLayoutOnInterruptGroup;
    private RadioGroup mLinearLayoutDispatchGroup2;
    private RadioGroup mLinearLayoutOnTouchGroup2;
    private RadioGroup mLinearLayoutOnInterruptGroup2;
    private RadioGroup mViewDispatchGroup;
    private RadioGroup mViewOnTouchGroup;
    //    private boolean mActivityOninterruptEventChecked = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init(){
        mDispatchGroup = (RadioGroup) findViewById(R.id.actvitiy_group_dispatch);
        mOnTouchGroup = (RadioGroup) findViewById(R.id.actvitiy_group_ontouch);

        mDispatchGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.activity_dispatch_false:
                        mActivityDispatchSelect = RETURN_FALSE;
                        break;
                    case R.id.activity_dispatch_true:
                        mActivityDispatchSelect = RETURN_TRUE;
                        break;
                    case R.id.activity_dispatch_super:
                        mActivityDispatchSelect = RETURN_SUPER;
                        break;
                }
            }
        });

        mOnTouchGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.activity_ontouch_false:
                        mActivityOntouchSelect = RETURN_FALSE;
                        break;
                    case R.id.activity_ontouch_true:
                        mActivityOntouchSelect = RETURN_TRUE;
                        break;
                    case R.id.activity_ontouch_super:
                        mActivityOntouchSelect = RETURN_SUPER;
                        break;
                }
            }
        });


        //-----------------------------------------
        mLinearLayoutDispatchGroup = (RadioGroup) findViewById(R.id.linearylayout_group_dispatch);
        mLinearLayoutOnTouchGroup = (RadioGroup) findViewById(R.id.linearylayout_group_ontouch);
        mLinearLayoutOnInterruptGroup = (RadioGroup)findViewById(R.id.linearylayout__group_interrupt);

        mLinearLayoutDispatchGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.linearylayout_dispatch_false:
                        mLinearLayoutDispatchSelect = RETURN_FALSE;
                        break;
                    case R.id.linearylayout_dispatch_true:
                        mLinearLayoutDispatchSelect = RETURN_TRUE;
                        break;
                    case R.id.linearylayout_dispatch_super:
                        mLinearLayoutDispatchSelect = RETURN_SUPER;
                        break;
                }
            }
        });

        mLinearLayoutOnTouchGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.linearylayout_ontouch_false:
                        mLinearLayoutOntouchSelect = RETURN_FALSE;
                        break;
                    case R.id.linearylayout_ontouch_true:
                        mLinearLayoutOntouchSelect  = RETURN_TRUE;
                        break;
                    case R.id.linearylayout_ontouch_super:
                        mLinearLayoutOntouchSelect  = RETURN_SUPER;
                        break;
                }
            }
        });

        mLinearLayoutOnInterruptGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.linearylayout__group_interrupt_false:
                        mLinearLayoutOnInterrupteSelect = RETURN_FALSE;
                        break;
                    case R.id.linearylayout__group_interrupt_true:
                        mLinearLayoutOnInterrupteSelect = RETURN_TRUE;
                        break;
                    case R.id.linearylayout__group_interrupt_super:
                        mLinearLayoutOnInterrupteSelect = RETURN_SUPER;
                        break;
                }
            }
        });

        //-----------------------------------------
        mLinearLayoutDispatchGroup2 = (RadioGroup) findViewById(R.id.linearylayout2_group_dispatch);
        mLinearLayoutOnTouchGroup2 = (RadioGroup) findViewById(R.id.linearylayout2_group_ontouch);
        mLinearLayoutOnInterruptGroup2 = (RadioGroup)findViewById(R.id.linearylayout2__group_interrupt);

        mLinearLayoutDispatchGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.linearylayout2_dispatch_false:
                        mLinearLayoutDispatchSelect2 = RETURN_FALSE;
                        break;
                    case R.id.linearylayout2_dispatch_true:
                        mLinearLayoutDispatchSelect2 = RETURN_TRUE;
                        break;
                    case R.id.linearylayout2_dispatch_super:
                        mLinearLayoutDispatchSelect2 = RETURN_SUPER;
                        break;
                }
            }
        });

        mLinearLayoutOnTouchGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.linearylayout2_ontouch_false:
                        mLinearLayoutOntouchSelect2 = RETURN_FALSE;
                        break;
                    case R.id.linearylayout2_ontouch_true:
                        mLinearLayoutOntouchSelect2  = RETURN_TRUE;
                        break;
                    case R.id.linearylayout2_ontouch_super:
                        mLinearLayoutOntouchSelect2  = RETURN_SUPER;
                        break;
                }
            }
        });

        //-----------------------------------------
        mViewDispatchGroup = (RadioGroup) findViewById(R.id.view_group_dispatch);
        mViewOnTouchGroup = (RadioGroup) findViewById(R.id.view_group_ontouch);

        mViewDispatchGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.view_dispatch_false:
                        mViewDispatchSelect = RETURN_FALSE;
                        break;
                    case R.id.view_dispatch_true:
                        mViewDispatchSelect = RETURN_TRUE;
                        break;
                    case R.id.view_dispatch_super:
                        mViewDispatchSelect = RETURN_SUPER;
                        break;
                }
            }
        });

        mViewOnTouchGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.view_ontouch_false:
                        mViewOntouchSelect = RETURN_FALSE;
                        break;
                    case R.id.view_ontouch_true:
                        mViewOntouchSelect  = RETURN_TRUE;
                        break;
                    case R.id.view_ontouch_super:
                        mViewOntouchSelect  = RETURN_SUPER;
                        break;
                }
            }
        });


        mLinearLayoutOnInterruptGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.linearylayout2__group_interrupt_false:
                        mLinearLayoutOnInterrupteSelect2 = RETURN_FALSE;
                        break;
                    case R.id.linearylayout2__group_interrupt_true:
                        mLinearLayoutOnInterrupteSelect2 = RETURN_TRUE;
                        break;
                    case R.id.linearylayout2__group_interrupt_super:
                        mLinearLayoutOnInterrupteSelect2 = RETURN_SUPER;
                        break;
                }
            }
        });

    }

    public void startActivity(View view) {

        Intent intent = new Intent(this,DemoActivity.class);
        intent.putExtra("activity_dispatch",mActivityDispatchSelect);
        intent.putExtra("activity_ontouch",mActivityOntouchSelect);

        intent.putExtra("linearlayout_dispatch",mLinearLayoutDispatchSelect);
        intent.putExtra("linearlayout_ontouch",mLinearLayoutOntouchSelect);
        intent.putExtra("linearlayout_dispatch", mLinearLayoutOnInterrupteSelect);

        intent.putExtra("linearlayout_dispatch2",mLinearLayoutDispatchSelect2);
        intent.putExtra("linearlayout_ontouch2",mLinearLayoutOntouchSelect2);
        intent.putExtra("linearlayout_dispatch2", mLinearLayoutOnInterrupteSelect2);

        intent.putExtra("view_dispatch",mViewDispatchSelect);
        intent.putExtra("view_ontouch",mViewOntouchSelect);

        startActivity(intent);

//        startActivity();
    }
}
