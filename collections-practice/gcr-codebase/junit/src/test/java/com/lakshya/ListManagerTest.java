package com.lakshya;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
class ListManagerTest {
    private ListManager listManager;
    private List<Integer> list;
    @BeforeEach
    void setUp() {
        listManager = new ListManager();
        list = new ArrayList<>();
    }
    @Test
    void testAddElement() {
        listManager.addElement(list, 10);
        listManager.addElement(list, 20);
        assertEquals(2, listManager.getSize(list));
        assertTrue(list.contains(10));
        assertTrue(list.contains(20));
    }
    @Test
    void testRemoveElement() {
        list.add(10);
        list.add(20);
        list.add(30);
        listManager.removeElement(list, 20);
        assertEquals(2, listManager.getSize(list));
        assertFalse(list.contains(20));
    }
    @Test
    void testGetSize() {
        assertEquals(0, listManager.getSize(list));
        listManager.addElement(list, 5);
        listManager.addElement(list, 15);
        assertEquals(2, listManager.getSize(list));
    }
}