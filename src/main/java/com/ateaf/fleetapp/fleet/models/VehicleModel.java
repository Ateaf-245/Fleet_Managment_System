package com.ateaf.fleetapp.fleet.models;

import com.ateaf.fleetapp.parameters.models.CommonObject;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class VehicleModel  extends CommonObject {
}
