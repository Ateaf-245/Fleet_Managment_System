<<<<<<< HEAD:src/main/java/com/ateaf/fleetapp/accounts/models/Invoice.java
package com.ateaf.fleetapp.accounts.models;
=======
package com.ateaf.fleetapp.models;
import java.util.Date;


import com.ateaf.fleetapp.fleet.models.Vehicle;
import com.ateaf.fleetapp.parameters.models.Supplier;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
>>>>>>> origin/main:src/main/java/com/ateaf/fleetapp/models/VehicleMaintenance.java

import com.ateaf.fleetapp.parameters.models.Client;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date invoiceDate;

    @ManyToOne
    @JoinColumn(name = "invoicestatusid", insertable = false, updatable = false)
    private InvoiceStatus invoiceStatus;
    private Integer invoicestatusid;

    @ManyToOne
    @JoinColumn(name = "clientid", insertable = false, updatable = false)
    private Client client;
    private Integer clientid;

    private String remarks;
}