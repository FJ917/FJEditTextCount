package anfq.numedittext.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import anfq.numedittext.lib.AnFQNumEditText;

public class MainActivity extends AppCompatActivity {

    private AnFQNumEditText anetDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anetDemo = (AnFQNumEditText) findViewById(R.id.anetDemo);
        anetDemo.setEtHint("内容")//设置提示文字
                .setEtMinHeight(200)//设置最小高度，单位px
                .setLength(50)//设置总字数
                .setType(AnFQNumEditText.SINGULAR)//TextView显示类型(SINGULAR单数类型)(PERCENTAGE百分比类型)
                .setLineColor("#3F51B5")//设置横线颜色
                .show();
    }
}
