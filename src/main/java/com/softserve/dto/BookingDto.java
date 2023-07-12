package com.softserve.dto;

import com.softserve.model.Hotel;
import com.softserve.model.Room;
import com.softserve.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {
    private Long id;
    @NotBlank
    private String guestFullName;
    @NotBlank
    private String guestEmail;
    @NotBlank
    private String checkInDate;
    @NotBlank
    private String checkOutDate;

    private long roomId;
    private long guestId;
    private long hotelId;
}
