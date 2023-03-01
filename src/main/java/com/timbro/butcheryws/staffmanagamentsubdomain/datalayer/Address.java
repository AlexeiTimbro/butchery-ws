package com.timbro.butcheryws.staffmanagamentsubdomain.datalayer;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Embeddable
public class Address {

    private String streetAddress;
    private String city;
    private String province;
    private String country;
    private String postalCode;

    @SuppressWarnings("unused")
    Address() {
    }

    public Address(@NotNull String streetAddress, @NotNull String city, @NotNull String province, @NotNull String country, @NotNull String postalCode) {

        Objects.requireNonNull(this.streetAddress = streetAddress);
        Objects.requireNonNull(this.city = city);
        Objects.requireNonNull(this.province = province);
        Objects.requireNonNull(this.country = country);
        Objects.requireNonNull(this.postalCode = postalCode);

    }

    public @NotNull
    String getStreetAddress() {
        return streetAddress;
    }

    public @NotNull
    String getCity() {
        return city;
    }

    public @NotNull
    String getProvince() {
        return province;
    }

    public @NotNull
    String getCountry() {
        return country;
    }

    public @NotNull
    String getPostalCode() {
        return postalCode;
    }
}