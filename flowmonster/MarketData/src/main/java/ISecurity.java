import java.util.Date;

/**
 * Created by Aaron on 06/12/2015.
 */
public abstract class ISecurity {

    //Class Summary
    //
    //

    protected String _ric;
    protected double _midPrice;
    protected double _askPrice;
    protected double _lastPrice;
    protected double _avgDailyVol;
    protected double _askSize;
    protected double _bidSize;
    protected Date _lastTradeDate;
    protected double _lastTradePrice;
    protected double _lastTradeSize;
    protected double _open;
    protected double _previousClose;
    protected MarketDataEnums.MarketDataSources _marketDataSource;
    protected MarketDataEnums.DataQuality _dataQuality;


    public String get_ric() {
        return _ric;
    }

    public double get_midPrice() {
        return _midPrice;
    }

    public double get_askPrice() {
        return _askPrice;
    }

    public double get_lastPrice() {
        return _lastPrice;
    }

    public double get_avgDailyVol() {
        return _avgDailyVol;
    }

    public double get_askSize() {
        return _askSize;
    }

    public double get_bidSize() {
        return _bidSize;
    }

    public Date get_lastTradeDate() {
        return _lastTradeDate;
    }

    public double get_lastTradePrice() {
        return _lastTradePrice;
    }

    public double get_lastTradeSize() {
        return _lastTradeSize;
    }

    public double get_open() {
        return _open;
    }

    public double get_previousClose() {
        return _previousClose;
    }

    public MarketDataEnums.MarketDataSources get_marketDataSource() {
        return _marketDataSource;
    }

    public MarketDataEnums.DataQuality get_dataQuality() {
        return _dataQuality;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "RIC: " + get_ric()
                + ", Mid Price: " + get_midPrice()
                + ", Market Data Source: " + get_marketDataSource()
                + ", Data Quality : " + get_dataQuality();
    }
}
