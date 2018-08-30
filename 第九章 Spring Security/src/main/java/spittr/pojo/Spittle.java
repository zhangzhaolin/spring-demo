package spittr.pojo;

import java.sql.Timestamp;
import java.util.Objects;

public class Spittle {

    private final Long id;
    private final String message;
    private final Timestamp time;
    private Double latitude;
    private Double longitude;

    public Spittle(String message , Timestamp time) {
        this(null,message,time,null,null);
    }

    public Spittle(Long id , String message , Timestamp time , Double latitude , Double longitude) {
        this.id = id;
        this.message = message;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
    }


    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Timestamp getTime() {
        return time;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spittle spittle = (Spittle) o;
        return Objects.equals(id , spittle.id) &&
                Objects.equals(message , spittle.message) &&
                Objects.equals(time , spittle.time) &&
                Objects.equals(latitude , spittle.latitude) &&
                Objects.equals(longitude , spittle.longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id , message , time , latitude , longitude);
    }
}
