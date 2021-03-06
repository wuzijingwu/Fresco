package text.bwei.com.myapplication;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FrescoMultiActivity extends Activity {
    @BindView(R.id.sdv_fresco_multi)
    SimpleDraweeView sdvFrescoMulti;
    @BindView(R.id.bt_fresco_multiImg)
    Button btFrescoMultiImg;
    @BindView(R.id.bt_fresco_thumbnailImg)
    Button btFrescoThumbnailImg;
    @BindView(R.id.bt_fresco_multiplexImg)
    Button btFrescoMultiplexImg;
    @BindView(R.id.activity_fresco_multi)
    LinearLayout activityFrescoMulti;

//    @Bind(R.id.tv_title)
//    TextView tvTitle;
//    @Bind(R.id.sdv_fresco_multi)
//    SimpleDraweeView sdvFrescoMulti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fresco_multi);
        ButterKnife.bind(this);

        initData();
    }


    private void initData() {

    }

    // 先显示低分辨率的图，然后是高分辨率的图
    @OnClick(R.id.bt_fresco_multiImg)
    void bt_fresco_multiImg_click(View view) {

        // 图片地址
        Uri lowUri = Uri.parse("http://img1.gamedog.cn/2012/03/11/19-120311133617-50.jpg");
        Uri highUri = Uri.parse("http://img5.duitang.com/uploads/item/201312/03/20131203153823_Y4y8F.jpeg");

        // 控制加载图片
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setLowResImageRequest(ImageRequest.fromUri(lowUri))
                .setImageRequest(ImageRequest.fromUri(highUri))
                .build();

        // 加载图片
        sdvFrescoMulti.setController(controller);
    }

    // 本地缩略图预览
    @OnClick(R.id.bt_fresco_thumbnailImg)
    void bt_fresco_thumbnailImg_click(View view) {

        // 图片地址
        Uri uri = Uri.fromFile(new File(Environment.getExternalStorageDirectory() + "/meinv1.jpg"));
        // 加载图片的请求
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                .setLocalThumbnailPreviewsEnabled(true)
                .build();

        // 控制图片的加载
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .build();

        // 加载图片
        sdvFrescoMulti.setController(controller);
    }

    // 本地图片复用
    @OnClick(R.id.bt_fresco_multiplexImg)
    void bt_fresco_multiplexImg_click(View view) {
        //本地图片的复用
        //在请求之前，还会去内存中请求一次图片，没有才会先去本地，最后去网络uri
        //本地准备复用图片的uri  如果本地这个图片不存在，会自动去加载下一个uri

        // 请求加载图片
        Uri uri1 = Uri.fromFile(new File(Environment.getExternalStorageDirectory() + "/meinv.jpg"));
        //图片的网络uri
        Uri uri2 = Uri.parse("http://img5.duitang.com/uploads/item/201312/03/20131203153823_Y4y8F.jpeg");

        ImageRequest request1 = ImageRequest.fromUri(uri1);
        ImageRequest request2 = ImageRequest.fromUri(uri2);
        ImageRequest[] requests = {request1, request2};

        // 控制加载图片
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setFirstAvailableImageRequests(requests)
                .setOldController(sdvFrescoMulti.getController())
                .build();

        // 加载图片
        sdvFrescoMulti.setController(controller);
    }
}
