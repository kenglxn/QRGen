package net.glxn.qrgen.core.scheme;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BookmarkTest {

  private static final String BOOKMARK = "MEBKM:URL:google.com;TITLE:Google;;";


  @Test
  public void testParse() {
    Bookmark bookmark = Bookmark.parse(BOOKMARK);
    assertEquals("google.com", bookmark.getUrl());
    assertEquals("Google", bookmark.getTitle());
  }

  @Test
  public void testToString() {
    Bookmark bookmark = new Bookmark();
    bookmark.setUrl("google.com");
    bookmark.setTitle("Google");
    assertEquals(BOOKMARK, bookmark.toString());
  }

}
