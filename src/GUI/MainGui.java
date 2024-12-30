package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import Classes.*;
import Vehicle.*;
import GUI.*;


public class MainGui  {

	private static MenuGui gui=new MenuGui();

	public static void main(String[] args) {

		gui.MenuGui();
		gui.setVisible(true);
	}

}