package kevinstar1.edu.cn.dialogpractice.widget;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import kevinstar1.edu.cn.dialogpractice.R;

/**
 * Created by Administrator on 2017/8/12.
 */

public class InputOrderNoDialog extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_order_dialog);
        findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
