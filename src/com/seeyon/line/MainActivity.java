package com.seeyon.line;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.seeyon.line.view.ContentView;
import com.seeyon.line.view.Drawl.GestureCallBack;

/**
 * 
 * @author yinqiaoyin
 * 
 */
public class MainActivity extends Activity {

	private FrameLayout body_layout;
	private ContentView content;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		body_layout = (FrameLayout) findViewById(R.id.body_layout);

		// 初始化一个显示各个点的viewGroup
		content = new ContentView(this, "123654789", 4, new GestureCallBack() {

			@Override
			public void checkedSuccess() {
				Toast.makeText(MainActivity.this, "校验成功", Toast.LENGTH_SHORT)
						.show();
			}

			@Override
			public void checkedFail() {
				Toast.makeText(MainActivity.this, "校验失败", Toast.LENGTH_SHORT)
						.show();
			}

			@Override
			public void minLenghtFail() {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "至少连接4个点", Toast.LENGTH_SHORT)
						.show();
			}
		});
		// 设置手势解锁显示到哪个布局里面
		content.setParentView(body_layout);
	}

}
