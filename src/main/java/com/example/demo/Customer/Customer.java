package com.example.demo.Customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class Customer {

        @Id
        private  Long id;
        @NotBlank(message = "el name")
        private  String name;
        @NotBlank(message = "password ya 3ars")
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        private  String password;
        @NotBlank(message = "email must be not empty")
        @Email
        private  String email;

        @JsonProperty("customer_id")
        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }
        @JsonIgnore
         public String getPassword() {
            return password;
        }
        public String getEmail(){return email;}

}
