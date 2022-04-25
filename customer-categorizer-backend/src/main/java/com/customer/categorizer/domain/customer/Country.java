package com.customer.categorizer.domain.customer;

public enum Country {
    CAMEROON("Cameroon","\\(237\\)", "\\(237\\)\\ ?[2368]\\d{7,8}$"),
    ETHIOPIA("Ethiopia","\\(251\\)", "\\(251\\)\\ ?[1-59]\\d{8}$"),
    MOROCCO("Morocco","\\(212\\)", "\\(212\\)\\ ?[5-9]\\d{8}$"),
    MOZAMBIQUE("Mozambique","\\(258\\)", "\\(258\\)\\ ?[28]\\d{7,8}$"),
    UGANDA("Uganda","\\(256\\)", "\\(256\\)\\ ?\\d{9}$");

    private String countryName;
    private String partialZoneIdAllowedPattern;
    private String fullZoneIdAllowedPattern;

    Country(String countryName, String partialZoneIdAllowedPattern, String fullZoneIdAllowedPattern) {
        this.countryName = countryName;
        this.partialZoneIdAllowedPattern = partialZoneIdAllowedPattern;
        this.fullZoneIdAllowedPattern = fullZoneIdAllowedPattern;
    }

    public static Country getCountry(String countryName){
        Country country = null;
        for (Country t : Country.values()) {
            if(t.countryName.equals(countryName)){
                country = t;
            }
        }
        return country;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getPartialZoneIdAllowedPattern() {
        return partialZoneIdAllowedPattern;
    }

    public String getFullZoneIdAllowedPattern() {
        return fullZoneIdAllowedPattern;
    }
}
