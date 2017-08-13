package kevinstar1.edu.cn.dialogpractice;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import kevinstar1.edu.cn.dialogpractice.widget.InputDialog;
import kevinstar1.edu.cn.dialogpractice.widget.InputOrderNoDialog;

public class InputDialogDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //正常显示
        findViewById(R.id.showDialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(InputDialogDemoActivity.this);
                final EditText editText = new EditText(InputDialogDemoActivity.this);
                builder.setView(editText);
                builder.setTitle("输入订单号")
                       .setNegativeButton("取消",null)
                       .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int which) {
                                String orderNo = editText.getText().toString();
                                if (TextUtils.isEmpty(orderNo)) {
                                    Toast.makeText(InputDialogDemoActivity.this,"订单号不能为空",Toast.LENGTH_SHORT);
                                    return;
                                }
                                dialog.dismiss();
                           }
                       });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputDialog inputDialog = new InputDialog.Builder(InputDialogDemoActivity.this)
                        .setNegativeButton("取消",null)
                        .setPositiveButton("确定",null)
                        .interceptButtonAction(new InputDialog.ButtonActionIntercepter() {
                            @Override
                            public boolean onInterceptButtonAction(int whichButton, CharSequence inputText) {
                                if (whichButton == DialogInterface.BUTTON_POSITIVE&&TextUtils.isEmpty(inputText)){
                                    Toast.makeText(InputDialogDemoActivity.this, "订单号不能为空", Toast.LENGTH_SHORT).show();
                                    return true;
                                }
                                return false;
                            }
                        })
                        .setTitle("请输入订单号").create();
                inputDialog.show();
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(InputDialogDemoActivity.this, InputOrderNoDialog.class);
                startActivity(intent);
            }
        });
    }
}
