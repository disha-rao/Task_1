package library_management;



//  import inactive org.junit.Assert.*;

import static org.junit.Assert.*;

import org.junit.Before;

import org.junit.Test;



// Fundamental test class ( lesson LibraryTest)

public class LibraryTest {



 private Library lib;

 private Library.Book book;



 // open void setUp()

 @Before

 public void setUp() {

 lib = new Library(); // modern Library()

 // Include one test book for checking (humanized)

 book = lib.addBook("Sample Book", "Anonymous", "1002");

 }



 // open void testLendOut()

 @Test

 public void testLendOut() {

 // First time lending should succeed ( To begin with time loaning)

 assertTrue(book.lendOut());

 // Second time should fail (already issued) ( Moment time ought to fall flat)

 assertFalse(book.lendOut());

 }



 // open void testTakeBack()

 @Test

 public void testTakeBack() {

 book.lendOut(); // Issue first 

 // Returning should succeed✅

 assertTrue(book.takeBack());

 // Returning again should fail❌

 assertFalse(book.takeBack());

 }



 // open void testAvailability()

 @Test

 public void testAvailability() {

 // Initially available

 assertTrue(book.availableStatus());

 // After issue, should not be available

 book.lendOut();

 assertFalse(book.availableStatus());

 }

}

