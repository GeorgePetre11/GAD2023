package Observator;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(float temperature, float humidity, float pressure);
}

interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

class WeatherData implements Subject {
    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    private void measurementsChanged() {
        notifyObservers();
    }
}

class Display implements Observer {
    private float temperature;
    private float humidity;

    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    public void display() {
        System.out.println("Current conditions: " + temperature + "°C and " + humidity + "% humidity");
    }
}

public class WeatherMonitoringApp {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        Display display1 = new Display();
        Display display2 = new Display();

        weatherData.registerObserver(display1);
        weatherData.registerObserver(display2);


        weatherData.setMeasurements(25.5f, 65.2f, 1013.2f);
        weatherData.setMeasurements(26.8f, 63.8f, 1012.8f);

        weatherData.removeObserver(display2);

        weatherData.setMeasurements(27.3f, 62.4f, 1012.5f);
    }
}
