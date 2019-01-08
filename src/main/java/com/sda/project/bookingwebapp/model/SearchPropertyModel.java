package com.sda.project.bookingwebapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchPropertyModel {

    private String destination;

    @DateTimeFormat(pattern = "dd/MM/yyy")
    private Date checkInDate;

    @DateTimeFormat(pattern = "dd/MM/yyy")
    private Date checkOutDate;

    private int rooms;
    private int adults;
    private int children;

}
