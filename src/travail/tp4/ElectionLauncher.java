/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travail.tp4;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.JFrame;


public class ElectionLauncher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		File g=new File("");
		String imageAccueil = g.getAbsolutePath()+"\\images\\felixCat.gif" ; // � personnaliser
		
		Election election = new Election();
		
		JFrame frame;
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		dim.height -= 30;
		frame = new ElectionGui("R�sultat des �lections", election, imageAccueil);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setPreferredSize(dim);
		frame.pack();
		frame.setVisible(true);
	}
}
