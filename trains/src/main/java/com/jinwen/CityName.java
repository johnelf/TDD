package com.jinwen;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 10/10/12
 * Time: 10:42 PM
 * To change this template use File | Settings | File Templates.
 */
public enum CityName {
    XIAN("A"), BEIJING("B"), CHENGDU("C"), SHANGHAI("D"), GUANGZHOU("E");

    private String cityName;

    CityName(String cityName) {
        this.cityName = cityName;
    }

    public static CityName getCityName(String cityName) {
        for (CityName var : values() ){
            if (var.cityName.equals(cityName)) return var;
        }
        return null;
    }
}
