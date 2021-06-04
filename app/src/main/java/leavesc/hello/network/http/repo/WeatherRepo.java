package leavesc.hello.network.http.repo;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import leavesc.hello.network.http.basis.BaseRepo;
import leavesc.hello.network.http.basis.callback.RequestCallback;
import leavesc.hello.network.http.datasource.base.IWeatherDataSource;
import leavesc.hello.network.model.Weather;

/**
 * 作者：leavesC
 * 时间：2018/10/27 21:12
 * 描述：用来屏蔽 WeatherViewModel 对 WeatherDataSource 的感知，并承担起一部分数据处理逻辑。
 * GitHub：https://github.com/leavesC
 */
public class WeatherRepo extends BaseRepo<IWeatherDataSource> {

    public WeatherRepo(IWeatherDataSource remoteDataSource) {
        super(remoteDataSource);
    }

    public MutableLiveData<Weather> queryWeather(String cityName) {
        MutableLiveData<Weather> weatherMutableLiveData = new MutableLiveData<>();
        remoteDataSource.queryWeather(cityName, new RequestCallback<Weather>() {
            @Override
            public void onSuccess(Weather weather) {
                Log.e("aaaaa", "onSuccess: ");
                weatherMutableLiveData.setValue(weather);
            }
        });
        return weatherMutableLiveData;
    }

}
