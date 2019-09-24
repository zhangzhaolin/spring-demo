package spittr.pojo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Spittle {

    private final Long id;
    private final String message;
    private final Timestamp time;
    private Double latitude;
    private Double longitude;

    public Spittle(String message, Timestamp time) {
        this(null, message, time, null, null);
    }

    public Spittle(Long id, String message, Timestamp time, Double latitude, Double longitude) {
        this.id = id;
        this.message = message;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
