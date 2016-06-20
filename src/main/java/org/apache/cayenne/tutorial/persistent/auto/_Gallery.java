package org.apache.cayenne.tutorial.persistent.auto;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;
import org.apache.cayenne.tutorial.persistent.Painting;

/**
 * Class _Gallery was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Gallery extends CayenneDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String ID_PK_COLUMN = "ID";

    public static final Property<Date> CREATION_DATE = new Property<Date>("creationDate");
    public static final Property<String> NAME = new Property<String>("name");
    public static final Property<UUID> UUID = new Property<UUID>("uuid");
    public static final Property<List<Painting>> PAINTINGS = new Property<List<Painting>>("paintings");

    public void setCreationDate(Date creationDate) {
        writeProperty("creationDate", creationDate);
    }
    public Date getCreationDate() {
        return (Date)readProperty("creationDate");
    }

    public void setName(String name) {
        writeProperty("name", name);
    }
    public String getName() {
        return (String)readProperty("name");
    }

    public void setUuid(UUID uuid) {
        writeProperty("uuid", uuid);
    }
    public UUID getUuid() {
        return (UUID)readProperty("uuid");
    }

    public void addToPaintings(Painting obj) {
        addToManyTarget("paintings", obj, true);
    }
    public void removeFromPaintings(Painting obj) {
        removeToManyTarget("paintings", obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<Painting> getPaintings() {
        return (List<Painting>)readProperty("paintings");
    }


}