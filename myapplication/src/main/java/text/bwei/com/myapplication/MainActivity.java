package text.bwei.com.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.bt_fresco_spimg)
    Button bt_fresco_spimg;
    @BindView(R.id.bt_fresco_crop)
    Button bt_fresco_crop;
    @BindView(R.id.bt_fresco_circleAndCorner)
    Button bt_fresco_circleAndCorner;
    @BindView(R.id.bt_fresco_jpeg)
    Button bt_fresco_jpeg;
    @BindView(R.id.bt_fresco_gif)
    Button bt_fresco_gif;
    @BindView(R.id.bt_fresco_multi)
    Button bt_fresco_multi;
    @BindView(R.id.bt_fresco_listener)
    Button bt_fresco_listener;
    @BindView(R.id.bt_fresco_resize)
    Button bt_fresco_resize;
    @BindView(R.id.bt_fresco_modifyImg)
    Button bt_fresco_modifyImg;
    @BindView(R.id.bt_fresco_autoSizeImg)
    Button bt_fresco_autoSizeImg;
    @BindView(R.id.activity_fresco)
    LinearLayout activity_fresco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fresco);
        ButterKnife.bind(this);

    }

//    private void initData() {
//        tvTitle.setText("Fresco");
//    }

    // 带进度条的图片
    @OnClick({R.id.bt_fresco_spimg, R.id.bt_fresco_crop, R.id.bt_fresco_circleAndCorner, R.id.bt_fresco_jpeg, R.id.bt_fresco_gif, R.id.bt_fresco_multi, R.id.bt_fresco_listener, R.id.bt_fresco_resize, R.id.bt_fresco_modifyImg, R.id.bt_fresco_autoSizeImg, R.id.activity_fresco})
    void bt_fresco_spimg_click(View view) {
        Intent intent = new Intent(MainActivity.this, FrescoSpimgActivity.class);
        startActivity(intent);

    }

    // 图片的不同裁剪
    @OnClick(R.id.bt_fresco_crop)
    void bt_fresco_crop_click(View view) {
        Intent intent = new Intent(MainActivity.this, FrescoCropActivity.class);

        startActivity(intent);
    }

    // 圆形和圆角图片
    @OnClick(R.id.bt_fresco_circleAndCorner)
    void bt_fresco_circleAndCorner_click(View view) {
        Intent intent = new Intent(MainActivity.this, FrescoCircleAndCornerActivity.class);

        startActivity(intent);
    }

    // 渐进式展示图片
    @OnClick(R.id.bt_fresco_jpeg)
    void bt_fresco_jpeg_click(View view) {
        Intent intent = new Intent(MainActivity.this, FrescoJpegActivity.class);

        startActivity(intent);
    }

    // GIF动画图片
    @OnClick(R.id.bt_fresco_gif)
    void bt_fresco_gif_click(View view) {
        Intent intent = new Intent(MainActivity.this, FrescoGifAcitivity.class);

        startActivity(intent);
    }

    // 多图请求及图片复用
    @OnClick(R.id.bt_fresco_multi)
    void bt_fresco_multi_click(View view) {
        Intent intent = new Intent(MainActivity.this, FrescoMultiActivity.class);

        startActivity(intent);
    }

    // 图片加载监听
    @OnClick(R.id.bt_fresco_listener)
    void bt_fresco_listener_click(View view) {
        Intent intent = new Intent(MainActivity.this, FrescoListenerActivity.class);

        startActivity(intent);
    }

    // 图片修改和旋转
    @OnClick(R.id.bt_fresco_resize)
    void bt_fresco_resize_click(View view) {

        Intent intent = new Intent(MainActivity.this, FrescoResizeActivity.class);

        startActivity(intent);
    }

    // 修改图片
    @OnClick(R.id.bt_fresco_modifyImg)
    void bt_fresco_modifyImg_click(View view) {
        Intent intent = new Intent(MainActivity.this, FrescoModifyActivity.class);

        startActivity(intent);
    }

    // 动态展示图片
    @OnClick(R.id.bt_fresco_autoSizeImg)
    void bt_fresco_autoSizeImg_click(View view) {
        Intent intent = new Intent(MainActivity.this, FrescoAutoSizeActivity.class);

        startActivity(intent);
    }

}
