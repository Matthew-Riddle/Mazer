import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class ScaleAction extends AbstractAction {
	
	Game game;
	
	int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
	String SCALE_UP = "scale up";
	String SCALE_DOWN = "scale down";
	
	public ScaleAction(Game game) {
		this.game = game;
		
		game.getInputMap(IFW).put(KeyStroke.getKeyStroke("W"), SCALE_UP);
		game.getInputMap(IFW).put(KeyStroke.getKeyStroke("S"), SCALE_DOWN);
		
		game.getActionMap().put(SCALE_UP, new Scale(1));
		game.getActionMap().put(SCALE_DOWN, new Scale(-1));
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public class Scale extends AbstractAction {
		
	/**
		 * 
		 */
		private static final long serialVersionUID = -4246213016966463222L;

	public Scale(int factor) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if( e.getActionCommand().equals("w")) {
			if(game.tooBig) {
				System.out.println("Cannot go any larger!");
				return;
			}
			game.scalex += 1;
			game.scaley += 1;
			//System.out.println("x: " + game.scalex + " y: " + game.scaley);
			//System.out.println("dont");
			System.out.println("Scaling up");
		}
		if( e.getActionCommand().equals("s")) {
			if(game.tooSmall) {
				System.out.println("Cannot go any smaller!");
				return;
			}
			game.scalex -= 1;
			game.scaley -= 1;
			System.out.println("Scaling down");
		}
		
	}
	
}

}

