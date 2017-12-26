package text.bwei.com.fresco3;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SimpleDraweeView sdv_image;
    /**
     * 设置圆形图片
     */
    private Button yuanxing;
    /**
     * 设置圆角图片
     */
    private Button yuanjiao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Uri imgUrl = Uri.parse("http://img1.imgtn.bdimg.com/it/u=492470756,6415127&fm=11&gp=0.jpg");
//                SimpleDraweeView urlImg = (SimpleDraweeView) findViewById(R.id.sdv_image_url);
        sdv_image.setImageURI(imgUrl);

    }

    private void initView() {
        sdv_image = (SimpleDraweeView) findViewById(R.id.sdv_image);
        sdv_image.setOnClickListener(this);
        yuanxing = (Button) findViewById(R.id.yuanxing);
        yuanxing.setOnClickListener(this);
        yuanjiao = (Button) findViewById(R.id.yuanjiao);
        yuanjiao.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.sdv_image:
                break;
            case R.id.yuanxing:
                //获取SimpleDraweeView


                //初始化圆角圆形参数对象
                RoundingParams rp = new RoundingParams();
                //设置图像是否为圆形
                rp.setRoundAsCircle(true);
                //设置圆角半径
                //rp.setCornersRadius(20);
                //分别设置左上角、右上角、左下角、右下角的圆角半径
                //rp.setCornersRadii(20,25,30,35);
                //分别设置（前2个）左上角、(3、4)右上角、(5、6)左下角、(7、8)右下角的圆角半径
                //rp.setCornersRadii(new float[]{20,25,30,35,40,45,50,55});
                //设置边框颜色及其宽度
                rp.setBorder(Color.BLACK, 1);
                //设置叠加颜色
                rp.setOverlayColor(Color.WHITE);
                //设置圆形圆角模式
                //rp.setRoundingMethod(RoundingParams.RoundingMethod.BITMAP_ONLY);
                //设置圆形圆角模式
                rp.setRoundingMethod(RoundingParams.RoundingMethod.OVERLAY_COLOR);

                //获取GenericDraweeHierarchy对象
                GenericDraweeHierarchy hierarchy = GenericDraweeHierarchyBuilder.newInstance(getResources())
                        //设置圆形圆角参数
                        .setRoundingParams(rp)
                        //设置圆角半径
                        //.setRoundingParams(RoundingParams.fromCornersRadius(20))
                        //分别设置左上角、右上角、左下角、右下角的圆角半径
                        //.setRoundingParams(RoundingParams.fromCornersRadii(20,25,30,35))
                        //分别设置（前2个）左上角、(3、4)右上角、(5、6)左下角、(7、8)右下角的圆角半径
                        //.setRoundingParams(RoundingParams.fromCornersRadii(new float[]{20,25,30,35,40,45,50,55}))
                        //设置圆形圆角参数；RoundingParams.asCircle()是将图像设置成圆形
                        //.setRoundingParams(RoundingParams.asCircle())
                        //设置淡入淡出动画持续时间(单位：毫秒ms)
                        .setFadeDuration(1000)
                        //构建
                        .build();

                //设置Hierarchy
                sdv_image.setHierarchy(hierarchy);

                //构建Controller
                DraweeController controller = Fresco.newDraweeControllerBuilder()
                        //设置需要下载的图片地址
                        .setUri("http://img1.imgtn.bdimg.com/it/u=492470756,6415127&fm=11&gp=0.jpg")
                        //设置点击重试是否开启
                        .setTapToRetryEnabled(true)
                        //构建
                        .build();

                //设置Controller
                sdv_image.setController(controller);



                break;
            case R.id.yuanjiao:
                Uri imgUrl = Uri.parse("http://img1.imgtn.bdimg.com/it/u=492470756,6415127&fm=11&gp=0.jpg");
//                SimpleDraweeView urlImg = (SimpleDraweeView) findViewById(R.id.sdv_image_url);
                sdv_image.setImageURI(imgUrl);

                break;
        }
    }
}
