package leavesc.hello.network.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.util.Log;

import leavesc.hello.network.http.datasource.WeatherDataSource;
import leavesc.hello.network.http.repo.WeatherRepo;
import leavesc.hello.network.model.Weather;
import leavesc.hello.network.viewmodel.base.BaseViewModel;

/**
 * 作者：leavesC
 * 时间：2018/10/27 21:14
 * 描述：用于实现逻辑与 UI 的隔离，并保障数据不因为页面重建而丢失。
 * GitHub：https://github.com/leavesC
 */
public class WeatherViewModel extends BaseViewModel {

    private MutableLiveData<Weather> weatherLiveData;

    private WeatherRepo weatherRepo;

    public WeatherViewModel() {
        weatherLiveData = new MutableLiveData<>();
        weatherRepo = new WeatherRepo(new WeatherDataSource(this));
    }

    public void queryWeather(String cityName) {
        weatherRepo.queryWeather(cityName).observe(lifecycleOwner, new Observer<Weather>() {
            @Override
            public void onChanged(@Nullable Weather weather) {
                Log.e("aaaaa", "onChanged: ");
                weatherLiveData.setValue(weather);
            }
        });
    }

    public MutableLiveData<Weather> getWeatherLiveData() {
        return weatherLiveData;
    }
}
