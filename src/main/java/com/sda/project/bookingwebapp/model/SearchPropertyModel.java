package com.sda.project.bookingwebapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchPropertyModel {

    private String destination;
    private Date checkInDate;
    private Date checkOutDate;
    private int rooms;
    private int adults;
    private int children;

}
