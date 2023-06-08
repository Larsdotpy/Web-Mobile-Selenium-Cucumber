package trivago.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class GuestAndRooms {
    private int nrOfAdults;
    private int nrOfChildren;
    private int nrOfRooms;
}
