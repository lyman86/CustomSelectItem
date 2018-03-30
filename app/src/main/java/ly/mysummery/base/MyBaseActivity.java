package ly.mysummery.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import ly.customselectitem.CustomSelectItem;
import ly.mysummery.R;
import ly.mysummery.utils.StatusBarUtils;

public abstract class MyBaseActivity extends AppCompatActivity implements CustomSelectItem.OnBarViewClickListener {

    protected CustomSelectItem titleBar;
    protected View paddingView;
    private Toast mToast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtils.setTranslucent(this);
        initLayout();
        initTitle();
        initId();
        initListener();
        initDatas();
    }

    public void initTitle() {
        paddingView = findViewById(R.id.paddingView);
        titleBar = findViewById(R.id.cusTitleBar);
        if (paddingView != null) {
            ViewGroup.LayoutParams params = paddingView.getLayoutParams();
            params.height = getStatusBarHeight();
        }
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }


    public void showToast(String string) {
        if (mToast == null) {
            mToast = Toast.makeText(this, string, Toast.LENGTH_LONG);
            mToast.setGravity(Gravity.CENTER,0,0);
        } else {
            mToast.setText(string);
        }
        mToast.show();
    }


    @Override
    public void onBarViewClick(View v, int whitch) {
        switch (whitch) {
            case CustomSelectItem.LEFT_VIEW:
                finish();
                break;
        }
    }

    public abstract void initLayout();

    public abstract void initId();

    public abstract void initListener();

    public abstract void initDatas();
}
