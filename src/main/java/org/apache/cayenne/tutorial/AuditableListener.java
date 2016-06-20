/*
 * <!--
 *   /*******************************************************************************
 *    * Copyright (c) 2016 CAPSIEL
 *    * All rights reserved.
 *    * Contributors:
 *    * F.GILBART - initial API and implementation
 *    ******************************************************************************
 *   -->
 */
package org.apache.cayenne.tutorial;

import org.apache.cayenne.annotation.PostAdd;
import org.apache.cayenne.annotation.PrePersist;
import org.apache.cayenne.annotation.PreUpdate;
import org.apache.cayenne.tutorial.persistent.Auditable;

import java.util.Date;

/**
 * Created by fgilbart on 13/06/2016.
 */
public class AuditableListener {
	@PostAdd(Auditable.class)
	public void postAdd(Auditable object) {
//		object.setUuid(UUID.randomUUID());
//		object.setCreationDate(new Date());
	}

	@PrePersist({ Auditable.class })
	public void onPrePersist(Auditable object) {
//		object.setCreationDate(new Date());
	}

	@PreUpdate(Auditable.class)
	public void onPreUpdate(Auditable object) {
		object.setCreationDate(new Date());
	}
	//	@PreUpdate({  Contact.class })
	//	@PrePersist({  Contact.class })
	//	//	@PostPersist(MyEntity1.class)
	//	//	@PostRemove(MyEntity1.class)
	//	//	@PostUpdate(MyEntity1.class)
	//	public void onPrePersistContact(Contact object) {
	//		object.setCreatedBy("ME2");
	//		object.setCreationDate(new Date());
	//	}
	//	@PostLoad({  Enterprise.class })
	//	@PreUpdate({  Enterprise.class })
	//	@PrePersist({ Enterprise.class  })
	//	//	@PostPersist(MyEntity1.class)
	//	//	@PostRemove(MyEntity1.class)
	//	//	@PostUpdate(MyEntity1.class)
	//	public void onPrePersistEnterprise(Enterprise object) {
	//		object.setCreatedBy("ME2");
	//		object.setCreationDate(new Date());
	//	}
	//	@PostAdd(Referenceable.class)
	//	public void onPostAdd(Referenceable r) {
	//		//		setObjectId(java.util.UUID.randomUUID());
	//		r.setUuid(java.util.UUID.randomUUID());
	//	}
}
