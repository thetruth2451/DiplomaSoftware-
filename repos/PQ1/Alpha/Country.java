public class Country
{
    private String countryName;
    //getter
    public String returnCountry() { return countryName; }
    //Setter
    public Country(String country) { countryName = country; }

    public class City
    {
        private String cityName;
        //getter
        public String returnCity() { return cityName; }
        //setter
        public City(String city)
        {
            cityName = city;
        }

    }




}
