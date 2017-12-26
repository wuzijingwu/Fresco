package text.bwei.com.myapplication;

import android.app.Activity;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FrescoGifAcitivity extends Activity {
    @BindView(R.id.sdv_fresco_gif)
    SimpleDraweeView sdvFrescoGif;
    @BindView(R.id.bt_fresco_askImg)
    Button btFrescoAskImg;
    @BindView(R.id.bt_fresco_stopAnim)
    Button btFrescoStopAnim;
    @BindView(R.id.bt_fresco_startAnim)
    Button btFrescoStartAnim;
    @BindView(R.id.activity_fresco_gif)
    LinearLayout activityFrescoGif;

//    @Bind(R.id.tv_title)
//    TextView tvTitle;
//    @Bind(R.id.sdv_fresco_gif)
//    SimpleDraweeView sdvFrescoGif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fresco_gif_acitivity);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {

    }

    // 请求gif图片
    @OnClick(R.id.bt_fresco_askImg)
    void bt_fresco_askImg_click(View view) {


        Uri uri = Uri.parse("http://s15.sinaimg.cn/mw690/0062ywFUgy6Y2pBSx1sde&690");

        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setAutoPlayAnimations(false)
                .setOldController(sdvFrescoGif.getController())
                .build();

        sdvFrescoGif.setController(controller);
    }

    //  动画停止
    @OnClick(R.id.bt_fresco_stopAnim)
    void bt_fresco_stopAnim_click(View view) {
        Animatable animatable = sdvFrescoGif.getController().getAnimatable();

        if (animatable != null && animatable.isRunning()) {
            animatable.stop();
        }

    }

    // 动画开始
    @OnClick(R.id.bt_fresco_startAnim)
    void bt_fresco_startAnim_click(View view) {

        Animatable animatable = sdvFrescoGif.getController().getAnimatable();

        if (animatable != null && !animatable.isRunning()) {
            animatable.start();
        }
    }
}
