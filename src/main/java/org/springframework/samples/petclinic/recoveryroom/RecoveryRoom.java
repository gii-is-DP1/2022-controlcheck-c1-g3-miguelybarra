package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.samples.petclinic.model.NamedEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="recoveryRooms")
public class RecoveryRoom extends NamedEntity{
	@NotNull
	@Min(value=0)
    double size;
	@NotNull
    boolean secure;
	
	
    @ManyToOne(optional=false)	
    RecoveryRoomType roomType;
}
