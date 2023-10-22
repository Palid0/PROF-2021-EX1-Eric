package es.upm.grise.profundizacion.control_1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class LibraryTest {
	Library testLibrary;
	Book book1;
	Book book2;
	Book book3;
	@BeforeEach
		void makeLibrary(){
			testLibrary = new Library();
			book1 = new Book("7 8 9");
			book2 = new Book("El perro sumerio");
			book3 = new Book("Afghan bridenapping for dummies");
		}

	@Test
		void addBookTest(){
		try{
			testLibrary.addBook(book1);
			assertEquals(testLibrary.getBook("7 8 9"), book1);
		} catch(Exception e){
			e.printStackTrace();
			fail();
		}
	}

	@Test
		void addSeveralBooks(){
		try{
			testLibrary.addBook(book1);
			testLibrary.addBook(book2);
			assertEquals(testLibrary.getBook("7 8 9"), book1);
			assertEquals(testLibrary.getBook("El perro sumerio"), book2);
		} catch(Exception e){
			e.printStackTrace();
			fail();
		}
	}

	@Test
		void addRepeatedBook(){
		try{
			testLibrary.addBook(book1);
			assertThrows(DuplicatedBookException.class, () -> testLibrary.addBook(book1));
		} catch(Exception e){
			e.printStackTrace();
			fail();
		}
	}

	@Test
		void removeBookTest(){
		try{
			testLibrary.addBook(book1);
			testLibrary.addBook(book3);
			testLibrary.removeBook(book3);
			//book3 se titula "Afghan bridenapping for dummies"
			assertThrows(NonExistingBookException.class, () -> testLibrary.getBook("Afghan bridenapping for dummies"));
		} catch(Exception e){
			e.printStackTrace();
			fail();
		}
	}

	@Test
		void removeBookEmptyLibraryTest(){
		try{
			assertThrows(IndexOutOfBoundsException.class, () -> testLibrary.removeBook(book3));
		} catch(Exception e){
			e.printStackTrace();
			fail();
		}
	}


	@Test
		void findNonExistingBookTest(){
			try{
				// no hay libro en la librería titulado "La lista negra"
				assertThrows(NonExistingBookException.class, () -> testLibrary.getBook("La lista negra"));
			} catch(Exception e){
				e.printStackTrace();
				fail();
			}
		}

	@Test
		void emptyLibraryTest(){
		try{
			assertThrows(EmptyLibraryException.class, () -> testLibrary.getBook("Afghan bridenapping for dummies"));
		} catch(Exception e){
			e.printStackTrace();
			fail();
		}
	}

	
	//@Test
	//public void test() {
	//	fail();
	//}


}
