package text.bwei.com.myapplication;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

//import com.atguigu.android.R;
//import butterknife.Bind;

public class FrescoSpimgActivity extends Activity {
    @BindView(R.id.sdv_fresco_spimg)
    SimpleDraweeView sdvFrescoSpimg;
    @BindView(R.id.activity_fresco_spimg)
    LinearLayout activityFrescoSpimg;

//    @Bind(R.id.tv_title)
//    TextView tvTitle;
//    @Bind(R.id.sdv_fresco_spimg)
//    SimpleDraweeView sdvFrescoSpimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fresco_spimg);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {


        // 设置样式
        GenericDraweeHierarchyBuilder builder = new GenericDraweeHierarchyBuilder(getResources());

        GenericDraweeHierarchy hierarchy = builder.setProgressBarImage(new ProgressBarDrawable()).build();

        sdvFrescoSpimg.setHierarchy(hierarchy);

        // 加载图片的地址
        Uri uri = Uri.parse("http://img4.duitang.com/uploads/item/201211/24/20121124175330_ruKEK.jpeg");

        // 加载图片
        sdvFrescoSpimg.setImageURI(uri);
    }


}
