package org.apache.cayenne.tutorial.persistent;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.query.ObjectSelect;
import org.apache.cayenne.tutorial.AuditableListener;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertNotNull;

/**
 * Created by fgilbart on 20/06/2016.
 */
public class ArtistTest {
	static ServerRuntime runtime = null;
	static ObjectContext context = null;

	@BeforeClass
	public static void init() {
		runtime = new ServerRuntime("cayenne-project.xml");
		runtime.getDataDomain().addListener(new AuditableListener());
		runtime.getDataDomain().setValidatingObjectsOnCommit(true);
		// custom type
		context = runtime.newContext();
	}

	@AfterClass
	public static void close() {
		runtime.shutdown();
	}

	@Test
	public void testCreateArtist_Ko() {
		Artist c = context.newObject(Artist.class);
		c.setName("test");
		c.setCreationDate2(new Date());
		// Now add properties which are in super class Auditable
		c.setUuid(UUID.randomUUID());
		c.setCreationDate(new Date());
		context.commitChanges();
		//
		List<Artist> artists = ObjectSelect.query(Artist.class).select(context);
		for (Artist a : artists) {
			//ok
			assertNotNull(a.getCreationDate2());
			//may pass at first run when tables are created...
			assertNotNull(a.getCreationDate());
			assertNotNull(a.getUuid());
		}
	}

	@Test
	public void testCreateGallery_Ok() {
		Gallery c = context.newObject(Gallery.class);
		c.setName("Pain");
		c.setUuid(UUID.randomUUID());
		c.setCreationDate(new Date());
		context.commitChanges();
		List<Gallery> galleries = ObjectSelect.query(Gallery.class)
				.select(context);
		for (Gallery g : galleries) {
			assertNotNull(g.getCreationDate());
			assertNotNull(g.getUuid());
		}
	}
}