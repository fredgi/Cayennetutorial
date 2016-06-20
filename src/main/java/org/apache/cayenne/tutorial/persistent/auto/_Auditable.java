package org.apache.cayenne.tutorial.persistent.auto;

import java.util.Date;
import java.util.UUID;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _Auditable was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Auditable extends CayenneDataObject {

    private static final long serialVersionUID = 1L; 


    public static final Property<Date> CREATION_DATE = new Property<Date>("creationDate");
    public static final Property<UUID> UUID = new Property<UUID>("uuid");

    public void setCreationDate(Date creationDate) {
        writeProperty("creationDate", creationDate);
    }
    public Date getCreationDate() {
        return (Date)readProperty("creationDate");
    }

    public void setUuid(UUID uuid) {
        writeProperty("uuid", uuid);
    }
    public UUID getUuid() {
        return (UUID)readProperty("uuid");
    }

}