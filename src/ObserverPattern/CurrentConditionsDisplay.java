package ObserverPattern;

import ObserverPattern.interfaces.DisplayElement;
import ObserverPattern.interfaces.Subject;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

    Observable observable = new Observable();
    private float temperature;
    private float humidity;
    private Subject weatherData;
    public CurrentConditionsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }
    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature
                + "F degrees and " + humidity + "% humidity");
    }

    @Override
    public void update(Observable obs, Object arg) {
      if(obs instanceof WeatherData) {
          WeatherData weatherData = (WeatherData) obs;
          this.temperature = weatherData.getTemprature();
          this.humidity =weatherData.getHumidity();
          display();
      }
    }
}
