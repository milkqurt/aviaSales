package BIGPROJECT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager_BP {
    private Connection connection;

    // Подключение
    public void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/table_bp?useUnicode=true&serverTimezone=UTC","root", "");
            System.out.println("CONNECTED");
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    public ArrayList<Aircrafts_BP> getAllAircraft(){
        ArrayList<Aircrafts_BP> aircraftName = new ArrayList<>();
        try{
            PreparedStatement st = connection.prepareStatement("SELECT * FROM aircrafts");
            ResultSet rs = st.executeQuery();

            while (rs.next()){
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                String model = rs.getString("model");
                int bcCapacity = rs.getInt("business_class_capacity");
                int ecCapacity = rs.getInt("econom_class_capacity");
                aircraftName.add(new Aircrafts_BP(id, name,model,bcCapacity,ecCapacity));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return aircraftName;
    }


    public ArrayList<Aircrafts_BP> getAircraftName(){
        ArrayList<Aircrafts_BP> aircraftName = new ArrayList<>();
        try{
            PreparedStatement st = connection.prepareStatement("SELECT id, name  FROM aircrafts");
            ResultSet rs = st.executeQuery();

            while (rs.next()){
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                aircraftName.add(new Aircrafts_BP(id, name));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return aircraftName;
    }



    public ArrayList<Cities_BP> getAllCity(){
        ArrayList<Cities_BP> cities_bp = new ArrayList<>();
        try{
            PreparedStatement st = connection.prepareStatement("SELECT * FROM cities");
            ResultSet rs = st.executeQuery();

            while (rs.next()){
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                String country = rs.getString("country");
                String short_name = rs.getString("short_name");
                cities_bp.add(new Cities_BP(id, name,country, short_name));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return cities_bp;
    }


    public ArrayList<Cities_BP> getCityName(){
        ArrayList<Cities_BP> cities_bp = new ArrayList<>();
        try{
            PreparedStatement st = connection.prepareStatement("SELECT id, name, short_name  FROM cities");
            ResultSet rs = st.executeQuery();

            while (rs.next()){
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                String short_name = rs.getString("short_name");
                cities_bp.add(new Cities_BP(id, name,short_name));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return cities_bp;
    }



    public ArrayList<Flights_BP> getAllFlights(){
        ArrayList<Flights_BP> flights_bp = new ArrayList<>();
        try{
            PreparedStatement st = connection.prepareStatement("SELECT id, aircraft_id, departure_city_id,arrival_city_id,departure_time,econom_place_price,business_place_price,aircraft_name,departure_city_name,arrival_city_name FROM flights");
            ResultSet rs = st.executeQuery();


            while (rs.next()){
                Long id = rs.getLong("id");
                Long aircraftId = rs.getLong("aircraft_id");
                Long departureCityId = rs.getLong("departure_city_id");
                Long arrivalCityId = rs.getLong("arrival_city_id");
                String departureTime = rs.getString("departure_time");
                int economPlacePrice = rs.getInt("econom_place_price");
                int businessPlacePrice = rs.getInt("business_place_price");
                String aircraft_name = rs.getString("aircraft_name");
                String departure_city_name = rs.getString("departure_city_name");
                String arrival_city_name = rs.getString("arrival_city_name");
                flights_bp.add(new Flights_BP(id, aircraftId, departureCityId,arrivalCityId,departureTime,economPlacePrice,businessPlacePrice,aircraft_name,departure_city_name,arrival_city_name));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return flights_bp;
    }


    public ArrayList<Flights_BP> getFlightsName(){
        ArrayList<Flights_BP> flights_bp = new ArrayList<>();
        try{
            PreparedStatement st = connection.prepareStatement("SELECT id, aircraft_id, departure_city_id,arrival_city_id,departure_time,econom_place_price,business_place_price,aircraft_name,departure_city_name,arrival_city_name FROM flights");
            ResultSet rs = st.executeQuery();


            while (rs.next()){
                Long id = rs.getLong("id");
                Long aircraftId = rs.getLong("aircraft_id");
                Long departureCityId = rs.getLong("departure_city_id");
                Long arrivalCityId = rs.getLong("arrival_city_id");
                String departureTime = rs.getString("departure_time");
                int economPlacePrice = rs.getInt("econom_place_price");
                int businessPlacePrice = rs.getInt("business_place_price");
                String aircraft_name = rs.getString("aircraft_name");
                String departure_city_name = rs.getString("departure_city_name");
                String arrival_city_name = rs.getString("arrival_city_name");
                flights_bp.add(new Flights_BP(id, aircraftId, departureCityId,arrivalCityId,departureTime,economPlacePrice,businessPlacePrice,aircraft_name,departure_city_name,arrival_city_name));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return flights_bp;
    }


    public ArrayList<Tickets_BP> getAllTickets(){
        ArrayList<Tickets_BP> tickets = new ArrayList<>();
        try{
            PreparedStatement st = connection.prepareStatement("SELECT * FROM tickets");//id,flight_id,name,surname,passport_number,ticket_type,strflightName
            ResultSet rs = st.executeQuery();

            while (rs.next()){
                Long id = rs.getLong("id");
                Long flight_id = rs.getLong("flight_id");
                String name = rs.getString("name");
                String surname  = rs.getString("surname");
                String passport_number  = rs.getString("passport_number");
                String ticket_type  = rs.getString("ticket_type");
                String strflightName2  = rs.getString("strflightName");
                tickets.add(new Tickets_BP(id,flight_id,name,surname,passport_number,ticket_type,strflightName2));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return tickets;
    }



    //Добавление
    public void addFlights (Flights_BP flights_bp){
        try{
            PreparedStatement st = connection.prepareStatement("INSERT INTO flights(id,aircraft_id,departure_city_id,arrival_city_id,departure_time,econom_place_price,business_place_price,aircraft_name,departure_city_name,arrival_city_name) VALUE(NULL , ? ,?, ?, ?, ?, ?, ?, ?, ? )");

            st.setLong(1,flights_bp.getAircraft_id());
            st.setLong(2,flights_bp.getDeparture_city_id());
            st.setLong(3,flights_bp.getArrival_city_id());
            st.setString(4,flights_bp.getDeparture_time());
            st.setInt(5,flights_bp.getEconom_place_price());
            st.setInt(6,flights_bp.getBusiness_place_price());
            st.setString(7,flights_bp.getAircraft_name());
            st.setString(8,flights_bp.getDeparture_city_name());
            st.setString(9,flights_bp.getArrival_city_name());

            st.executeUpdate();

            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    //Добавление
    public void addCity (Cities_BP cities_bp){
        try{
            PreparedStatement st = connection.prepareStatement("INSERT INTO cities(id,name,country,short_name) VALUE(NULL , ? ,?, ? )");

            st.setString(1,cities_bp.getName());
            st.setString(2,cities_bp.getCountry());
            st.setString(3,cities_bp.getShort_Name());

            st.executeUpdate();

            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    //Добавление
    public void addAircrafts (Aircrafts_BP aircrafts_bp){
        try{
            PreparedStatement st = connection.prepareStatement("INSERT INTO aircrafts(id,name,model,business_class_capacity,econom_class_capacity) VALUE(NULL , ? ,?, ?, ? )");

            st.setString(1,aircrafts_bp.getName());
            st.setString(2,aircrafts_bp.getModel());
            st.setInt(3,aircrafts_bp.getBusiness_class_capacity());
            st.setInt(4,aircrafts_bp.getEconom_class_capacity());

            st.executeUpdate();

            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //Добавление
    public void addTickets (Tickets_BP tickets){
        try{
            PreparedStatement st = connection.prepareStatement("INSERT INTO tickets(id,flight_id,name,surname,passport_number,ticket_type,strflightName) VALUE(NULL , ? ,?, ?, ?, ?, ? )");

            st.setLong(1,tickets.getFlight_id());
            st.setString(2,tickets.getName());
            st.setString(3,tickets.getSurname());
            st.setString(4,tickets.getPassport_number());
            st.setString(5,tickets.getTicket_type());
            st.setString(6,tickets.getStrflightName());

            st.executeUpdate();

            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    //Update
    public void updateTickets (Tickets_BP tickets){
        try{
            PreparedStatement st = connection.prepareStatement("UPDATE tickets set name = ?,surname = ?,passport_number = ? ,ticket_type = ? where id = ?");
            st.setLong(1,tickets.getFlight_id());
            st.setString(2,tickets.getName());
            st.setString(3,tickets.getSurname());
            st.setString(4,tickets.getPassport_number());
            st.setString(5,tickets.getTicket_type());

            st.executeUpdate();
            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    //Удаление
    public void deleteTickets(Long id){
        try{
            PreparedStatement st = connection.prepareStatement("DELETE FROM tickets where id = ?");
            st.setLong(1,id);
            st.executeUpdate();
            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //Удаление
    public void deleteAircraft(Long id){
        try{
            PreparedStatement st = connection.prepareStatement("DELETE FROM aircrafts where id = ?");
            st.setLong(1,id);
            st.executeUpdate();
            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    //Удаление
    public void deleteCity(Long id){
        try{
            PreparedStatement st = connection.prepareStatement("DELETE FROM cities where id = ?");
            st.setLong(1,id);
            st.executeUpdate();
            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //Удаление
    public void deleteFlight(Long id){
        try{
            PreparedStatement st = connection.prepareStatement("DELETE FROM flights where id = ?");
            st.setLong(1,id);
            st.executeUpdate();
            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
