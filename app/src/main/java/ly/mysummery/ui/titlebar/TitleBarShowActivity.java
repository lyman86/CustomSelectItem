package ly.mysummery.ui.titlebar;

import android.content.Intent;
import android.view.View;

import ly.customselectitem.CustomSelectItem;
import ly.mysummery.R;
import ly.mysummery.base.MyBaseActivity;

public class TitleBarShowActivity extends MyBaseActivity {

    public static final String TITLE_NAME = "title_name";
    public static final String TITLE_TAG = "title_tag";


    private static final int TITLE_BAR_01 = 0;
    private static final int TITLE_BAR_02 = 1;
    private static final int TITLE_BAR_03 = 2;
    private static final int TITLE_BAR_04 = 3;
    private static final int TITLE_BAR_05 = 4;
    private static final int TITLE_BAR_06 = 5;
    private static final int TITLE_BAR_07 = 6;

    private String titleName = "";
    private int titleTag = 0;

    @Override
    public void initLayout() {
        Intent intent = getIntent();
        titleName = intent.getStringExtra(TITLE_NAME);
        titleTag = intent.getIntExtra(TITLE_TAG, 0);
        switch (titleTag) {
            case TITLE_BAR_01:
                setContentView(R.layout.activity_title_bar_show01);
                break;
            case TITLE_BAR_02:
                setContentView(R.layout.activity_title_bar_show02);
                break;
            case TITLE_BAR_03:
                setContentView(R.layout.activity_title_bar_show03);
                break;
            case TITLE_BAR_04:
                setContentView(R.layout.activity_title_bar_show04);
                break;
            case TITLE_BAR_05:
                setContentView(R.layout.activity_title_bar_show05);
                break;
            case TITLE_BAR_06:
                setContentView(R.layout.activity_title_bar_show06);
                break;
            case TITLE_BAR_07:
                setContentView(R.layout.activity_title_bar_show07);
                break;
        }

    }

    @Override
    public void initId() {

    }

    @Override
    public void initListener() {
        titleBar.setOnBarViewClickListener(this);
    }

    @Override
    public void initDatas() {
        titleBar.setCenterText(titleName);
/**
 * 可在java代码里动态修改图片资源
 */
//        if (titleTag == 2){
//            titleBar.setRightImageScouce(R.drawable.icon_user_white);
//            titleBar.setLeftImageScouce(R.drawable.icon_white_screen);
//        }
    }

    @Override
    public void onBarViewClick(View v, int whitch) {
        switch (whitch) {
            case CustomSelectItem.CENTER_VIEW:
                //titleBar01
                if (titleTag == 0) {
                    showToast("你点击了中间位置");
                }
                break;
            case CustomSelectItem.LEFT_VIEW:
                //titleBar02  titleBar03 titleBar04  titleBar05  titleBar06  titleBar07
                if (titleTag == 1 || titleTag == 2 || titleTag == 3 || titleTag == 4 || titleTag == 5 || titleTag == 6) {
                    showToast("你点击了左边位置");
                }
                break;
            case CustomSelectItem.RIGHT_VIEW:
                //titleBar03  titleBar04  titleBar05  titleBar06  titleBar07
                if (titleTag == 2 || titleTag == 3 || titleTag == 4 || titleTag == 5 || titleTag == 6) {
                    showToast("你点击了右边位置");
                }
                break;
            case CustomSelectItem.RIGHT_SIDE_VIEW:
                //titleBar06  titleBar07
                if (titleTag == 5 || titleTag == 6) {
                    showToast("你点击了右边旁边位置");
                }
                break;

            case CustomSelectItem.LEFT_SIDE_VIEW:
                //titleBar05
                if (titleTag == 6) {
                    showToast("你点击了左边旁边位置");
                }
                break;
        }
    }
}
