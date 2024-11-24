package net.ikkowy.iwy.filter;

import lombok.Data;

import java.util.UUID;

@Data
public class LocationFilter {

    private UUID uuid = null;

    private String sortBy = null;

    private boolean descending = false;

}
