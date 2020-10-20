package cegepst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GridManagerTest {

    private GridManager gridManager;

    public GridManagerTest() {
        this.gridManager = new GridManager();
    }

    @Test
    public void testGetGridHeight() {
        assertEquals(7, gridManager.getGridHeight("joshua"));
        assertEquals(18, gridManager.getGridHeight("bonjour le monde"));
        assertEquals(10, gridManager.getGridHeight("El Blanco"));
        assertEquals(27, gridManager.getGridHeight("Une planche de huit pied"));
        assertEquals(13, gridManager.getGridHeight("Miami palms"));
    }

    @Test
    public void testIsLastBlock() {
        assertEquals(true, gridManager.isLastBlock(10, 18));
        assertEquals(false, gridManager.isLastBlock(6, 18));
        assertEquals(false, gridManager.isLastBlock(13, 54));
        assertEquals(true, gridManager.isLastBlock(60, 66));
    }
}
