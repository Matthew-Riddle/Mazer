import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class ScaleAction extends AbstractAction {
	
	Game game;
	
	int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
	int AFC = JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT;
	String SCALE_UP = "scale up";
	String SCALE_DOWN = "scale down";
	
	public ScaleAction(Game game) {
		this.game = game;
		
		game.getInputMap(IFW).put(KeyStroke.getKeyStroke("W"), SCALE_UP);
		game.getInputMap(IFW).put(KeyStroke.getKeyStroke("S"), SCALE_DOWN);
		
		game.getActionMap().put(SCALE_UP, new Scale());
		game.getActionMap().put(SCALE_DOWN, new Scale());
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public class Scale extends AbstractAction {
		
	/**
		 * 
		 */
		private static final long serialVersionUID = -4246213016966463222L;


	@Override
	public void actionPerformed(ActionEvent e) {
		
//		int nImgRatio = game.newImage.getWidth(null) / game.newImage.getHeight(null);
//		System.out.println("new Ratio:" + nImgRatio + " Old: " + game.ratio);
//		if(nImgRatio > game.ratio) {
//			game.tooSmall = true;
//			System.out.println("greater");
//			game.scalex += game.scalarValue;
//			game.scaley += game.scalarValue;
//			game.newImage = game.img.getScaledInstance(game.scalex, game.scaley, Image.SCALE_FAST);
//		}
//		else if(nImgRatio < game.ratio) {
//			game.tooBig = true;
//			game.scalex -= game.scalarValue;
//			game.scaley -= game.scalarValue;
//			game.newImage = game.img.getScaledInstance(game.scalex, game.scaley, Image.SCALE_FAST);
//			
//		}
//		else {
//			game.tooSmall = false;
//			game.tooBig = false;
//			System.out.println("in here");
////			scalex = (int)(scalex * delta);
////			scaley = (int)(scaley * delta);
//			
//		}
		
		if( e.getActionCommand().equals("w")) {
			if(game.tooBig) {
				System.out.println("Cannot go any larger!");
				return;
			}
//			game.scalex += game.scalarValue;
//			game.scaley += game.scalarValue;
			game.xScaleFactor += game.scalarValue;
			game.yScaleFactor += game.scalarValue;
			System.out.println("Scaling up");
		}
		else if( e.getActionCommand().equals("s")) {
			if(game.tooSmall) {
				System.out.println("Cannot go any smaller!");
				return;
			}
//			game.scalex -= game.scalarValue;
//			game.scaley -= game.scalarValue;
			game.xScaleFactor -= game.scalarValue;
			game.yScaleFactor -= game.scalarValue;
			System.out.println("Scaling down");
		}
		
	}
	
}

}

