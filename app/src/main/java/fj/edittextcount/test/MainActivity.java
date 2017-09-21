package fj.edittextcount.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import fj.edittextcount.lib.FJEditTextCount;

/**
 * ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
 * ┃   ╭﹉﹊﹉╮ ╔═════╗╔═════╗╔═════╗┃
 * ┃╭╯老斯基㊣╠╣淡漠de人生╠╣2016-10-09╠╣ 欢迎关注 ╣┃
 * ┃╰⊙┈┈┈⊙╯╚◎═══◎╝╚◎═══◎╝╚◎═══◎╝┃
 * ┣━━━┳━━━━━━━━━━━━━━━━━━━━━━━━┫
 * ┃GitHub┃https://github.com/FJ917                        ┃
 * ┃简  书┃http://www.jianshu.com/users/3d2770e6e489       ┃
 * ┃Q    Q┃511334686                                       ┃
 * ┗━━━┻━━━━━━━━━━━━━━━━━━━━━━━━┛
 */
public class MainActivity extends AppCompatActivity {

    private FJEditTextCount fjEdit;
    private Button btnGetText;
    private TextView tvText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fjEdit = (FJEditTextCount) findViewById(R.id.fjEdit);
        btnGetText = (Button) findViewById(R.id.btnGetText);
        tvText = (TextView) findViewById(R.id.tvText);
//        fjEdit.setText("默认输入的文字");
//        fjEdit.setEtHint("内容")//设置提示文字
//                .setEtMinHeight(200)//设置最小高度，单位px
//                .setLength(50)//设置总字数
//                //TextView显示类型(SINGULAR单数类型)(PERCENTAGE百分比类型)
//                .setType(FJEditTextCount.SINGULAR)
//                .setLineColor("#3F51B5")//设置横线颜色
//                .show();

        btnGetText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvText.setText(fjEdit.getText());//获取值
            }
        });
    }
}
