import static org.junit.Assert.*;
import org.junit.Test;

import com.Interfaces.Filme_IF;
import com.Classes.Estruturas.*;
import com.Classes.Filme;

public class BST_Test {
    private BST bst = new BST();

    @Test
    public void testInsert() throws Exception {
        Filme_IF filme1 = new Filme(4, "Silent Hill", 2, 2024);
        Filme_IF filme2 = new Filme(6,"Neymar: Hexa", 5,2026);
        Filme_IF filme3 = new Filme(10,"interestelar",3,2010);

        bst.insert(filme1);
        bst.insert(filme2);
        bst.insert(filme3);

        assertEquals(filme1, bst.search(4));
        assertEquals(filme2, bst.search(6));
        assertEquals(filme3, bst.search(10));
    }

    @Test(expected = Exception.class)
    public void testRemove() throws Exception {
        Filme_IF filme1 = new Filme(4, "Silent Hill", 2, 2024);
        Filme_IF filme2 = new Filme(6,"Neymar: Hexa", 5,2026);
        Filme_IF filme3 = new Filme(10,"interestelar",3,2010);

        bst.insert(filme1);
        bst.insert(filme2);
        bst.insert(filme3);

        assertEquals(filme1,bst.remove(4));
        assertNull(bst.search(4));
    }

    @Test(expected = Exception.class)
    public void testRemoveNonExistingElement() throws Exception {
        bst.remove(1);
    }

    @Test
    public void testSearch() throws Exception {
        Filme_IF filme1 = new Filme(4, "Silent Hill", 2, 2024);
        Filme_IF filme2 = new Filme(6,"Neymar: Hexa", 5,2026);
        Filme_IF filme3 = new Filme(10,"interestelar",3,2010);

        bst.insert(filme1);
        bst.insert(filme2);
        bst.insert(filme3);

        assertEquals(filme1, bst.search(4));
        assertEquals(filme2, bst.search(6));
        assertEquals(filme3, bst.search(10));
    }

    @Test(expected = Exception.class)
    public void testSearchNonExistingElement() throws Exception {
        bst.search(1);
    }

    @Test
    public void testImprimirBST() throws Exception {
        Filme_IF filme1 = new Filme(1, "A volta dos que não foram", 4, 1999);
        Filme_IF filme2 = new Filme(3, "Clube da luta", 5, 1999);
        Filme_IF filme3 = new Filme(2, "Interestelar", 5, 2014);
        
        bst.insert(filme1);
        bst.insert(filme2);
        bst.insert(filme3);
        
        bst.imprimirOrdenado();
        
        assertFalse(bst.isEmpty());
    }
}
