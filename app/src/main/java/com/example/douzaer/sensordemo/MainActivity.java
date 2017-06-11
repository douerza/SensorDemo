package com.example.douzaer.sensordemo;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //显示信息的UI组件
    private TextView tv;
    //传感器管理器
    private SensorManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //从系统服务中获得传感器管理器
        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        tv = (TextView) findViewById(R.id.tv);

        //从传感器管理器中获得全部的传感器列表
        List<Sensor> allSensors = sm.getSensorList(Sensor.TYPE_ALL);
        //记录传感器信息
        StringBuilder sb = new StringBuilder();

        sb.append("手机共有" + allSensors.size() + "个传感器，分别为：\n\n");
        for(Sensor s:allSensors){
            switch (s.getType()){
                case Sensor.TYPE_ORIENTATION:
                    sb.append(s.getType() + " 方向传感器(Orientation sensor)" + "\n");
                    break;
                case Sensor.TYPE_ACCELEROMETER:
                    sb.append(s.getType() + " 加速传感器(Accelerometer sensor)" + "\n");
                    break;
                case Sensor.TYPE_GYROSCOPE:
                    sb.append(s.getType() + " 陀螺仪传感器(Gyroscope sensor)" + "\n");
                    break;
                case Sensor.TYPE_MAGNETIC_FIELD:
                    sb.append(s.getType() + " 磁场传感器(Magnetic field sensor)" + "\n");
                    break;
                case Sensor.TYPE_PROXIMITY:
                    sb.append(s.getType() + " 距离传感器(Proximity sensor)" + "\n");
                    break;
                case Sensor.TYPE_LIGHT:
                    sb.append(s.getType() + " 光线传感器(Light sensor)" + "\n");
                    break;
                case Sensor.TYPE_PRESSURE:
                    sb.append(s.getType() + " 气压传感器(Pressure sensor)" + "\n");
                    break;
                case Sensor.TYPE_AMBIENT_TEMPERATURE:
                    sb.append(s.getType() + " 温度传感器(Temperature sensor)" + "\n");
                    break;
                case Sensor.TYPE_GRAVITY:
                    sb.append(s.getType() + " 重力传感器(Gravity sensor)" + "\n");
                    break;
                case Sensor.TYPE_LINEAR_ACCELERATION:
                    sb.append(s.getType() + " 线性加速传感器(Linear Acceleration sensor)" + "\n");
                    break;
                case Sensor.TYPE_ROTATION_VECTOR:
                    sb.append(s.getType() + " 旋转矢量传感器(Rotation Vector sensor)" + "\n");
                    break;
                case Sensor.TYPE_RELATIVE_HUMIDITY:
                    sb.append(s.getType() + " 湿度传感器(Relative Humidity sensor)" + "\n");
                    break;
                case Sensor.TYPE_GAME_ROTATION_VECTOR:
                    sb.append(s.getType() + " 游戏动作传感器(Game Rotation Vector sensor)" + "\n");
                    break;
                case Sensor.TYPE_STEP_DETECTOR:
                    sb.append(s.getType() + " 步行检测传感器(Step Detector sensor)" + "\n");
                    break;
                case Sensor.TYPE_STEP_COUNTER:
                    sb.append(s.getType() + " 计步传感器(Step Counter sensor)" + "\n");
                    break;
                default:
                    sb.append(s.getType() + " 其他传感器" + "\n");
                    break;
            }
            sb.append("设备名称：" + s.getName() + "\n 设备版本：" + s.getVersion() + "\n 供应商："
                    + s.getVendor() + "\n\n");
        }
        tv.setText(sb.toString());
    }
}
